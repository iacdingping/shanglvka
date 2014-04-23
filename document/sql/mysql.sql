--------------------------------------------------
--          系统表
--------------------------------------------------

CREATE TABLE "SYS_LOG" 
(	
"ID" NUMBER(18), 
"MESSAGE" VARCHAR2(1000 BYTE), 
"IP" VARCHAR2(30 BYTE), 
"USER_NAME" VARCHAR2(50 BYTE), 
"MODULE_NAME" VARCHAR2(100 BYTE), 
"CREATE_TIME" DATE, 
"DELETED" NUMBER(1), 
CONSTRAINT "PK_LOG_ID" PRIMARY KEY ("ID")
);

COMMENT ON COLUMN "SYS_LOG"."ID" IS '编号';

COMMENT ON COLUMN "SYS_LOG"."MESSAGE" IS '操作描述';

COMMENT ON COLUMN "SYS_LOG"."IP" IS '访问用户ip（用户操作时用的电脑ip）';

COMMENT ON COLUMN "SYS_LOG"."USER_NAME" IS '登陆用户名';

COMMENT ON COLUMN "SYS_LOG"."CREATE_TIME" IS '操作时间';

COMMENT ON COLUMN "SYS_LOG"."MODULE_NAME" IS '操作的模块名';

COMMENT ON COLUMN "SYS_LOG"."DELETED" IS '是否删除';



CREATE TABLE "SYS_RESOURCE" 
(	
"ID" NUMBER(18), 
"NAME" VARCHAR2(30 BYTE), 
"URL" VARCHAR2(100 BYTE), 
"TYPE" NUMBER, 
"PARENT_ID" NUMBER, 
"ICONNAME" VARCHAR2(50 BYTE), 
"CREATE_TIME" DATE DEFAULT sysdate, 
"DELETED" NUMBER(1) DEFAULT 0, 
CONSTRAINT "PK_RESOURCE_ID" PRIMARY KEY ("ID")
);


COMMENT ON COLUMN "SYS_RESOURCE"."ID" IS '唯一编号';

COMMENT ON COLUMN "SYS_RESOURCE"."NAME" IS '资源名称';

COMMENT ON COLUMN "SYS_RESOURCE"."URL" IS '访问url';

COMMENT ON COLUMN "SYS_RESOURCE"."TYPE" IS '资源类型，1：菜单资源，2：按钮资源';

COMMENT ON COLUMN "SYS_RESOURCE"."PARENT_ID" IS '父id';

COMMENT ON COLUMN "SYS_RESOURCE"."ICONNAME" IS '图标名称';

COMMENT ON COLUMN "SYS_RESOURCE"."DELETED" IS '是否删除；默认1使用，2删除';

COMMENT ON COLUMN "SYS_RESOURCE"."CREATE_TIME" IS '创建时间';


CREATE TABLE "SYS_ROLE" 
(	
"ID" NUMBER(18), 
"NAME" VARCHAR2(50 BYTE), 
"CREATE_TIME" DATE DEFAULT sysdate,
"DELETED" NUMBER DEFAULT 0, 
CONSTRAINT "PK_ROLE_ID" PRIMARY KEY ("ID")
);


COMMENT ON COLUMN "SYS_ROLE"."ID" IS 'ID';

COMMENT ON COLUMN "SYS_ROLE"."NAME" IS '名称';

COMMENT ON COLUMN "SYS_ROLE"."DELETED" IS '是否删除;默认1使用，2删除';

COMMENT ON COLUMN "SYS_ROLE"."CREATE_TIME" IS '创建时间';


CREATE TABLE "SYS_ROLE_RESOURCE" 
(	
"ID" NUMBER(18), 
"ROLE_ID" NUMBER(18), 
"RESOURCE_ID" NUMBER, 
"CREATE_TIME" DATE DEFAULT sysdate, 
"DELETED" NUMBER(1) DEFAULT 0,
CONSTRAINT "PK_ROLE_RESOURCE_ID" PRIMARY KEY ("ID")
);


COMMENT ON COLUMN "SYS_ROLE_RESOURCE"."ROLE_ID" IS '角色编号';

COMMENT ON COLUMN "SYS_ROLE_RESOURCE"."RESOURCE_ID" IS '资源编号';


CREATE TABLE "SYS_USER" 
(	"ID" NUMBER(18), 
"NAME" VARCHAR2(30 BYTE), 
"PASSWORD" VARCHAR2(200 BYTE), 
"REAL_NAME" VARCHAR2(50 BYTE), 
"TEL" VARCHAR2(30 BYTE), 
"EMAIL" VARCHAR2(100 BYTE), 
"ROLE_ID" NUMBER, 
"TYPE" NUMBER, 
"CREATE_TIME" DATE DEFAULT sysdate, 
"IS_LOGIN" NUMBER, 
"DELETED" NUMBER(1) DEFAULT 0, 
CONSTRAINT "PK_USER_ID" PRIMARY KEY ("ID")
);


COMMENT ON COLUMN "SYS_USER"."ID" IS 'ID';

COMMENT ON COLUMN "SYS_USER"."NAME" IS '用户名';

COMMENT ON COLUMN "SYS_USER"."PASSWORD" IS '密码';

COMMENT ON COLUMN "SYS_USER"."CREATE_TIME" IS '    创建时间';

COMMENT ON COLUMN "SYS_USER"."REAL_NAME" IS '真实姓名';

COMMENT ON COLUMN "SYS_USER"."TEL" IS '电话';

COMMENT ON COLUMN "SYS_USER"."EMAIL" IS '邮箱';

COMMENT ON COLUMN "SYS_USER"."ROLE_ID" IS '角色编号';

COMMENT ON COLUMN "SYS_USER"."TYPE" IS '状态;默认1启用，2停用';

COMMENT ON COLUMN "SYS_USER"."DELETED" IS '是否删除;默认1使用，2删除';

COMMENT ON COLUMN "SYS_USER"."IS_LOGIN" IS '是否登陆过，备用';


CREATE TABLE "SYS_USER_ROLE" 
(	
"ID" NUMBER(18) NOT NULL ENABLE, 
"USER_ID" NUMBER(18), 
"ROLE_ID" NUMBER(18), 
"CREATE_TIME" DATE DEFAULT sysdate, 
"DELETED" NUMBER(1) DEFAULT 0, 
CONSTRAINT "PK_USER_ROLE_ID" PRIMARY KEY ("ID")
);


COMMENT ON COLUMN "SYS_USER_ROLE"."USER_ID" IS '用户id';

COMMENT ON COLUMN "SYS_USER_ROLE"."ROLE_ID" IS '角色id';


CREATE TABLE "SYS_WORDBOOK" 
(	
"ID" NUMBER(18), 
"NAME" VARCHAR2(100 BYTE), 
"VALUE" NUMBER, 
"TYPE_ID" NUMBER, 
"NAME_DESCRIBE" VARCHAR2(100 BYTE), 
"STORE_VALUE" VARCHAR2(50 BYTE), 
"CREATE_TIME" DATE DEFAULT sysdate, 
"DELETED" NUMBER(1) DEFAULT 0, 
CONSTRAINT "PK_WORDBOOK" PRIMARY KEY ("ID")
);


COMMENT ON COLUMN "SYS_WORDBOOK"."ID" IS '编号';

COMMENT ON COLUMN "SYS_WORDBOOK"."NAME" IS '字典名称';

COMMENT ON COLUMN "SYS_WORDBOOK"."VALUE" IS '字典值';

COMMENT ON COLUMN "SYS_WORDBOOK"."TYPE_ID" IS '类型码';

COMMENT ON COLUMN "SYS_WORDBOOK"."NAME_DESCRIBE" IS '字典描述';

COMMENT ON COLUMN "SYS_WORDBOOK"."STORE_VALUE" IS '备用值';



--------------------------------------------------
--          应用表
--------------------------------------------------