CREATE TABLE complaints (
	idcomplaints int CONSTRAINT pk_id PRIMARY KEY,
	message varchar(255) NULL,
	sender_name varchar(255) NOT NULL,
	sender_email varchar(255) NOT NULL
);