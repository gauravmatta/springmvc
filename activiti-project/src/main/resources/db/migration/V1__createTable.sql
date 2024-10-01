CREATE TABLE REGISTRATION_USERS (
	id int4 NOT NULL,
	email varchar(255) NULL,
	first_name varchar(255) NULL,
	last_name varchar(255) NULL,
	username varchar(255) NULL,
	CONSTRAINT registration_users_pkey PRIMARY KEY (id)
);