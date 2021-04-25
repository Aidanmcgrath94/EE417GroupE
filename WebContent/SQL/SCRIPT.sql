CREATE TABLE IF NOT EXISTS user(
   _id INT UNSIGNED AUTO_INCREMENT,
   username VARCHAR(32) NOT NULL UNIQUE,
   password VARCHAR(32) NOT NULL,
   firstName VARCHAR(32) NOT NULL,
   lastName VARCHAR(32) NOT NULL,
   mailAddress VARCHAR(64) NOT NULL,
   isValid BOOLEAN,
   isAdmin BOOLEAN,
   createdDate DATE,
   PRIMARY KEY ( _id )
)ENGINE=InnoDB DEFAULT CHARSET=utf8;
INSERT INTO user values 
 ( 0,"root", "root", "ro", "ot", "root@gmail.com",true,true,Now()),
 (0,"a","abc","a","bc","abc@123.com",true,false,now());
SELECT LAST_INSERT_ID();

SELECT createdDate from user where _id=7;

SELECT * FROM user where username='root' AND password='root';



CREATE TABLE IF NOT EXISTS post(
   _id INT UNSIGNED AUTO_INCREMENT,
   author VARCHAR(32),
   subject VARCHAR(32) NOT NULL,
   body VARCHAR(255) NOT NULL,
   createdDate DATE,
   likes integer,
   PRIMARY KEY ( _id )
)ENGINE=InnoDB DEFAULT CHARSET=utf8;
INSERT INTO post values 
 ( 0,"author1", "subject1", "body1", now(), 0),
 ( 0,"author2", "subject2", "body2", now(), 0);
SELECT LAST_INSERT_ID();

SELECT createdDate from post where _id=7;

SELECT * FROM post;

CREATE TABLE IF NOT EXISTS comments(
  _id INT UNSIGNED AUTO_INCREMENT,
  post_id integer,
  author VARCHAR(255),
  comment VARCHAR(255),
  createdDate DATE,
  PRIMARY KEY ( _id )
)ENGINE=InnoDB DEFAULT CHARSET=utf8;




























DONT USE THIS!!!!

CREATE TABLE PROFILES(
USER_ID integer,
Username VARCHAR(30) NOT NULL,
Passwrd VARCHAR(30) NOT NULL,
Firstname varchar(30),
Lastname varchar(30),
email varchar(255),
favourite varchar(30),
is_admin bit,
primary key(USER_ID, Username));

INSERT INTO PROFILES VALUES(
1, "user1", "password1", "John", "Doe", "john@email.com", "option1" , 1);

INSERT INTO PROFILES VALUES(
2, "user2", "password2", "Mike", "Denver", "mike@email.com", "option2", 0);

INSERT INTO PROFILES VALUES(
3, "user3", "password3", "Jimmy", "Moran", "jimmy@email.com", "option3", 0);

INSERT INTO PROFILES VALUES(
4, "user4", "password4", "Mary", "Murphy", "mary@email.com", "option4", 1);

INSERT INTO PROFILES VALUES(
5, "user5", "password5", "Aine", "Murray", "aine@email.com", "option5", 1);


CREATE TABLE POSTS(
Post_ID integer,
Author varchar(255),
Subject VARCHAR(255),
Body VARCHAR(255),
likes integer,
primary key(Post_ID));

INSERT INTO POSTS VALUES(
1, 1, "This is the subject 1", "This is the body 1", 0);

INSERT INTO POSTS VALUES(
2, 1, "This is the subject 2", "This is the body 2", 0);

INSERT INTO POSTS VALUES(
3, 2, "This is the subject 3", "This is the body 3", 0);

INSERT INTO POSTS VALUES(
4, 3, "This is the subject 4", "This is the body 4", 0);

INSERT INTO POSTS VALUES(
5, 4, "This is the subject 5", "This is the body 5", 0);

CREATE TABLE Comments(
comment_id integer,
post_id integer,
author varchar(255),
comment varchar(255));