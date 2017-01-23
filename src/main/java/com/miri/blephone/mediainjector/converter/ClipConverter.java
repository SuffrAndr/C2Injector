package com.miri.blephone.mediainjector.converter;

import com.google.common.collect.*;
import com.miri.blephone.mediainjector.db.domain.*;
import com.miri.blephone.mediainjector.iptv.c2.adi.*;
import com.miri.blephone.mediainjector.uitls.*;
import org.apache.commons.lang.*;
import org.springframework.stereotype.*;

import java.util.*;

@Component
public class ClipConverter extends AbstractConverter {

    public List<PropertyType> convert(final Category category, final Clip clip, int definition) {
        return this.convert(false, category, clip, definition);
    }

    public List<PropertyType> convert(boolean movieFlag, final Category category, final Clip clip, int definition) {

        String partname = movieFlag ? category.getClipname() : clip.getPartname();

        final PropertyType name = new PropertyType();
        name.setName(ADIElementConstants.NAME);
        name.setValue(partname);

        final PropertyType orderNumber = new PropertyType();
        orderNumber.setName(ADIElementConstants.ORDERNUMBER);
        orderNumber.setValue(StringUtils.EMPTY);

        final PropertyType sortName = new PropertyType();
        sortName.setName(ADIElementConstants.Series.SORT_NAME);
        sortName.setValue(partname);

        final PropertyType searchName = new PropertyType();
        searchName.setName(ADIElementConstants.Series.SEARCH_NAME);
        searchName.setValue(StringUtils.lowerCase(category.getSimplespell(), Locale.US));

        final PropertyType orgAirDate = new PropertyType();
        orgAirDate.setName(ADIElementConstants.Series.ORG_AIR_DATE);
        orgAirDate.setValue(DateUtils.getReleaseDate(clip.getRelasetime()));

        final PropertyType licensingWindowStart = new PropertyType();
        licensingWindowStart.setName(ADIElementConstants.LICENSING_WINDOW_START);
        licensingWindowStart.setValue(DateUtils.getNowDateTime());

        final PropertyType licensingWindowEnd = new PropertyType();
        licensingWindowEnd.setName(ADIElementConstants.LICENSING_WINDOW_END);
        licensingWindowEnd.setValue(DateUtils.getEndDateTime());

        // TODO:修改为volumnCount为剧集号
        final PropertyType volumnCount = new PropertyType();
        volumnCount.setName(ADIElementConstants.Series.VOLUMN_COUNT);
        volumnCount.setValue(String.valueOf(clip.getSerialno()));

        final PropertyType status = new PropertyType();
        status.setName(ADIElementConstants.Series.STATUS);
        status.setValue(ADIElementConstants.Value.STATUS);

        final List<PropertyType> propTypes = Lists.newArrayList(name, orderNumber, sortName, searchName, orgAirDate,
                licensingWindowStart, licensingWindowEnd, volumnCount, status);

        propTypes.add(PropsTypeUtils.buildPropertyType(ADIElementConstants.ORIGINALNAME, partname));
        propTypes.add(PropsTypeUtils.buildPropertyType(ADIElementConstants.DESC, category.getStory()));

        propTypes.add(
                PropsTypeUtils.buildPropertyType(ADIElementConstants.TYPE, this.convertType(category.getFstname())));

        final PropertyType keywords = new PropertyType();
        keywords.setName(ADIElementConstants.KEYWORDS);
        keywords.setValue(StringUtils.replace(category.getKeyword(), " ", ";"));
        propTypes.add(keywords);

        final PropertyType tags = new PropertyType();
        tags.setName(ADIElementConstants.TAGS);
        tags.setValue(this.convertTags(category.getKind()));
        propTypes.add(tags);

        propTypes.add(PropsTypeUtils.buildPropertyType(ADIElementConstants.DISPLAYASNEW, StringUtils.EMPTY));
        propTypes.add(PropsTypeUtils.buildPropertyType(ADIElementConstants.DISPLAYASLASTCHANCE, StringUtils.EMPTY));

        String seriesFlag = movieFlag ? ADIElementConstants.Value.VOD_SERIESFLAG
                : ADIElementConstants.Value.SERIES_SERIESFLAG;

        propTypes.add(PropsTypeUtils.buildPropertyType(ADIElementConstants.Program.SOURCETYPE,
                ADIElementConstants.Value.SOURCETYPE));
        propTypes.add(PropsTypeUtils.buildPropertyType(ADIElementConstants.Program.SERIESFLAG, seriesFlag));

        final PropertyType macrovision = new PropertyType();
        macrovision.setName(ADIElementConstants.MACROVISION);
        propTypes.add(macrovision);

        // propTypes.add(PropsTypeUtils.buildPropertyType(ADIElementConstants.SCRIPTWRITER,
        // AbstractConverter.convertDirector(category.getAdaptor())));
        // propTypes.add(PropsTypeUtils.buildPropertyType(ADIElementConstants.COMPERE,
        // AbstractConverter.convertDirector(category.getAdaptor())));
        // propTypes.add(PropsTypeUtils.buildPropertyType(ADIElementConstants.KPEOPLE,
        // AbstractConverter.convertDirector(category.getLeader())));

        propTypes.add(PropsTypeUtils.buildPropertyType(ADIElementConstants.WRITERDISPLAY,
                AbstractConverter.convertDirector(category.getLeader())));
        propTypes.add(PropsTypeUtils.buildPropertyType(ADIElementConstants.ACTORDISPLAY,
                AbstractConverter.convertDirector(category.getDirector())));

        final PropertyType originalCount = new PropertyType();
        originalCount.setName(ADIElementConstants.ORIGINALCOUNTRY);
        originalCount.setValue(AbstractConverter.convertArea(category.getArea()));
        propTypes.add(originalCount);

        final PropertyType language = new PropertyType();
        language.setName(ADIElementConstants.LANGUAGE);
        language.setValue(category.getLanguage());
        propTypes.add(language);

        final PropertyType releaseYear = new PropertyType();
        releaseYear.setName(ADIElementConstants.RELEASEYEAR);
        releaseYear.setValue(String.valueOf(category.getYear()));
        propTypes.add(releaseYear);

        final PropertyType definitionFlag = new PropertyType();
        definitionFlag.setName(ADIElementConstants.Program.DEFINITIONFLAG);
        definitionFlag.setValue(String.valueOf(convertDefinition(definition)));
        propTypes.add(definitionFlag);

        // propTypes.add(PropsTypeUtils.buildPropertyType(ADIElementConstants.DURATION,
        // AbstractConverter.convertDuration(clip.getDuration())));

        // propTypes.add(PropsTypeUtils.buildPriceProps());
        // propTypes.addAll(PropsTypeUtils.buildReserveProps());

        return propTypes;
    }

}
