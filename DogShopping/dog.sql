CREATE TABLE dog(
	id NUMBER	PRIMARY KEY,
	kind VARCHAR2(21)
	price NUMBER NOT NULL,
	image VARCHAR2(20) NOT NULL,
	country VARCHAR2(30) NOT NULL,
	height NUMBER NOT NULL,
	weight NUMBER NOT NULL,
	content VARCHAR2(400) NOT NULL,
	readcount NUMBER NOT NULL
)

CREATE SEQUENCE dog_seq START WITH 1 NOCACHE;

INSERT INTO dog VALUES (dog_seq.nextval, '세파트' , 10000, 'se.jpg', '독일', 1, 10, '세파트는 용맹하다.', 0);
INSERT INTO dog VALUES (dog_seq.nextval, '푸들' , 20000, 'pu.jpg', '프랑스', 1, 5, '푸들은 귀엽다.', 0);
INSERT INTO dog VALUES (dog_seq.nextval, '시바견' , 5000, 'si.jpg', '일본', 1, 5, '시바견은 귀엽다', 0);
INSERT INTO dog VALUES (dog_seq.nextval, '불독' , 10000, 'bul.jpg', '독일', 1, 10, '불독은 사납다.', 0);
COMMIT


