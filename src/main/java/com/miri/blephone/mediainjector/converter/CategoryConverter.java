package com.miri.blephone.mediainjector.converter;

import java.util.*;

import org.apache.commons.lang.*;
import org.springframework.stereotype.*;

import com.google.common.collect.*;
import com.miri.blephone.mediainjector.db.domain.*;
import com.miri.blephone.mediainjector.iptv.c2.adi.*;
import com.miri.blephone.mediainjector.uitls.*;

@Component
public class CategoryConverter extends AbstractConverter {

    public List<PropertyType> convert(final Category a) {

        final String clipname = a.getClipname();
        final PropertyType name = new PropertyType();
        name.setName(ADIElementConstants.NAME);
        name.setValue(clipname);

        final PropertyType orderNumber = new PropertyType();
        orderNumber.setName(ADIElementConstants.ORDERNUMBER);
        orderNumber.setValue(StringUtils.EMPTY);

        final PropertyType sortName = new PropertyType();
        sortName.setName(ADIElementConstants.Series.SORT_NAME);
        sortName.setValue(clipname);

        final PropertyType searchName = new PropertyType();
        searchName.setName(ADIElementConstants.Series.SEARCH_NAME);
        searchName.setValue(StringUtils.lowerCase(a.getSimplespell(), Locale.US));

        final PropertyType orgAirDate = new PropertyType();
        orgAirDate.setName(ADIElementConstants.Series.ORG_AIR_DATE);
        orgAirDate.setValue(DateUtils.getReleaseDate(a.getRelasetime()));

        final PropertyType licensingWindowStart = new PropertyType();
        licensingWindowStart.setName(ADIElementConstants.LICENSING_WINDOW_START);
        licensingWindowStart.setValue(DateUtils.getNowDateTime());

        final PropertyType licensingWindowEnd = new PropertyType();
        licensingWindowEnd.setName(ADIElementConstants.LICENSING_WINDOW_END);
        licensingWindowEnd.setValue(DateUtils.getEndDateTime());

        final PropertyType volumnCount = new PropertyType();
        volumnCount.setName(ADIElementConstants.Series.VOLUMN_COUNT);

        // TODO:对于综艺，不设置总集数
        String serialCount = String.valueOf(a.getSerialcount());
        // String convertType = this.convertType(a.getFstname());
        // if (StringUtils.equalsIgnoreCase(convertType, "zy")) {
        // serialCount = StringUtils.EMPTY;
        // }
        volumnCount.setValue(serialCount);

        final PropertyType status = new PropertyType();
        status.setName(ADIElementConstants.Series.STATUS);
        status.setValue(ADIElementConstants.Value.STATUS);

        final List<PropertyType> propTypes = Lists.newArrayList(name, orderNumber, sortName, searchName, orgAirDate,
                licensingWindowStart, licensingWindowEnd, volumnCount, status);

        final PropertyType desc = new PropertyType();
        desc.setName(ADIElementConstants.DESC);
        desc.setValue(a.getStory());
        propTypes.add(desc);

        propTypes.add(PropsTypeUtils.buildPropertyType(ADIElementConstants.TYPE, a.getFstname()));

        final PropertyType keywords = new PropertyType();
        keywords.setName(ADIElementConstants.KEYWORDS);
        keywords.setValue(StringUtils.replace(a.getKeyword(), " ", ";"));
        propTypes.add(keywords);

        final PropertyType tags = new PropertyType();
        tags.setName(ADIElementConstants.TAGS);
        tags.setValue(this.convertTags(a.getKind()));
        propTypes.add(tags);

        // final PropertyType tag = new PropertyType();
        // tag.setName(ADIElementConstants.TAG);
        // tag.setValue(AbstractConverter.convertKind(a.getKind()));
        // propTypes.add(tag);

        final PropertyType displayAsNew = new PropertyType();
        displayAsNew.setName(ADIElementConstants.DISPLAYASNEW);
        propTypes.add(displayAsNew);

        final PropertyType displayAsLastChance = new PropertyType();
        displayAsLastChance.setName(ADIElementConstants.DISPLAYASLASTCHANCE);
        propTypes.add(displayAsLastChance);

        final PropertyType macrovision = new PropertyType();
        macrovision.setName(ADIElementConstants.MACROVISION);
        propTypes.add(macrovision);

        final PropertyType price = new PropertyType();
        price.setName(ADIElementConstants.Price);
        propTypes.add(price);

        // propTypes.add(PropsTypeUtils.buildPropertyType(ADIElementConstants.Program.SOURCETYPE,
        // ADIElementConstants.Value.SOURCETYPE));
        // propTypes.add(PropsTypeUtils.buildPropertyType(ADIElementConstants.Program.SERIESFLAG,
        // ADIElementConstants.Value.SERIES_SERIESFLAG));

        // propTypes.add(PropsTypeUtils.buildPropertyType(ADIElementConstants.SCRIPTWRITER,
        // AbstractConverter.convertDirector(a.getAdaptor())));
        // propTypes.add(PropsTypeUtils.buildPropertyType(ADIElementConstants.COMPERE,
        // AbstractConverter.convertDirector(a.getAdaptor())));
        // propTypes.add(PropsTypeUtils.buildPropertyType(ADIElementConstants.KPEOPLE,
        // AbstractConverter.convertDirector(a.getLeader())));

        // propTypes.add(PropsTypeUtils.buildPropertyType(ADIElementConstants.WRITERDISPLAY,
        // AbstractConverter.convertDirector(a.getLeader())));
        // propTypes.add(PropsTypeUtils.buildPropertyType(ADIElementConstants.ACTORDISPLAY,
        // AbstractConverter.convertDirector(a.getDirector())));

        // propTypes.add(PropsTypeUtils.buildOrderNumber());
        propTypes.add(PropsTypeUtils.buildPropertyType(ADIElementConstants.ORIGINALNAME, clipname));
        // propTypes.add(PropsTypeUtils.buildPropertyType(ADIElementConstants.LANGUAGE,
        // a.getLanguage()));
        // propTypes.add(PropsTypeUtils.buildPropertyType(ADIElementConstants.RELEASEYEAR,
        // String.valueOf(a.getYear())));

        // propTypes.add(PropsTypeUtils.buildPropertyType(ADIElementConstants.ORIGINALCOUNTRY,
        // AbstractConverter.convertArea(a.getArea())));

        // propTypes.add(PropsTypeUtils.buildPropertyType(ADIElementConstants.DISPLAYASNEW,
        // StringUtils.EMPTY));
        // propTypes.add(PropsTypeUtils.buildPropertyType(ADIElementConstants.DISPLAYASLASTCHANCE,
        // StringUtils.EMPTY));

        // propTypes.add(PropsTypeUtils.buildPriceProps());
        //
        // propTypes.addAll(PropsTypeUtils.buildReserveProps());

        return propTypes;
    }
}
