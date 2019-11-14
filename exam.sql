create database exam default character set utf8 collate utf8_bin;

use exam;

create table if not exists queType(
	tid int primary key auto_increment,
	tname varchar(20) not null unique
)ENGINE=InnoDB AUTO_INCREMENT=101 default charset=utf8 collate=utf8_bin;
	
create table if not exists difficulty(
	lid int primary key auto_increment,
	level int 
)ENGINE=InnoDB AUTO_INCREMENT=1 default charset=utf8 collate=utf8_bin;

create table if not exists course(
	coid int primary key auto_increment,
	cname varchar(20)
)ENGINE=InnoDB AUTO_INCREMENT=1 default charset=utf8 collate=utf8_bin;

create table if not exists question(
	qid int primary key auto_increment,
	tid int,
	content text,
	answer varchar(10) not null,
	answerCount int,
	corretCount int,
	lid int,
	option1 varchar(200),
	option2 varchar(200),
	option3 varchar(200),
	option4 varchar(200),
	expression varchar(2000),
	coid int,
	constraint FK_question_tid foreign key(tid) references queType(tid),
	constraint FK_question_lid foreign key(lid) references difficulty(lid),
	constraint FK_question_coid foreign key(coid) references course(coid)
)ENGINE=InnoDB AUTO_INCREMENT=1 default charset=utf8 collate=utf8_bin;

create table if not exists exampaper(
	eid int primary key auto_increment,
	questions varchar(2000),
	ename varchar(200),
	choice int, 
	doubleChoice int, 
	judge int, 
	startTime Datetime, 
	persistTime int, 
	lid int,
	flag int,  
	constraint FK_test_lid foreign key(lid) references difficulty(lid)
)ENGINE=InnoDB AUTO_INCREMENT=1 default charset=utf8 collate=utf8_bin;

create table if not exists selfTest(
	seid int primary key auto_increment,
	questions varchar(2000),
	selfAnswer varchar(2000),
	coid int,
	lid int,
	grade float,
	constraint FK_selfTest_coid foreign key(coid) references course(coid),
	constraint FK_selfTest_lid foreign key(lid) references difficulty(lid)
)ENGINE=InnoDB AUTO_INCREMENT=1 default charset=utf8 collate=utf8_bin;

create table if not exists ditribution(
	did int primary key auto_increment,
	eid int,
	cid int,
	constraint FK_ditribution_eid foreign key(eid) references exampaper(eid),
	constraint FK_ditribution_cid foreign key(cid) references class(cid)
)ENGINE=InnoDB AUTO_INCREMENT=1 default charset=utf8 collate=utf8_bin;

create table if not exists class(
	cid int primary key auto_increment,
	name varchar(20)
)ENGINE=InnoDB AUTO_INCREMENT=1 default charset=utf8 collate=utf8_bin;

create table if not exists teacher(
	chid int primary key auto_increment,
	account varchar(50) not null unique,
	pwd varchar(50) not null,
	name varchar(20),
	email varchar(100)
)ENGINE=InnoDB AUTO_INCREMENT=1 default charset=utf8 collate=utf8_bin;

create table if not exists student(
	sid int primary key auto_increment,
	sname varchar(50) not null unique,
	pwd varchar(50) not null,
	cid int,
	email varchar(100),
	constraint FK_student_cid foreign key(cid) references class(cid)
)ENGINE=InnoDB AUTO_INCREMENT=1 default charset=utf8 collate=utf8_bin;

create table if not exists card(
	gid int primary key auto_increment,
	sid int,
	eid int,
	grade float, 
	remainTime int, 
	stuAnswer varchar(2000),
	constraint FK_card_sid foreign key(sid) references student(sid),
	constraint FK_card_eid foreign key(eid) references exampaper(eid)
)ENGINE=InnoDB AUTO_INCREMENT=1 default charset=utf8 collate=utf8_bin;
