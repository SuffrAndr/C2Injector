package com.miri.blephone.mediainjector.iptv.c2.adi;

/**
 * ADI中元素常量定义
 * @author Night
 */
public interface ADIElementConstants {

    String ID = "ID";
    String ACTION = "Action";
    String CODE = "Code";
    String NAME = "Name";

    String RESULT = "Result";
    String ERROR_DESC = "ErrorDescription";

    String FILE_URL = "FileURL";
    String TYPE = "Type";
    String KEYWORDS = "Keywords";
    String TAGS = "Tags";

    String TAG = "Tag";

    String RESERVE = "Reserve";

    String Price = "Price";

    String ORDERNUMBER = "OrderNumber";
    String ORIGINALNAME = "OriginalName";

    String DESC = "Description";

    String LICENSING_WINDOW_START = "LicensingWindowStart";
    String LICENSING_WINDOW_END = "LicensingWindowEnd";
    String DISPLAYASNEW = "DisplayAsNew";
    String DISPLAYASLASTCHANCE = "DisplayAsLastChance";
    String MACROVISION = "Macrovision";

    String GENRE = "Genre";
    String ACTORDISPLAY = "ActorDisplay";

    // TODO:南传特有的字段
    String COMPERE = "Compere";
    String DURATION = "Duration";

    /**
     * 主要人物
     */
    String KPEOPLE = "Kpeople";

    /**
     * 编剧
     */
    String SCRIPTWRITER = "ScriptWriter";

    String WRITERDISPLAY = "WriterDisplay";
    String LANGUAGE = "Language";
    String RELEASEYEAR = "ReleaseYear";
    String ORIGINALCOUNTRY = "OriginalCountry";

    String CRBEGINDATE = "CRBeginDate";
    String CRENDDATE = "CREndDate";

    String PRODUCEDATE = "produceDate";

    interface Series {
        String SORT_NAME = "SortName";
        String SEARCH_NAME = "SearchName";
        String ORG_AIR_DATE = "OrgAirDate";
        String VOLUMN_COUNT = "VolumnCount";
        String STATUS = "Status";
    }

    interface Program {
        String SORTNAME = "SortName";
        String SEARCHNAME = "SearchName";
        String ORGAIRDATE = "OrgAirDate";
        String PRICETAXIN = "PriceTaxIn";
        String SOURCETYPE = "SourceType";
        String SERIESFLAG = "SeriesFlag";
        String STORAGETYPE = "StorageType";
        String DEFINITIONFLAG = "DefinitionFlag";
    }

    interface Movie {
        String SOURCE_DRM_TYPE = "SourceDRMType";
        String DEST_DRM_TYPE = "DestDRMType";
        String AUDIO_TYPE = "AudioType";
        String SCREEN_FORMAT = "ScreenFormat";
        String CLOSEDCAPTIONING = "ClosedCaptioning";
        String OCSURL = "OCSURL";
        String DURATION = "Duration";
        String FILESIZE = "FileSize";
        String BITRATETYPE = "BitRateType";
        String VIDEOTYPE = "VideoType";
        String AUDIOFORMAT = "AudioFormat";
        String RESOLUTION = "Resolution";
        String VIDEOPROFILE = "VideoProfile";
        String SYSTEMLAYER = "SystemLayer";
        String SERVICETYPE = "ServiceType";
    }

    interface Picture {
        String SEQUENCE = "Sequence";
    }

    interface Value {
        String MACROVISION = "1";
        String STATUS = "1";

        String SOURCETYPE = "1";

        String SERIES_SERIESFLAG = "2";
        String VOD_SERIESFLAG = "1";
    }
}
