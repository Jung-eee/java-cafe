SELECT * FROM BigCategory;

CREATE TABLE BigCategory(
	bid 				BIGINT   		PRIMARY KEY AUTO_INCREMENT,
	bigCategoryName		VARCHAR(20)		NOT NULL,
	regDate TIMESTAMP	NOT NULL   		DEFAULT CURRENT_TIMESTAMP
)AUTO_INCREMENT = 1001;

SELECT * FROM MenuItem;

INSERT INTO BigCategory (bigCategoryName) values ('커피');
CREATE TABLE MenuItem(
	mid       			BIGINT   		PRIMARY KEY AUTO_INCREMENT,
	bigCategoryFk   	BIGINT			NOT NULL,
	menuName			VARCHAR(20)     NOT NULL,
	menuPrice			DOUBLE			NOT NULL,
	ihb					char(1)			NOT NULL,
	quantity			int				NOT NULL,
	regDate 			TIMESTAMP		NOT NULL DEFAULT CURRENT_TIMESTAMP,
	
	CONSTRAINT MenuItem_bigCategoryFk_FK 
	FOREIGN KEY(bigCategoryFk) REFERENCES BigCategory(bid)
)AUTO_INCREMENT = 3001;

alter table MenuItem add bigCategoryName VARCHAR(10)  NOT NULL;

alter table MenuItem change ihb	 ihd char(1) NOT NULL;

ALTER TABLE MenuItem convert to charset utf8;

alter table MenuItem drop ihd;

alter table MenuItem drop quantity;

delete from MenuItem where mid=3002;