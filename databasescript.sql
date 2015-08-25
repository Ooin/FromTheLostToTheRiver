BEGIN TRANSACTION;
CREATE TABLE `TRANSPORT` (
	`id`	INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE,
	`name`	TEXT NOT NULL UNIQUE
);
INSERT INTO `TRANSPORT` (id,name) VALUES (1,'Linea 5 azul');
INSERT INTO `TRANSPORT` (id,name) VALUES (43,'Cercanias2073022563');
INSERT INTO `TRANSPORT` (id,name) VALUES (44,'Cercanias-1113616273');
INSERT INTO `TRANSPORT` (id,name) VALUES (47,'Cercanias-1969514901');
CREATE TABLE `STOPLINE` (
	`stopId`	INTEGER NOT NULL,
	`lineId`	INTEGER NOT NULL,
        FOREIGN KEY(stopId) REFERENCES STOP(id),
        FOREIGN KEY(lineId) REFERENCES LINE(id),
        PRIMARY KEY(stopId, lineId)
    
);
CREATE TABLE `STOP` (
	`id`	INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE,
	`addressId`	INTEGER NOT NULL,
        FOREIGN KEY(addressId) REFERENCES ADDRESS(id)
);
CREATE TABLE "STEPROUTE" (
	`fatherId`	INTEGER NOT NULL,
	`stepId`	INTEGER NOT NULL,
	PRIMARY KEY(fatherId,stepId),
	FOREIGN KEY(`fatherId`) REFERENCES ROUTE_FATHER ( id ),
	FOREIGN KEY(`stepId`) REFERENCES STEP(id)
);
CREATE TABLE "ROUTE_STEPS" (
	`id`	INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE,
	`route`	INTEGER NOT NULL,
	`origin`	INTEGER NOT NULL,
	`destiny`	INTEGER
);
CREATE TABLE `ROUTE_FATHER` (
	`id`	INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
	`title`	TEXT NOT NULL,
	`description`	TEXT,
	`hashTag`	TEXT NOT NULL,
	`timeStamp`	TEXT,
	`creator`	INTEGER NOT NULL,
        FOREIGN KEY(creator) REFERENCES RAFTER(id)
);
INSERT INTO `ROUTE_FATHER` (id,title,description,hashTag,timeStamp,creator) VALUES (1,'Buena ruta','description','hashTag','timeStamp',1);
INSERT INTO `ROUTE_FATHER` (id,title,description,hashTag,timeStamp,creator) VALUES (75,'rutatest2','desctes2t','asdfas2','2012-02-02',128);
CREATE TABLE `RATE` (
	`id`	INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE,
	`creator`	TEXT NOT NULL,
	`routeId`	INTEGER NOT NULL,
	`comment`	TEXT,
        FOREIGN KEY(creator) REFERENCES RAFTER(id),
        FOREIGN KEY(routeId) REFERENCES ROUTE_FATHER(id)
        
);
CREATE TABLE "RAFTER" (
	`id`	INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE,
	`rafterName`	TEXT NOT NULL UNIQUE,
	`password`	TEXT NOT NULL,
	`email`	TEXT NOT NULL UNIQUE,
	`registerDate`	TEXT NOT NULL
);
INSERT INTO `RAFTER` (id,rafterName,password,email,registerDate) VALUES (1,'pepe','pepe','pepe@pepe.com','2012-09-12');
INSERT INTO `RAFTER` (id,rafterName,password,email,registerDate) VALUES (128,'testRafter','1234','testRafter@gmail.com','9999-99-99');
CREATE TABLE `LINE` (
	`id`	INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE,
	`name`	TEXT NOT NULL,
	`transportId`	INTEGER,
         FOREIGN KEY(transportId) REFERENCES TRANSPORT(id)
);
INSERT INTO `LINE` (id,name,transportId) VALUES (1,'R-948672841',1);
INSERT INTO `LINE` (id,name,transportId) VALUES (2,'R1557432105',1);
INSERT INTO `LINE` (id,name,transportId) VALUES (3,'R1430718851',1);
INSERT INTO `LINE` (id,name,transportId) VALUES (4,'R63548636',1);
INSERT INTO `LINE` (id,name,transportId) VALUES (5,'R-502932148',1);
INSERT INTO `LINE` (id,name,transportId) VALUES (6,'R2094560493',1);
INSERT INTO `LINE` (id,name,transportId) VALUES (9,'R-1589223317',43);
INSERT INTO `LINE` (id,name,transportId) VALUES (10,'R-608580010',44);
INSERT INTO `LINE` (id,name,transportId) VALUES (11,'R1952555135',47);
CREATE TABLE "ADDRESS" (
	`id`	INTEGER NOT NULL UNIQUE,
	`zipCode`	TEXT NOT NULL,
	`roadType`	TEXT NOT NULL,
	`number`	TEXT NOT NULL,
	`roadName`	TEXT NOT NULL,
	PRIMARY KEY(id)
);
CREATE UNIQUE INDEX `addres_unique` ON `ADDRESS` (`zipCode` ,`roadName` )



















;
COMMIT;
