DROP TABLE IF EXISTS T_MQMSG;

DROP TABLE IF EXISTS T_CATEGORY;

DROP TABLE IF EXISTS T_CLIP;

DROP TABLE IF EXISTS T_POSTER;

DROP TABLE IF EXISTS T_FILE;

DROP TABLE IF EXISTS T_COLUMN;

DROP TABLE IF EXISTS T_CORRELATION;

DROP TABLE IF EXISTS T_STAR;

DROP TABLE IF EXISTS T_WSMSG;

DROP TABLE IF EXISTS T_OBJID;

CREATE TABLE T_MQMSG
(
  ID             BIGINT NOT NULL AUTO_INCREMENT             ,
  PUSHCODE       VARCHAR(64) NOT NULL COMMENT '主键'          ,
  STOREPATH      VARCHAR(2048) NOT NULL COMMENT '存储路径'      ,
  STORETIME      DATETIME COMMENT '获取消息的时间'                 ,
  ASSETTYPE      TINYINT DEFAULT '1' NOT NULL COMMENT '大类型' ,
  ASSETDESC      TINYINT NOT NULL COMMENT '小类型'             ,
  ASSETOPERATION TINYINT COMMENT '操作类型'                     ,
  STATUS         TINYINT DEFAULT '1' NOT NULL COMMENT '状态[1-初始化,2-处理中(解析消息，转换XML),3-处理成功,4-失败,5-消息重复]',
  FEEDBACKSTATUS TINYINT DEFAULT '0' COMMENT '反馈结果:[0-失败,1-成功]' ,
  FEEDBACKTIME   DATETIME COMMENT '反馈时间'                        ,
  REMARK         VARCHAR(4096) COMMENT '备注'                     ,
  PRIMARY KEY(ID)                                               ,
  CONSTRAINT T_MQMSG_ID_IDX UNIQUE(PUSHCODE)                    ,
  INDEX T_MQMSG_IDX_STATUS (STATUS)                             ,
  INDEX T_MQMSG_IDX_FEEDBACKSTATUS (FEEDBACKSTATUS)
)ENGINE = InnoDB DEFAULT CHARSET = utf8;


CREATE TABLE T_CATEGORY
(
    ID              BIGINT NOT NULL AUTO_INCREMENT,
    ASSETID         VARCHAR(64),
    ORIGINALID      VARCHAR(64),    
    BASEID          VARCHAR(64),    
    ASSETPATH       VARCHAR(256),    
    FSTNAME         VARCHAR(64),    
    FSTLVLID        INT,   
    EXTAG           VARCHAR(128),    
    CLIPNAME        VARCHAR(64),    
    OTHERNME        VARCHAR(64),    
    KEYWORD         VARCHAR(4096),    
    DIRECTOR        VARCHAR(512),    
    ADAPTOR         VARCHAR(64),    
    LEADER          VARCHAR(1024),    
    KIND            VARCHAR(512),    
    AREA            VARCHAR(64),   
    `LANGUAGE`      VARCHAR(64),    
    CAPTION         VARCHAR(128),   
    TAGS            VARCHAR(1024),    
    STORY           TEXT,    
    AWARDS          TEXT,
    `YEAR`          INT,    
    DURATION        INT,    
    UPDATETIME      DATETIME,    
    CREATETIME      DATETIME,    
    RELASETIME      DATETIME,    
    PLAYTIME        DATETIME,    
    INITAL          VARCHAR(32),    
    FULLSPELL       VARCHAR(512),    
    SIMPLESPELL     VARCHAR(512),  
    SERIALCOUNT     INT,
    PRODUCTID       INT,    
    PRODUCERNAME    VARCHAR(256), 
    CHANNEL         VARCHAR(64),    
    COUNTRYCODE     VARCHAR(64),
    CANDOWN         INT,
    FILMORSINGLESET INT,    
    PERIODS         VARCHAR(128),
    INITALTIME      DATETIME,
    STATUS          TINYINT DEFAULT '1' COMMENT '1-初始化增加,2-更新后注入,3-删除后注入,4-ADI生成中,5-ADI部署完成,6-注入完成',
    OBJECTID        VARCHAR(16) ,
    PRIMARY KEY(ID),
    CONSTRAINT T_CATEGORY_IDX_ORIGINALID UNIQUE(ORIGINALID),
    INDEX T_CATEGORY_IDX_STATUS (STATUS),
    INDEX T_CATEGORY_IDX_SERIALCOUNT (SERIALCOUNT),
    INDEX T_CATEGORY_IDX_FSTLVLID (FSTLVLID)
)ENGINE = InnoDB DEFAULT CHARSET = utf8;

CREATE TABLE T_CLIP
(
    ID          BIGINT NOT NULL AUTO_INCREMENT,
    ASSETID     VARCHAR(64), 
    ORIASSETID  VARCHAR(64), 
    PARTID      VARCHAR(64), 
    ORIGINALID  VARCHAR(64), 
    PARTNAME    VARCHAR(128),
    OTHERNME    VARCHAR(64), 
    EXTAG       VARCHAR(128),
    EVENTTAG    VARCHAR(128),
    KEYWORD     VARCHAR(4096),
    DIRECTOR    VARCHAR(512),
    ADAPTOR     VARCHAR(64), 
    LEADER      VARCHAR(1024),
    KIND        VARCHAR(512),
    AREA        VARCHAR(64), 
    `LANGUAGE`  VARCHAR(64), 
    CAPTION     VARCHAR(128),
    TAGS        VARCHAR(1024),
    STORY       TEXT,
    AWARDS      TEXT,
    `YEAR`      INT,    
    DURATION    INT,   
    UPDATETIME  DATETIME, 
    CREATETIME  DATETIME, 
    RELASETIME  DATETIME, 
    INITAL      VARCHAR(32), 
    SIMPLESPELL VARCHAR(512),
    ISINTACT    INT,   
    SERIALNO    INT,   
    PUBLISHER   VARCHAR(64), 
    PERIODS     VARCHAR(128),
    INITALTIME  DATETIME,
    STATUS      TINYINT DEFAULT '1' COMMENT '1-初始化增加,2-更新后注入,3-删除后注入,4-ADI生成中,5-ADI部署完成,6-注入完成',
    OBJECTID    VARCHAR(16) ,
    PRIMARY KEY(ID),
    CONSTRAINT T_CLIP_IDX_ORIGINALID UNIQUE(ORIGINALID),
    CONSTRAINT T_CLIP_IDX_ID UNIQUE(ORIASSETID,PARTID,PERIODS),
    INDEX T_CLIP_IDX_STATUS (STATUS)
)ENGINE = InnoDB DEFAULT CHARSET = utf8;

CREATE TABLE T_POSTER
(
    ID          BIGINT NOT NULL AUTO_INCREMENT  ,
    ORIGINALID  VARCHAR(64)                     ,
    IMAGEID     VARCHAR(64)                     , 
    `TYPE`      TINYINT COMMENT '0-集合，1-分集'   ,    
    FILENAME    VARCHAR(2048)                   ,
    RESOLUTION  VARCHAR(64)                     ,
    IMGTYPE     INT                             ,
    FILESIZE    BIGINT                          ,  
    IMGHASH     VARCHAR(64)                     ,    
    INITALTIME  DATETIME                        ,
    OBJECTID    VARCHAR(16)                     ,
    STATUS      TINYINT DEFAULT '0' COMMENT '0-未下载,1-已下载',
    PRIMARY KEY(ID)                             ,
    CONSTRAINT T_POSTER_IDX_ORIGINALID UNIQUE(ORIGINALID,IMAGEID,`TYPE`),
    INDEX T_POSTER_IDX_STATUS (STATUS),
    INDEX T_POSTER_IDX_TYPE (`TYPE`)   
)ENGINE = InnoDB DEFAULT CHARSET = utf8;

CREATE TABLE T_FILE
(
    ID                 BIGINT NOT NULL AUTO_INCREMENT     ,
    FILEID             VARCHAR(64)                        ,
    ORIGINALID         VARCHAR(64)                        ,
    ENTITYFILEID       VARCHAR(64)                        ,
    ASSETID            VARCHAR(64)                        ,
    ORIASSETID         VARCHAR(64)                        ,
    ORIPARTID          VARCHAR(64)                        ,
    PARTID             VARCHAR(64)                        ,
    FILENAME           VARCHAR(256)                       ,
    FILEFORMATDESC     INT                                ,
    FILESIZE           bigint                             ,
    FILEBITRATE        INT                                ,
    FILEDURATION       INT                                ,
    FILEFORMAT         VARCHAR(16)                        ,
    IS3D               INT                                ,
    FILEHASH           VARCHAR(256)                       ,
    VIDEOBITRATE       VARCHAR(32)                        ,
    VIDEOFORMAT        VARCHAR(32)                        ,
    VIDEOINFO          VARCHAR(256)                       ,
    VIDEOINTRODUCTION  VARCHAR(256)                       ,
    VIDEOWIDTH         INT                                ,
    VIDEOHEIGHT        INT                                ,
    VIDEOSCALE         VARCHAR(32)                        ,
    VIDEOLENGTH        INT                                ,
    VIDEOSETCABAC      VARCHAR(32)                        ,
    FORMATSETREFRAMES  VARCHAR(32)                        ,
    FRAMERATE          VARCHAR(32)                        ,
    CRITERION          VARCHAR(64)                        ,
    VGA                VARCHAR(32)                        ,
    COLORIMETRY        VARCHAR(32)                        ,
    SCANTYPE           VARCHAR(32)                        ,
    DATADENSITY        VARCHAR(32)                        ,
    ENCODEDLIBRARY     VARCHAR(32)                        ,
    ENCODEDLIBSET      VARCHAR(64)                        ,
    AUDIOFORMAT        VARCHAR(64)                        ,
    AUDIOINFO          VARCHAR(512)                       ,
    AUDIOINTRODUTION   VARCHAR(512)                       ,
    AUDIOVERSION       VARCHAR(64)                        ,
    AUDIOMUXINGMODE    VARCHAR(64)                        ,
    AUDIODURATION      INT                                ,
    AUDIOTRACK         INT                                ,
    AUDIOSAMPLING      INT                                ,
    AUDIORATEMODE      VARCHAR(64)                        ,
    FILESOURCE         VARCHAR(32)                        ,
    ISDRM              VARCHAR(64)                        ,
    ENCRYPTSOLUTION    VARCHAR(64)                        ,
    THIRDFILEID        VARCHAR(256)                       ,
    OVERALLBITRATEMODE VARCHAR(16)                        ,
    INITALTIME         DATETIME                           ,
	CREATETIME 		   DATETIME							  ,
    STATUS             TINYINT DEFAULT '1' COMMENT '1-初始化增加,2-更新后注入,3-删除后注入,4-ADI生成中,5-ADI部署完成,6-注入完成',
    DOWNLOADSTATUS     TINYINT DEFAULT '1' COMMENT '1-未下载(即缺失),2-已下载(拷贝到硬盘中),3-已经删除(FTP方式适用)',
    OBJECTID           VARCHAR(16)                        ,
    URLPREFIX          VARCHAR(1024)                      ,
    PRIMARY KEY(ID)                                       ,
    CONSTRAINT T_FILE_IDX_ORIGINALID UNIQUE(ORIGINALID)   ,
    CONSTRAINT T_FILE_IDX_ID UNIQUE(ORIASSETID , ORIPARTID , ORIGINALID),
    INDEX T_FILE_IDX_STATUS (STATUS,DOWNLOADSTATUS)       ,
    INDEX T_FILE_IDX_FILEFORMATDESC (FILEFORMATDESC)      ,
    INDEX T_FILE_IDX_UX (ORIPARTID, FILEBITRATE)          
)ENGINE = InnoDB DEFAULT CHARSET = utf8;

CREATE TABLE T_COLUMN
(
    ID              BIGINT NOT NULL AUTO_INCREMENT,
    COLUMNID        VARCHAR(64),
    COLUMNNAME      VARCHAR(64), 
    PARENTID        VARCHAR(64),
    `ORDER`         DOUBLE(11,3),
    EXTENSIONFIELD1 VARCHAR(64),
    UPDATETIME      DATETIME,
    PRIMARY KEY(ID),
    CONSTRAINT T_COLUMN_IDX_COLUMNID UNIQUE(COLUMNID,PARENTID)
)ENGINE = InnoDB DEFAULT CHARSET = utf8;

CREATE TABLE T_CORRELATION
(
    ID              BIGINT NOT NULL AUTO_INCREMENT,
    COLUMNID        VARCHAR(64),
    ASSETID         VARCHAR(64), 
    `ORDER`         DOUBLE(11,3),
    EXTENSIONFIELD1 VARCHAR(64),
    ORIASSETID      VARCHAR(64),    
    UPDATETIME      DATETIME,
    PRIMARY KEY(ID),
    CONSTRAINT T_CORRELATION_IDX_COLUMNID UNIQUE(COLUMNID,ORIASSETID)
)ENGINE = InnoDB DEFAULT CHARSET = utf8;

CREATE TABLE T_STAR
(
    ID              BIGINT NOT NULL AUTO_INCREMENT,
    STARID          VARCHAR(64) ,     
    NAME            VARCHAR(128),
    ENAME           VARCHAR(128), 
    SEX             VARCHAR(16) ,
    BIRTHDAY        DATETIME    ,    
    HOMEPLACE       VARCHAR(256),     
    COLLEGE         VARCHAR(256),   
    NATION          VARCHAR(128),  
    CONSTELLATHION  VARCHAR(32) ,       
    BLOOD           VARCHAR(16) ,
    HEIGHT          DOUBLE(4,1) ,
    WEIGHT          DOUBLE(4,1) ,  
    INTRO           TEXT        , 
    `INITIAL`       VARCHAR(32) ,   
    PHOTOURL        VARCHAR(1024),    
    IMGHASH         VARCHAR(128),   
    FULLSPELL       VARCHAR(128),     
    SIMPLESPELL     VARCHAR(64) ,      
    OCCUPATION      VARCHAR(128),
    UPDATETIME      DATETIME,
    PRIMARY KEY(ID),
    CONSTRAINT T_STAR_IDX_STARID UNIQUE(STARID)
)ENGINE = InnoDB DEFAULT CHARSET = utf8;


CREATE TABLE T_WSMSG
(
    ID              BIGINT NOT NULL AUTO_INCREMENT  , 
    CORRELATEID     VARCHAR(64)                     ,
    STOREPATH       VARCHAR(2048)                   , 
    INITALTIME      DATETIME                        ,
    UPDATETIME      DATETIME                        ,
    ERRORDESC       TEXT                            ,
    RESULTFILEURL   VARCHAR(4096)                   ,
    NOTIFYERRORDESC TEXT                            ,
    STATUS          INT  COMMENT '状态[1-初始化,2-下发成功,3-下发失败,4-接受消息成功,5-接受消息失败],6-注入成功，7-注入失败，8-通知成功，9-通知失败',
    RETRYNUMBER     TINYINT UNSIGNED DEFAULT '0' COMMENT '重试次数，默认为0，一般重试3次',    
    OBJECTID        VARCHAR(16)                     ,
    `TYPE`          INT                             ,
    OPTYPE          INT  COMMENT '操作类型，1-注册，2-更新，3-删除',
    SUBOBJECTID VARCHAR(16) NOT NULL DEFAULT ''     ,
    PRIMARY KEY(ID)                                 ,
    INDEX T_WSMSG_IDX_STATUS (STATUS)                ,
    INDEX T_WSMSG_IDX_UX (OBJECTID, TYPE, OPTYPE)    
)ENGINE = INNODB DEFAULT CHARSET = utf8;

CREATE TABLE T_WSMSG_HISTORY
(
    ID              BIGINT NOT NULL AUTO_INCREMENT  , 
    CORRELATEID     VARCHAR(64)                     ,
    STOREPATH       VARCHAR(2048)                   , 
    INITALTIME      DATETIME                        ,
    UPDATETIME      DATETIME                        ,
    ERRORDESC       TEXT                            ,
    RESULTFILEURL   VARCHAR(4096)                   ,
    NOTIFYERRORDESC TEXT                            ,
    STATUS          INT  COMMENT '状态[1-初始化,2-下发成功,3-下发失败,4-接受消息成功,5-接受消息失败],6-注入成功，7-注入失败，8-通知成功，9-通知失败',
    RETRYNUMBER     TINYINT UNSIGNED DEFAULT '0' COMMENT '重试次数，默认为0，一般重试3次',    
    OBJECTID        VARCHAR(16)                     ,
    `TYPE`          INT                             ,
    OPTYPE          INT  COMMENT '操作类型，1-注册，2-更新，3-删除',
    SUBOBJECTID VARCHAR(16) NOT NULL DEFAULT ''     ,
    PRIMARY KEY(ID)                                 ,
    INDEX T_WSMSG_HISTORY_IDX_STATUS (STATUS)                ,
    INDEX T_WSMSG_HISTORY_IDX_UX (OBJECTID, TYPE, OPTYPE)    
)ENGINE = INNODB DEFAULT CHARSET = utf8;


CREATE TABLE T_OBJID
(
    ID              BIGINT NOT NULL AUTO_INCREMENT  , 
    CURRDATE        VARCHAR(8)                     ,
    `TYPE`          INT   DEFAULT '1' COMMENT   '类型，1-Series，2-Program，3-Movie，4-Picture', 
    SERIALNO        INT                             ,
    PRIMARY KEY(ID)                                 ,
    CONSTRAINT T_OBJID_IDX_UNIQUEID UNIQUE(CURRDATE,TYPE,SERIALNO),
    INDEX T_OBJID_IDX_TYPE (`TYPE`)
)ENGINE = INNODB DEFAULT CHARSET = utf8;    
