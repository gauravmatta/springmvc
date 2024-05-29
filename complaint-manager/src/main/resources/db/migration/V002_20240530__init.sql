CREATE TABLE complaints (
	id int CONSTRAINT pk_id PRIMARY KEY,
	message varchar(255) NULL,
	sendername varchar(255) NOT NULL,
	senderemail varchar(255) NOT NULL
);