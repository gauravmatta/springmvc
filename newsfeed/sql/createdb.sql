create table user
(
id integer primary key,
username varchar(255) unique,
password varchar(255),
accesskey varchar(255) unique
);