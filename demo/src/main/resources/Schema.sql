use studentdata;
CREATE TABLE IF NOT EXISTS Student
						(
						  ID               INT               AUTO_INCREMENT   NOT NULL     ,
						  STUDENTNAME      VARCHAR(500)                    NOT NULL ,
						  BATCH    	VARCHAR(500)               NOT NULL,
						  BRANCH     	VARCHAR(500)               ,
						  CONSTRAINT ID_PK PRIMARY KEY (ID)
						);
commit;
