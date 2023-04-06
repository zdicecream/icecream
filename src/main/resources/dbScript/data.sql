--时间状态表
INSERT INTO CD_RUNSTATE VALUES(1, '2022-11-04','10','NO','2202-11-04');

--机构表
INSERT INTO SYS_GROUP (ID,GROUP_NAME,GROUP_CODE,STATE) VALUES(1, '核心','0001',1);

--资源表
INSERT INTO SYS_RESOURCE (ID,RESOURCE_CODE,RESOURCE_NAME,ORDERS,TYPE,LEAF) VALUES(1, '000001','首页',1,1,1);
INSERT INTO SYS_RESOURCE (ID,RESOURCE_CODE,RESOURCE_NAME,ORDERS,TYPE,LEAF) VALUES(2, 'myRoleList','首页',1,1,1);
INSERT INTO SYS_RESOURCE (ID,RESOURCE_CODE,RESOURCE_NAME,ORDERS,TYPE,LEAF) VALUES(3, 'myUserList','首页',1,1,1);
INSERT INTO SYS_RESOURCE (ID,RESOURCE_CODE,RESOURCE_NAME,ORDERS,TYPE,LEAF) VALUES(4, 'myResourceList','首页',1,1,1);

--角色表
INSERT INTO SYS_ROLE VALUES(1, '超级管理员',1);

--用户表
INSERT INTO SYS_USER VALUES(1, 'root','111111','用户001','11111111','111@111.com','2022-11-04','2022-11-04','0',1,1);
INSERT INTO SYS_USER VALUES(2, 'admin','111111','用户001','11111111','111@111.com','2022-11-04','2022-11-04','0',1,1);

--用户角色表
INSERT INTO SYS_USER_ROLE VALUES(1,1);
INSERT INTO SYS_ROLE_RESOURCE VALUES(1,1);
INSERT INTO SYS_ROLE_RESOURCE VALUES(1,2);
INSERT INTO SYS_ROLE_RESOURCE VALUES(1,3);
INSERT INTO SYS_ROLE_RESOURCE VALUES(1,4);

INSERT INTO SYS_USER_ROLE VALUES(2,1);



