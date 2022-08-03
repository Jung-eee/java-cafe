SELECT * FROM BigCategory;

CREATE TABLE BigCategory(
	bid 				BIGINT   		PRIMARY KEY AUTO_INCREMENT,
	bigCategoryName		VARCHAR(20)		NOT NULL,
	regDate TIMESTAMP	NOT NULL   		DEFAULT CURRENT_TIMESTAMP
)AUTO_INCREMENT = 1001;

SELECT * FROM MenuItem;

INSERT INTO BigCategory (bigCategoryName) values ('커피');
INSERT INTO BigCategory (bigCategoryName) values ('에이드');
INSERT INTO BigCategory (bigCategoryName) values ('스무디');
INSERT INTO BigCategory (bigCategoryName) values ('티');
INSERT INTO BigCategory (bigCategoryName) values ('디저트');
CREATE TABLE MenuItem(
	mid       			BIGINT   		PRIMARY KEY AUTO_INCREMENT,
	bigCategoryFk   	BIGINT			NOT NULL,
	menuName			VARCHAR(20)     NOT NULL,
	menuPrice			DOUBLE			NOT NULL,
	regDate 			TIMESTAMP		NOT NULL DEFAULT CURRENT_TIMESTAMP,
	
	CONSTRAINT MenuItem_bigCategoryFk_FK 
	FOREIGN KEY(bigCategoryFk) REFERENCES BigCategory(bid)
)AUTO_INCREMENT = 3001;

SELECT m.menuName, m.menuPrice, b.bigCategoryName FROM MenuItem m INNER JOIN BigCategory b ON b.bid = m.bigCategoryFk;
CREATE TABLE Image(
	imgId 		BIGINT 			PRIMARY KEY AUTO_INCREMENT,
	menuFk		BIGINT 			NOT NULL,
	imgName 	VARCHAR(200)	NOT NULL,
	imgOriName	VARCHAR(300)	NOT NULL,
	imgUrl 		VARCHAR(500)	NOT NULL,
	
	CONSTRAINT Image_menuFk_FK FOREIGN KEY (menuFk) REFERENCES MenuItem(mid)
)AUTO_INCREMENT 5001;


SELECT * FROM Image;

alter table MenuItem add bigCategoryName VARCHAR(10)  NOT NULL;

alter table MenuItem change ihb	 ihd char(1) NOT NULL;

ALTER TABLE MenuItem convert to charset utf8;

alter table MenuItem drop ihd;

alter table MenuItem drop quantity;

delete from MenuItem where mid=3002;

DROP TABLE Image;

DROP TABLE MenuItem;

DROP TABLE BigCategory;



