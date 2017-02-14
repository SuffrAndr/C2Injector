package com.miri.blephone.mediainjector.db.dao;

import java.util.Date;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.apache.commons.lang.math.NumberUtils;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.miri.blephone.mediainjector.config.ConfigConstants;
import com.miri.blephone.mediainjector.config.GlobalConfig;
import com.miri.blephone.mediainjector.db.DBConstans;
import com.miri.blephone.mediainjector.db.domain.Category;
import com.miri.blephone.mediainjector.db.domain.Clip;
import com.miri.blephone.mediainjector.db.domain.Column;
import com.miri.blephone.mediainjector.db.domain.Correlation;
import com.miri.blephone.mediainjector.db.domain.File;
import com.miri.blephone.mediainjector.db.domain.MQMsg;
import com.miri.blephone.mediainjector.db.domain.ObjectId;
import com.miri.blephone.mediainjector.db.domain.Poster;
import com.miri.blephone.mediainjector.db.domain.Star;
import com.miri.blephone.mediainjector.db.domain.WsMsg;
import com.miri.blephone.mediainjector.db.mapper.CategoryMapper;
import com.miri.blephone.mediainjector.db.mapper.ClipMapper;
import com.miri.blephone.mediainjector.db.mapper.ColumnMapper;
import com.miri.blephone.mediainjector.db.mapper.CorrelationMapper;
import com.miri.blephone.mediainjector.db.mapper.FileMapper;
import com.miri.blephone.mediainjector.db.mapper.MQMsgMapper;
import com.miri.blephone.mediainjector.db.mapper.ObjectIdMapper;
import com.miri.blephone.mediainjector.db.mapper.PosterMapper;
import com.miri.blephone.mediainjector.db.mapper.StarMapper;
import com.miri.blephone.mediainjector.db.mapper.WsMsgMapper;
import com.miri.blephone.mediainjector.mgtv.api.Image;
import com.miri.blephone.mediainjector.mgtv.api.category.DeleteCategoryAssetContent;
import com.miri.blephone.mediainjector.mgtv.api.category.DeleteCategoryContent;
import com.miri.blephone.mediainjector.mgtv.api.category.UpdateCategoryAssetContent;
import com.miri.blephone.mediainjector.mgtv.api.category.UpdateCategoryContent;
import com.miri.blephone.mediainjector.mgtv.api.clip.DeleteClipAssetContent;
import com.miri.blephone.mediainjector.mgtv.api.clip.UpdateClipAssetContent;
import com.miri.blephone.mediainjector.mgtv.api.clip.UpdateClipContent;
import com.miri.blephone.mediainjector.mgtv.api.column.ColumnAssetContent;
import com.miri.blephone.mediainjector.mgtv.api.column.ColumnContent;
import com.miri.blephone.mediainjector.mgtv.api.correlation.CorrelationAssetContent;
import com.miri.blephone.mediainjector.mgtv.api.file.DeleteFileAssetContent;
import com.miri.blephone.mediainjector.mgtv.api.file.UpdateFileAssetContent;
import com.miri.blephone.mediainjector.mgtv.api.file.VideoFile;
import com.miri.blephone.mediainjector.mgtv.api.star.UpdateStarAssetContent;
import com.miri.blephone.mediainjector.mgtv.api.star.UpdateStarContent;
import com.miri.blephone.mediainjector.uitls.DateUtils;
import com.miri.blephone.mediainjector.uitls.IdUtils;
import com.miri.blephone.mediainjector.uitls.PinyinUtils;

@Repository
@Transactional
public class DbRepository {

    private static final Logger DLOG         = LoggerFactory.getLogger(DbRepository.class);

    @Autowired
    private CategoryMapper      categoryMapper;

    @Autowired
    private ClipMapper          clipMapper;

    @Autowired
    private FileMapper          fileMapper;

    @Autowired
    private MQMsgMapper         mQMsgMapper;

    @Autowired
    private PosterMapper        posterMapper;

    @Autowired
    private ColumnMapper        columnMapper;

    @Autowired
    private CorrelationMapper   correlationMapper;

    @Autowired
    private WsMsgMapper         wsMsgMapper;

    @Autowired
    private StarMapper          starMapper;

    @Autowired
    private ObjectIdMapper      objectIdMapper;

    private final GlobalConfig  globalConfig = GlobalConfig.getInstance();

    private final Mapper        dozerMapper  = new DozerBeanMapper();

    public void saveOrUpdateMsg(final MQMsg mQMsg) {
        final String pushcode = mQMsg.getPushcode();
        final MQMsg msg = this.mQMsgMapper.queryByPushcode(pushcode);
        if (msg != null) {
            mQMsg.setId(msg.getId());
            this.mQMsgMapper.updateMsg(mQMsg);
        }
        else {
            this.mQMsgMapper.add(mQMsg);
        }
    }

    public List<MQMsg> queryMqMsgByStatus(final short status) {
        return this.mQMsgMapper.queryByStatus(status);
    }

    public void updateMsgStatus(final long id, final short status) {
        this.mQMsgMapper.updateMsgStatus(id, status);
    }

    public Category queryCategoryByOriginalId(final String originalId) {
        return this.categoryMapper.queryByOriginalId(originalId);
    }

    public List<Category> querySeriesCategory(final int status) {
        final List<Category> categories = this.categoryMapper.querySeriesByStatus(status);
        return categories;
    }

    /**
     * 查询电影
     * @param status
     * @return
     */
    public List<Category> queryMovicesByStatus(final int status) {
        final List<Category> categories = this.categoryMapper.queryMovicesByStatus(status);
        return categories;
    }

    public List<Poster> queryPosterByOriginalId(final String originalId, final short type) {
        final List<Poster> posters = this.posterMapper.queryInectByOriginalId(originalId, type);
        return posters;
    }

    public void updateCategoryStatus(final String originalId, final int status) {
        this.categoryMapper.updateStatusByOriginalId(originalId, status);
    }

    public Category saveOrUpdateCategory(final UpdateCategoryAssetContent content) {

        final UpdateCategoryContent categoryContent = content.getContent();

        final Category category = this.dozerMapper.map(categoryContent, Category.class);

        DbRepository.DLOG.debug("category is {}",
                ToStringBuilder.reflectionToString(category, ToStringStyle.SHORT_PREFIX_STYLE));

        // TODO:更新时间设值为当前时间
        category.setUpdatetime(DateTime.now().toDate());

        final String originalId = category.getOriginalid();

        final List<Image> images = categoryContent.getImages().getImage();

        final String clipname = category.getClipname();

        // TODO:设置简拼
        final String simplespell = category.getSimplespell();
        if (StringUtils.isBlank(simplespell)) {
            category.setSimplespell(PinyinUtils.getPinYinHeadChar(clipname));
        }

        // TODO:设置全拼
        final String fullspell = category.getFullspell();
        if (StringUtils.isBlank(fullspell)) {
            category.setFullspell(PinyinUtils.getPinYinHeadChar(clipname));
        }

        // TODO:避免出现日期小于1970的年份
        Date relasetime = category.getRelasetime();
        if (relasetime != null) {
            final int tYear = LocalDate.fromDateFields(relasetime).getYear();

            if (tYear <= 1970) {
                relasetime = category.getCreatetime();
            }
        }

        // TODO:设置上映年限，如果没有直接从ReleaseTime中获取年份
        final int year = category.getYear();
        if (year == NumberUtils.INTEGER_ZERO && relasetime != null) {
            category.setYear(LocalDate.fromDateFields(relasetime).getYear());
        }

        final Category tmpCategory = this.categoryMapper.queryByOriginalId(originalId);

        DbRepository.DLOG.debug("category is {}",
                ToStringBuilder.reflectionToString(category, ToStringStyle.SHORT_PREFIX_STYLE));

        if (tmpCategory != null) {

            // TODO:重新注入
            category.setStatus(DBConstans.AssetStatus.INIT_ADD);
            this.categoryMapper.updateByOriginalId(category);
        }
        else {

            category.setObjectId(this.buildObjId(ObjectId.ObjectType.SERIES));
            this.categoryMapper.add(category);

            for (final Image image : images) {

                // TODO:广东只需要1和2的图
                if (image.getImgtype().intValue() == DBConstans.ImageType.TRANSVERSE
                        || image.getImgtype().intValue() == DBConstans.ImageType.VERTICAL) {

                    final Poster poster = this.dozerMapper.map(image, Poster.class);
                    poster.setOriginalid(originalId);
                    poster.setType(Poster.PosterType.CATEGORY);

                    poster.setObjectId(this.buildObjId(ObjectId.ObjectType.PICTURE));
                    this.posterMapper.add(poster);
                }
            }
        }
        return category;
    }

    public void deleteCategory(final DeleteCategoryAssetContent content) {

        final DeleteCategoryContent categoryContent = content.getContent();

        final String originalId = categoryContent.getOriginalid();

        if (1 == this.categoryMapper.countByOriginalId(originalId)) {
            this.categoryMapper.updateStatusByOriginalId(originalId, DBConstans.AssetStatus.DELETE);
        }
    }

    public void saveOrUpdateClip(final UpdateClipAssetContent content) {

        final UpdateClipContent updateClipContent = content.getContent();

        final List<Image> images = updateClipContent.getImages().getImage();

        final Clip clip = this.dozerMapper.map(updateClipContent, Clip.class);

        // TODO:更新时间设值为当前时间
        clip.setUpdatetime(DateTime.now().toDate());

        final String originalId = clip.getOriginalid();

        final String partname = clip.getPartname();

        // TODO:设置简拼
        final String simplespell = clip.getSimplespell();
        if (StringUtils.isBlank(simplespell)) {
            clip.setSimplespell(PinyinUtils.getPinYinHeadChar(partname));
        }

        // TODO:避免出现日期小于1970的年份
        Date relasetime = clip.getRelasetime();
        if (relasetime != null) {
            final int tYear = LocalDate.fromDateFields(relasetime).getYear();

            if (tYear <= 1970) {
                relasetime = clip.getCreatetime();
            }
        }

        // TODO:设置上映年限，如果没有直接从ReleaseTime中获取年份
        final int year = clip.getYear();
        if (year == NumberUtils.INTEGER_ZERO && relasetime != null) {
            clip.setYear(LocalDate.fromDateFields(relasetime).getYear());
        }

        final Clip tmpClip = this.clipMapper.queryByOriginalId(originalId);
        if (tmpClip != null) {

            // TODO:重新注入
            clip.setStatus(DBConstans.AssetStatus.INIT_ADD);
            this.clipMapper.updateByOriginalId(clip);
        }
        else {

            for (final Image image : images) {

                // TODO:广东只需要1和2的图
                if (image.getImgtype().intValue() == DBConstans.ImageType.TRANSVERSE
                        || image.getImgtype().intValue() == DBConstans.ImageType.VERTICAL) {

                    final Poster poster = this.dozerMapper.map(image, Poster.class);
                    poster.setOriginalid(originalId);
                    poster.setType(Poster.PosterType.CLIP);

                    poster.setObjectId(this.buildObjId(ObjectId.ObjectType.PICTURE));
                    this.posterMapper.add(poster);
                }
            }

            clip.setObjectId(this.buildObjId(ObjectId.ObjectType.PROGRAM));
            this.clipMapper.add(clip);
        }
    }

    public void deleteClip(final DeleteClipAssetContent content) {

        final String originalId = content.getContent().getOriginalid();

        final Clip clip = this.clipMapper.queryByOriginalId(originalId);

        if (clip != null) {
            clip.setStatus(DBConstans.AssetStatus.DELETE);
            this.clipMapper.updateByOriginalId(clip);
        }
    }

    public List<Clip> queryClipSeriesByStatus(final int clipStatus, final int categoryStatus) {
        return this.clipMapper.querySeriesByStatus(clipStatus, categoryStatus);
    }

    public List<Clip> queryMovicesByStatus(final int clipStatus, final int categoryStatus) {
        return this.clipMapper.queryMovicesByStatus(clipStatus, categoryStatus);
    }

    public void updateClipStatus(final String originalId, final int status) {
        this.clipMapper.updateStatusByOriginalId(originalId, status);
    }

    public void updateFileStatus(final String originalId, final int status) {
        this.fileMapper.updateStatusByOriginalId(originalId, status);
    }

    public List<Clip> queryClipsByStatus(final int status) {
        return this.clipMapper.queryByStatus(status);
    }

    public List<Clip> queryClipsByOriassetId(final String oriassetId) {
        return this.clipMapper.queryByOriassetId(oriassetId);
    }

    public Clip queryClipObjectId(final String objectId) {
        return this.clipMapper.queryByObjectId(objectId);
    }

    public void saveOrUpdateFile(final UpdateFileAssetContent content) {

        final List<VideoFile> videoFiles = content.getContent().getVideos().getFile();

        for (final VideoFile videoFile : videoFiles) {

            // TODO:只是存储高清文件，对于标清和流程，直接跳过，保障每种只有一个一个文件
            final int fileformatdesc = videoFile.getFileformatdesc();
            if (fileformatdesc >= 2) {

                final String objectId = videoFile.getOriginalid();

                final File file = this.dozerMapper.map(videoFile, File.class);

                // TODO:增加对于专线的处理
                final int downloadStatus = this.isSpecial() ? DBConstans.FileDownload.YES : DBConstans.FileDownload.NO;
                file.setDownloadStatus(downloadStatus);

                final File tmpVideoFile = this.fileMapper.queryByOriginalId(objectId);

                if (tmpVideoFile != null) {

                    // TODO:文件名称不一致的情况下，进行更新
                    if (tmpVideoFile.getCreatetime() != null) {
                        // TODO:如果时间比当前新，则更新,即文件有变化，进行重新注入数据
                        if (file.getCreatetime().after(tmpVideoFile.getCreatetime())) {
                            this.fileMapper.updateByOriginalId(file);
                            this.clipMapper.updateStatusByOriginalId(file.getOripartid(), file.getStatus());
                        }
                    }
                }
                else {

                    // TODO:如果已经存在的文件和对应的清晰度已经存在，且时间比当前的旧，则原有的文件状态设置为回收状态
                    final List<File> files = this.fileMapper.queryByFileformatdesc(file.getOripartid(), fileformatdesc,
                            file.getCreatetime());

                    if (CollectionUtils.isNotEmpty(files)) {

                        // TODO:旧文件需要修改为回收状态，同时重置单集状态
                        for (final File tmpFile : files) {
                            this.fileMapper.updateStatusAndDownloadStatusByOriginalId(tmpFile.getOriginalid(),
                                    DBConstans.AssetStatus.DELETE, DBConstans.FileDownload.YES);
                        }

                        this.clipMapper.updateStatusByOriginalId(file.getOripartid(), file.getStatus());
                    }

                    // TODO:更新时间设值为当前时间
                    file.setInitalTime(DateTime.now().toDate());
                    file.setObjectId(this.buildObjId(ObjectId.ObjectType.MOVIE));
                    this.fileMapper.add(file);
                }
            }
        }
    }

    public void deleteFile(final DeleteFileAssetContent content) {

        final String originalId = content.getContent().getOriginalid();

        final File tmpVideoFile = this.fileMapper.queryByOriginalId(originalId);
        if (tmpVideoFile != null) {
            // TODO:更新状态即可，不做删除处理
            this.fileMapper.updateStatusAndDownloadStatusByOriginalId(originalId, DBConstans.AssetStatus.DELETE,
                    DBConstans.FileDownload.YES);
        }
    }

    public List<File> queryFilesByOripartId(final String oripartId) {
        return this.fileMapper.queryByOripartId(oripartId);
    }

    /**
     * 更新栏目信息
     * @param column {@link Column}
     */
    public void saveOrUpdateColumn(final ColumnAssetContent columnAssetContent) {

        final ColumnContent content = columnAssetContent.getContent();

        final Column column = this.dozerMapper.map(content, Column.class);
        final String columnid = column.getColumnid();

        if (1 == this.columnMapper.countByColumnId(columnid)) {
            this.columnMapper.update(column);
        }
        else {
            this.columnMapper.add(column);
        }
    }

    /**
     * 删除栏目信息
     */
    public void deleteColumn(final String columnId) {

        this.columnMapper.delete(columnId);
    }

    /**
     * 跟新关系
     * @param correlation {@link CorrelationAssetContent}
     */
    public void saveOrUpdateCorrelation(final CorrelationAssetContent correlationAssetContent) {

        final Correlation correlation = this.dozerMapper.map(correlationAssetContent.getContent(), Correlation.class);

        if (1 == this.correlationMapper.countByCorrelation(correlation.getColumnid(), correlation.getAssetid())) {
            this.correlationMapper.update(correlation);
        }
        else {
            this.correlationMapper.add(correlation);
        }
    }

    /**
     * 删除关系
     */
    public void deleteCorrelation(final String columnId, final String oriassetid) {

        this.correlationMapper.delete(columnId, oriassetid);
    }

    /**
     * 跟新关系
     * @param correlation {@link UpdateStarAssetContent}
     */
    public void saveOrUpdateStar(final UpdateStarContent starContent) {

        final Star star = this.dozerMapper.map(starContent, Star.class);

        if (1 == this.starMapper.countByStarlId(star.getStarid())) {
            this.starMapper.update(star);
        }
        else {
            this.starMapper.add(star);
        }
    }

    /**
     * 删除关系
     */
    public void deleteStar(final String starId) {

        this.starMapper.delete(starId);
    }

    public void addWSMsg(final WsMsg wsMsg) {
        this.wsMsgMapper.add(wsMsg);
    }

    public List<WsMsg> queryWsMsgs(final WsMsg wsMsg) {
        return this.wsMsgMapper.queryWsMsgs(wsMsg);
    }

    public List<WsMsg> queryWSMsgStaus(final List<Integer> status) {
        return this.wsMsgMapper.queryByStatus(status);
    }

    public List<WsMsg> queryWSMsgByCorrelateId(final String correlateId) {
        return this.wsMsgMapper.queryByCorrelateId(correlateId);
    }

    public void updateWSMsgStatus(final WsMsg wsMsg) {
        this.wsMsgMapper.update(wsMsg);
    }

    public void updateSeriesStatusByObjectId(final int type, final String objectId, final int status) {
        if (type == ObjectId.ObjectType.SERIES) {
            this.categoryMapper.updateStatusByObjectId(objectId, status);
        }
    }

    public void updateStatusByObjectId(final int type, final String objectId, String subObjectId, final int status) {

        if (type == ObjectId.ObjectType.SERIES) {
            this.categoryMapper.updateStatusByObjectId(objectId, status);
        }

        if (type == ObjectId.ObjectType.PROGRAM) {

            // TODO:判断是否进行更新状态，如果没有进行全部更新
            final Clip clip = this.clipMapper.queryByObjectId(objectId);

            if (clip != null) {

                final Category category = this.categoryMapper.queryByOriginalId(clip.getOriassetid());

                if (category.getStatus() == DBConstans.AssetStatus.ADI_DEPLOYED) {
                    this.categoryMapper.updateStatusByObjectId(category.getObjectId(), status);
                }

                this.clipMapper.updateStatusByObjectId(objectId, status);

                if (StringUtils.isNotBlank(subObjectId)) {
                    this.fileMapper.updateStatusByObjectId(subObjectId, status);
                }
            }
        }

        if (type == ObjectId.ObjectType.MOVIE) {
            this.fileMapper.updateStatusByObjectId(objectId, status);
        }
    }

    public synchronized String buildObjId(final int type) {

        final String currDate = DateUtils.getDate(DateTime.now().toDate());

        ObjectId objectId = this.objectIdMapper.query(currDate, type);

        if (objectId == null) {
            objectId = new ObjectId();
            objectId.setCurrDate(currDate);
            objectId.setType(type);
            objectId.setSerialNo(NumberUtils.INTEGER_ONE);

            this.objectIdMapper.add(objectId);

            return IdUtils.buildObjectId(type, currDate, objectId.getSerialNo());
        }
        else {

            objectId.setSerialNo(objectId.getSerialNo() + NumberUtils.INTEGER_ONE);

            this.objectIdMapper.update(objectId);

            return IdUtils.buildObjectId(type, currDate, objectId.getSerialNo());
        }
    }

    public void updateDownloadStatusByOriginalId(final String originalId, final int downloadStatus) {
        this.fileMapper.updateDownloadStatusByOriginalId(originalId, downloadStatus);
    }

    public List<File> queryExpireFiles() {
        return this.fileMapper.queryExpireFiles();
    }

    private boolean isSpecial() {
        final int transferType = this.globalConfig.getInt(ConfigConstants.MGTV.MEDIA_TRANSFERTYPE);
        return transferType == ConfigConstants.Values.SPECIAL_TRANSFERTYPE;
    }
}
