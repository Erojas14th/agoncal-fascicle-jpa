CREATE TABLE ARTIST (ID BIGINT NOT NULL, BIO VARCHAR(2000), DATEOFBIRTH DATE, EMAIL VARCHAR, FIRSTNAME VARCHAR NOT NULL, LASTNAME VARCHAR NOT NULL, PRIMARY KEY (ID))
CREATE TABLE SEQUENCE (SEQ_NAME VARCHAR(50) NOT NULL, SEQ_COUNT NUMERIC(38), PRIMARY KEY (SEQ_NAME))
INSERT INTO SEQUENCE(SEQ_NAME, SEQ_COUNT) values ('SEQ_GEN', 0)
