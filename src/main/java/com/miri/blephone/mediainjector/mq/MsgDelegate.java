package com.miri.blephone.mediainjector.mq;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.List;

import javax.xml.bind.JAXBException;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.CharEncoding;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.apache.commons.lang.math.NumberUtils;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpRequestRetryHandler;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Lists;
import com.miri.blephone.mediainjector.config.ConfigConstants;
import com.miri.blephone.mediainjector.config.GlobalConfig;
import com.miri.blephone.mediainjector.db.DBConstans;
import com.miri.blephone.mediainjector.db.dao.DbRepository;
import com.miri.blephone.mediainjector.db.domain.MQMsg;
import com.miri.blephone.mediainjector.mgtv.XmlMapperWrapper;
import com.miri.blephone.mediainjector.mgtv.api.AssetContent;
import com.miri.blephone.mediainjector.mgtv.api.AssetContentConstants;
import com.miri.blephone.mediainjector.mgtv.api.Image;
import com.miri.blephone.mediainjector.mgtv.api.category.DeleteCategoryAssetContent;
import com.miri.blephone.mediainjector.mgtv.api.category.UpdateCategoryAssetContent;
import com.miri.blephone.mediainjector.mgtv.api.clip.DeleteClipAssetContent;
import com.miri.blephone.mediainjector.mgtv.api.clip.UpdateClipAssetContent;
import com.miri.blephone.mediainjector.mgtv.api.column.ColumnAssetContent;
import com.miri.blephone.mediainjector.mgtv.api.correlation.CorrelationAssetContent;
import com.miri.blephone.mediainjector.mgtv.api.correlation.CorrelationContent;
import com.miri.blephone.mediainjector.mgtv.api.file.DeleteFileAssetContent;
import com.miri.blephone.mediainjector.mgtv.api.file.UpdateFileAssetContent;
import com.miri.blephone.mediainjector.mgtv.api.star.DeleteStarAssetContent;
import com.miri.blephone.mediainjector.mgtv.api.star.UpdateStarAssetContent;
import com.miri.blephone.mediainjector.mgtv.notify.FeedbackResult;
import com.miri.blephone.mediainjector.mgtv.notify.NotfyResult;
import com.miri.blephone.mediainjector.mgtv.notify.NotfyResultInfo;
import com.miri.blephone.mediainjector.uitls.UrlUtils;

@Component
public class MsgDelegate implements InitializingBean {

    private static final Logger DLOG         = LoggerFactory.getLogger(MsgDelegate.class);

    @Autowired
    private XmlMapperWrapper    xmlMapperWrapper;

    @Autowired
    private DbRepository        dbRepository;

    private final GlobalConfig  globalConfig = GlobalConfig.getInstance();

    private final ObjectMapper  objectMapper = new ObjectMapper();

    private String              mqStorePath;

    /**
     * @param msg 消息内容
     * @return 处理结果
     */
    public boolean storeMQMsg(final String msg) {

        boolean handleMsgFlag = true;

        String pushcode = StringUtils.EMPTY;
        try (final StringReader reader = new StringReader(msg);) {

            final AssetContent content = (AssetContent) this.xmlMapperWrapper.getAssetContentUnmarshaller()
                    .unmarshal(reader);

            pushcode = content.getInfo().getPushcode();
            final String storeFilePath = this.storeFile(pushcode, msg);

            final MQMsg mQMsg = MQMsgBuilder.buildMQMsg(storeFilePath, content.getAssettype(), content.getAssetdesc(),
                    content.getAssetoperation(), pushcode);

            // TODO:设置为处理中
            short status = DBConstans.MQMsgStatus.INIT;
            mQMsg.setStatus(status);
            this.dbRepository.saveOrUpdateMsg(mQMsg);

            // TODO:进行通知MGTV
            this.notfyResult(mQMsg);

            mQMsg.setStatus(DBConstans.MQMsgStatus.PROCESSING);
            this.dbRepository.saveOrUpdateMsg(mQMsg);

            return handleMsgFlag;
        }
        catch (final Exception e) {

            handleMsgFlag = false;
            MsgDelegate.DLOG.error(String.format("Process %s fail.", pushcode), e);
        }

        return handleMsgFlag;
    }

    /**
     * @param msg 消息内容
     * @return 处理结果
     */
    public boolean handle(final String msg) {

        String pushcode = StringUtils.EMPTY;
        try (final StringReader reader = new StringReader(msg);) {

            final AssetContent content = (AssetContent) this.xmlMapperWrapper.getAssetContentUnmarshaller()
                    .unmarshal(reader);

            pushcode = content.getInfo().getPushcode();
            final String storeFilePath = this.storeFile(pushcode, msg);

            final MQMsg mQMsg = MQMsgBuilder.buildMQMsg(storeFilePath, content.getAssettype(), content.getAssetdesc(),
                    content.getAssetoperation(), pushcode);

            // TODO:设置为处理中
            short status = DBConstans.MQMsgStatus.PROCESSING;
            mQMsg.setStatus(status);
            this.dbRepository.saveOrUpdateMsg(mQMsg);

            final Long id = mQMsg.getId();

            // TODO:保存到数据库中
            final boolean handleMsgFlag = this.handleMsg(msg, content);

            MsgDelegate.DLOG.info("Store db result {}", handleMsgFlag);

            status = handleMsgFlag ? DBConstans.MQMsgStatus.SUCESS : DBConstans.MQMsgStatus.FAIL;
            mQMsg.setStatus(status);
            this.dbRepository.updateMsgStatus(id, mQMsg.getStatus());

            MsgDelegate.DLOG.info("MQMsg is {}",
                    ToStringBuilder.reflectionToString(mQMsg, ToStringStyle.SHORT_PREFIX_STYLE));

            // TODO:进行通知MGTV
            this.notfyResult(mQMsg);

            this.dbRepository.saveOrUpdateMsg(mQMsg);

            return handleMsgFlag;
        }
        catch (final Exception e) {
            MsgDelegate.DLOG.error(String.format("Process %s fail.", pushcode), e);
        }

        return false;
    }

    public void notfyResult(final MQMsg mQMsg) {

        final boolean flag = mQMsg.getStatus() == DBConstans.MQMsgStatus.INIT;
        final String msg = flag ? "success" : mQMsg.getRemark();
        final int state = flag ? NumberUtils.INTEGER_ONE : NumberUtils.INTEGER_ZERO;

        final NotfyResult notfyResult = new NotfyResult();
        notfyResult.setMsgid(mQMsg.getPushcode());
        notfyResult.setMsg(msg);

        notfyResult.setState(state);

        final NotfyResultInfo info = new NotfyResultInfo();
        info.setSiteId(this.globalConfig.getString(ConfigConstants.MGTV.MQ_SITE_ID));
        info.setAssetType(Integer.valueOf(mQMsg.getAssetType()));

        int feedbackStatus = 0;
        String remark = StringUtils.EMPTY;

        try (final StringWriter writer = new StringWriter();
                final CloseableHttpClient httpclient = HttpClients.custom()
                        .setRetryHandler(new DefaultHttpRequestRetryHandler(3, false)).build();) {

            this.xmlMapperWrapper.getNotfyResultMarshaller().marshal(notfyResult, writer);

            final String value = writer.toString();

            final HttpPost httpPost = new HttpPost(this.globalConfig.getString(ConfigConstants.MGTV.NOTIFY_URL));

            final List<NameValuePair> nvps = Lists.newArrayList(new BasicNameValuePair("cmsresult", value));

            httpPost.setEntity(new UrlEncodedFormEntity(nvps));

            MsgDelegate.DLOG.info("Feedback result to mgtv,pushcode is {}", mQMsg.getPushcode());

            final HttpResponse rsp = httpclient.execute(httpPost);

            if (rsp.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {

                final String entityVal = EntityUtils.toString(rsp.getEntity(), CharEncoding.UTF_8);

                MsgDelegate.DLOG.info("Feedback result to mgtv,rsp is {}", entityVal);

                if (StringUtils.isNotBlank(entityVal)) {
                    final FeedbackResult fr = this.objectMapper.readValue(entityVal, FeedbackResult.class);

                    if (fr != null) {
                        feedbackStatus = fr.getResult();
                    }
                }
            }
        }
        catch (final Exception e) {
            MsgDelegate.DLOG.error("Post msg to mgtv fail.", e);
            remark = e.getMessage();
        }

        mQMsg.setFeedbackStatus(feedbackStatus);
        mQMsg.setFeedbackTime(DateTime.now().toDate());
        mQMsg.setRemark(remark);

    }

    /**
     * @param msg
     * @param assetContent
     * @param storePath
     * @return
     * @throws IOException
     * @throws JAXBException
     */
    private boolean handleMsg(final String msg, final AssetContent assetContent) throws IOException, JAXBException {
        final short assetType = assetContent.getAssettype();
        final short assetDesc = assetContent.getAssetdesc();
        final short assetOperation = assetContent.getAssetoperation();

        boolean flag = true;

        try (final StringReader reader = new StringReader(msg);) {

            if (assetType == AssetContentConstants.ASSET_TYPE_VIDEO) {

                // 处理集合
                if (assetDesc == AssetContentConstants.ASSET_DESC_CLIP) {

                    if (assetOperation == AssetContentConstants.ASSET_OPERATION_ADD_OR_UPDATE) {

                        final UpdateCategoryAssetContent updateCategoryAssetContent = (UpdateCategoryAssetContent) this.xmlMapperWrapper
                                .getUpdateCategoryAssetContentUnmarshaller().unmarshal(reader);

                        this.downloadImg(updateCategoryAssetContent.getContent().getImages().getImage());
                        this.dbRepository.saveOrUpdateCategory(updateCategoryAssetContent);
                    }

                    if (assetOperation == AssetContentConstants.ASSET_OPERATION_DELETE) {

                        final DeleteCategoryAssetContent updateCategoryAssetContent = (DeleteCategoryAssetContent) this.xmlMapperWrapper
                                .getDeleteCategoryAssetContenttUnmarshaller().unmarshal(reader);

                        this.dbRepository.deleteCategory(updateCategoryAssetContent);
                    }
                }

                // 处理分集
                if (assetDesc == AssetContentConstants.ASSET_DESC_CLIPPART) {
                    if (assetOperation == AssetContentConstants.ASSET_OPERATION_ADD_OR_UPDATE) {
                        final UpdateClipAssetContent updateClipAssetContent = (UpdateClipAssetContent) this.xmlMapperWrapper
                                .getUpdateClipAssetContentUnmarshaller().unmarshal(reader);

                        this.downloadImg(updateClipAssetContent.getContent().getImages().getImage());
                        this.dbRepository.saveOrUpdateClip(updateClipAssetContent);
                    }

                    if (assetOperation == AssetContentConstants.ASSET_OPERATION_DELETE) {
                        final DeleteClipAssetContent deleteClipAssetContent = (DeleteClipAssetContent) this.xmlMapperWrapper
                                .getDeleteClipAssetContentUnmarshaller().unmarshal(reader);

                        this.dbRepository.deleteClip(deleteClipAssetContent);
                    }
                }

                // 处理文件
                if (assetDesc == AssetContentConstants.ASSET_DESC_FILE) {
                    if (assetOperation == AssetContentConstants.ASSET_OPERATION_ADD_OR_UPDATE) {
                        final UpdateFileAssetContent updateFileAssetContent = (UpdateFileAssetContent) this.xmlMapperWrapper
                                .getUpdateFileAssetContentUnmarshaller().unmarshal(reader);

                        this.dbRepository.saveOrUpdateFile(updateFileAssetContent);
                    }
                    else if (assetOperation == AssetContentConstants.ASSET_OPERATION_DELETE) {
                        final DeleteFileAssetContent deleteFileAssetContent = (DeleteFileAssetContent) this.xmlMapperWrapper
                                .getDeleteFileAssetContentUnmarshaller().unmarshal(reader);

                        this.dbRepository.deleteFile(deleteFileAssetContent);
                    }
                }

                if (assetDesc == AssetContentConstants.ASSET_DESC_COLUMN) {

                    final ColumnAssetContent columnAssetContent = (ColumnAssetContent) this.xmlMapperWrapper
                            .getColumnAssetContentUnmarshaller().unmarshal(reader);

                    // TODO:添加栏目
                    if (assetOperation == AssetContentConstants.ASSET_OPERATION_ADD_OR_UPDATE) {

                        this.dbRepository.saveOrUpdateColumn(columnAssetContent);
                    }

                    // TODO:删除栏目
                    if (assetOperation == AssetContentConstants.ASSET_OPERATION_DELETE) {
                        this.dbRepository.deleteColumn(columnAssetContent.getContent().getColumnid());
                    }
                }

                if (assetDesc == AssetContentConstants.ASSET_DESC_CORRELATION) {

                    final CorrelationAssetContent correlationAssetContent = (CorrelationAssetContent) this.xmlMapperWrapper
                            .getCorrelationAssetContentUnmarshaller().unmarshal(reader);

                    // TODO:添加关系
                    if (assetOperation == AssetContentConstants.ASSET_OPERATION_ADD_OR_UPDATE) {

                        this.dbRepository.saveOrUpdateCorrelation(correlationAssetContent);
                    }

                    // TODO:删除关系
                    if (assetOperation == AssetContentConstants.ASSET_OPERATION_DELETE) {

                        final CorrelationContent content = correlationAssetContent.getContent();

                        this.dbRepository.deleteCorrelation(content.getColumnid(), content.getOriassetid());
                    }
                }
            }

            // TODO:处理明星
            else if (assetType == AssetContentConstants.ASSET_TYPE_STAR) {

                if (assetOperation == AssetContentConstants.ASSET_OPERATION_ADD_OR_UPDATE) {

                    final UpdateStarAssetContent updateStarAssetContent = (UpdateStarAssetContent) this.xmlMapperWrapper
                            .getUpdateStarAssetContentUnmarshaller().unmarshal(reader);

                    this.dbRepository.saveOrUpdateStar(updateStarAssetContent.getContent());
                }

                if (assetOperation == AssetContentConstants.ASSET_OPERATION_DELETE) {
                    final DeleteStarAssetContent deleteStarAssetContent = (DeleteStarAssetContent) this.xmlMapperWrapper
                            .getDeleteStarAssetContentUnmarshaller().unmarshal(reader);

                    this.dbRepository.deleteStar(deleteStarAssetContent.getContent().getId());
                }
            }
            else {
                // TODO:暂时不支持。
            }

        }
        catch (Exception e) {

            flag = false;

            MsgDelegate.DLOG.error("handleMsg fail.", e);
        }

        return flag;
    }

    private void downloadImg(final List<Image> images) {

        if (CollectionUtils.isNotEmpty(images)) {

            final CloseableHttpClient httpclient = HttpClients.custom()
                    .setRetryHandler(new DefaultHttpRequestRetryHandler(1, true)).build();

            final String httpPrfix = this.globalConfig.getString(ConfigConstants.MGTV.IMG_URL);
            final String storePath = this.globalConfig.getString(ConfigConstants.MGTV.IMG_STOREPATH);
            for (final Image image : images) {

                if (image.getImgtype().intValue() == DBConstans.ImageType.TRANSVERSE
                        || image.getImgtype().intValue() == DBConstans.ImageType.VERTICAL) {

                    try {

                        String url = UrlUtils.getUrl(httpPrfix, image.getFilename());

                        MsgDelegate.DLOG.debug("Download img[{}].", url);

                        final HttpGet httpGet = new HttpGet(url);

                        final CloseableHttpResponse rsp = httpclient.execute(httpGet);

                        int statusCode = rsp.getStatusLine().getStatusCode();

                        MsgDelegate.DLOG.debug("Download img[{}].statusCode is {}", url, statusCode);

                        if (statusCode == HttpStatus.SC_OK) {

                            InputStream input = null;
                            FileOutputStream output = null;
                            try {

                                input = rsp.getEntity().getContent();

                                String fileName = UrlUtils.getFileName(image.getFilename());
                                String dir = FilenameUtils.getFullPath(fileName);

                                final File file = new File(storePath, dir);

                                if (!file.exists()) {
                                    file.mkdirs();
                                }

                                File tempFile = new File(file, FilenameUtils.getName(fileName));

                                if (!tempFile.exists()) {
                                    tempFile.createNewFile();
                                }
                                else {
                                    tempFile.delete();
                                }

                                output = new FileOutputStream(tempFile);

                                IOUtils.copy(input, output);

                                MsgDelegate.DLOG.debug("Store img {} sucess.", tempFile.getCanonicalPath());
                            }
                            catch (final Exception e) {
                                MsgDelegate.DLOG.error("Download img fail.", e);
                            }
                            finally {
                                IOUtils.closeQuietly(output);
                                IOUtils.closeQuietly(input);
                            }
                        }
                        else {
                            MsgDelegate.DLOG.error("Download img[{}] fail.statusCode is {}", url, statusCode);
                        }

                        try {
                            rsp.close();
                        }
                        catch (Exception e) {
                            MsgDelegate.DLOG.error("Rsp close fail.", e);
                        }
                    }
                    catch (final Exception e) {
                        MsgDelegate.DLOG.error("Download img fail.", e);
                    }
                }
            }

            try {
                httpclient.close();
            }
            catch (IOException e) {
                MsgDelegate.DLOG.error("httpclient close fail.", e);
            }
        }
    }

    private String storeFile(final String pushcode, final String msg) throws IOException {

        final DateTime dateTime = new DateTime();

        // TODO:保存文件
        final String fileName = pushcode + ".xml";

        final String dirPath = String.format("%s/%s/%s", dateTime.getYear(), dateTime.getMonthOfYear(),
                dateTime.getDayOfMonth());

        final File dirPathFile = new File(this.mqStorePath, dirPath);

        if (!dirPathFile.exists()) {
            dirPathFile.mkdirs();
        }

        final File xmlFile = new File(dirPathFile, fileName);

        FileUtils.write(xmlFile, msg, CharEncoding.UTF_8);

        return String.format("%s/%s", dirPath, fileName);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        this.mqStorePath = this.globalConfig.getString(ConfigConstants.MGTV.MQ_STOREPATH);
    }

    public void handle(MQMsg mQMsg) throws IOException, JAXBException {

        File file = new File(this.mqStorePath, mQMsg.getStorePath());

        String msg = FileUtils.readFileToString(file, CharEncoding.UTF_8);

        final Long id = mQMsg.getId();

        AssetContent content = new AssetContent();
        content.setAssetdesc(mQMsg.getAssetDesc());
        content.setAssetoperation(mQMsg.getAssetOperation());
        content.setAssettype(mQMsg.getAssetType());

        // TODO:保存到数据库中
        final boolean handleMsgFlag = this.handleMsg(msg, content);

        short status = handleMsgFlag ? DBConstans.MQMsgStatus.SUCESS : DBConstans.MQMsgStatus.FAIL;
        MsgDelegate.DLOG.info("Store db result {}", handleMsgFlag);

        mQMsg.setStatus(status);
        this.dbRepository.updateMsgStatus(id, mQMsg.getStatus());
    }
}
