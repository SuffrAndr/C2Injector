package com.miri.blephone.mediainjector.mgtv.category;

import java.io.File;
import java.util.Date;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.apache.commons.lang.math.NumberUtils;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.joda.time.LocalDate;

import com.miri.blephone.mediainjector.db.domain.Category;
import com.miri.blephone.mediainjector.mgtv.api.category.UpdateCategoryAssetContent;
import com.miri.blephone.mediainjector.mgtv.api.category.UpdateCategoryContent;

public class CategoryTest {
    public static void main(final String[] args) {
        try {
            final JAXBContext jaxb = JAXBContext.newInstance(UpdateCategoryAssetContent.class);

            // final CategoryObjectFactory factory = new CategoryObjectFactory();
            //
            // final UpdateCategoryAssetContent assetcontent =
            // factory.createAssetcontent();
            //
            // assetcontent.setAssetdesc(1);
            // assetcontent.setAssetoperation(1);
            // assetcontent.setAssettype(1);
            //
            // final Content content = factory.createAssetcontentContent();
            //
            // content.setAssetid(UUID.randomUUID().toString());
            //
            // final Info info = factory.createAssetcontentInfo();
            // info.setContentprovider("asas");
            // info.setPushcode("asas");
            // info.setQueuename("1212");
            //
            // assetcontent.setContent(content);
            // assetcontent.setInfo(info);
            //
            // final Marshaller marshaller = jaxb.createMarshaller();
            //
            // marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            // marshaller.marshal(assetcontent, System.out);

            final Unmarshaller unmarshaller = jaxb.createUnmarshaller();

            final File f = new File("E:/Asset/mq/2016/7/18/4A1B76F4ACAE4AC0A5FBAA0FACA48F9F.xml");

            final UpdateCategoryAssetContent categoryAssetcontent = (UpdateCategoryAssetContent) unmarshaller
                    .unmarshal(f);

            Mapper dozerMapper = new DozerBeanMapper();

            final UpdateCategoryContent categoryContent = categoryAssetcontent.getContent();

            Category category = dozerMapper.map(categoryContent, Category.class);

            // TODO:避免出现日期小于1970的年份
            Date relasetime = category.getRelasetime();
            if (relasetime != null) {
                int tYear = LocalDate.fromDateFields(relasetime).getYear();

                if (tYear <= 1970) {
                    relasetime = category.getCreatetime();
                }
            }

            int year = category.getYear();
            if (year == NumberUtils.INTEGER_ZERO && relasetime != null) {
                category.setYear(LocalDate.fromDateFields(relasetime).getYear());
            }

            System.out.println(ToStringBuilder.reflectionToString(category, ToStringStyle.MULTI_LINE_STYLE));

        }
        catch (final JAXBException e) {
            e.printStackTrace();
        }
    }
}
