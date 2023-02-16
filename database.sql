/*
SQLyog Ultimate v10.00 Beta1
MySQL - 5.7.19 : Database - clojure_ecommerce
*********************************************************************
*/

CREATE DATABASE `clojure_ecommerce` ;

USE `clojure_ecommerce`;

DROP TABLE IF EXISTS `actors`;

CREATE TABLE `actors` (
    `Id` int (11) NOT NULL AUTO_INCREMENT,
    `ProfilePictureURL` varchar (255) NULL,
    `FullName`          varchar (255) NULL,
    `Bio`               varchar (255) NULL,
    PRIMARY KEY (`Id`)
)ENGINE=InnoDB AUTO_INCREMENT=6;
/*Data for the table `actors`*/

insert into `actors` (`Id`,`ProfilePictureURL`,`FullName`,`Bio`)
values (1,'http://dotnethow.net/images/actors/actor-5.jpeg','Actor 5','This is the Bio of the five actor'),
       (2,'http://dotnethow.net/images/actors/actor-4.jpeg','Actor 4','This is the Bio of the fourth actor'),
       (3,'http://dotnethow.net/images/actors/actor-3.jpeg','Actor 3','This is the Bio of the third actor'),
       (4,'http://dotnethow.net/images/actors/actor-2.jpeg','Actor 2','This is the Bio of the second actor'),
       (5,'http://dotnethow.net/images/actors/actor-1.jpeg','Actor 1','This is the Bio of the first actor');

DROP TABLE IF EXISTS `cinemas`;

CREATE TABLE `cinemas` (
    `Id` int (11) NOT NULL AUTO_INCREMENT,
    `Logo` varchar (255) NULL,
    `Name` varchar (255) NULL,
    `Description` varchar (255) NULL,
    PRIMARY KEY (`Id`)
);
/*Data for the table `cinemas`*/

insert into `cinemas` (`Id`,`Logo`,Name,Description)
values (1,'http://dotnethow.net/images/cinemas/cinema-1.jpeg','Cinema 1','This is the description of the first cinema'),
       (2,'http://dotnethow.net/images/cinemas/cinema-2.jpeg','Cinema 2','This is the description of the second cinema'),
       (3,'http://dotnethow.net/images/cinemas/cinema-3.jpeg','Cinema 3','This is the description of the third cinema'),
       (4,'http://dotnethow.net/images/cinemas/cinema-4.jpeg','Cinema 4','This is the description of the fourth cinema'),
       (5,'http://dotnethow.net/images/cinemas/cinema-5.jpeg','Cinema 5','This is the description of the five cinema');

DROP TABLE IF EXISTS `producers`;

CREATE TABLE `producers` (
    `Id` int (11) NOT NULL AUTO_INCREMENT,
    `ProfilePictureURL` varchar (255) NULL,
    `FullName`          varchar (255) NULL,
    `Bio`               varchar (255) NULL,
    PRIMARY KEY (`Id`)
);
/*Data for the table `producers`*/

insert into `producers` (`Id`,`ProfilePictureURL`,`FullName`,`Bio`)
values (1,'http://dotnethow.net/images/producers/producer-5.jpeg','Producer 5','This is the Bio of the five producer'),
       (2,'http://dotnethow.net/images/producers/producer-4.jpeg','Producer 4','This is the Bio of the fourth producer'),
       (3,'http://dotnethow.net/images/producers/producer-3.jpeg','Producer 3','This is the Bio of the third producer'),
       (4,'http://dotnethow.net/images/producers/producer-2.jpeg','Producer 2','This is the Bio of the second producer'),
       (5,'http://dotnethow.net/images/producers/producer-1.jpeg','Producer 1','This is the Bio of the first producer');

DROP TABLE IF EXISTS `movies`;

CREATE TABLE `movies` (
    `Id` int(11) NOT NULL AUTO_INCREMENT,
    `Name` varchar(255) NULL,
    `Description` varchar(255) NULL,
    `Price` float(53) NOT NULL,
    `ImageURL` varchar(255) NULL,
    `StartDate` date NOT NULL,
    `EndDate` date NOT NULL,
    `MovieCategory` varchar(255) NULL,
    `CinemaId` int NOT NULL,
    `ProducerId`int NOT NULL,
    PRIMARY KEY (`Id`),
    CONSTRAINT `fk_id_cinemas` FOREIGN KEY (`CinemaId`) REFERENCES `cinemas` (`Id`) ON DELETE CASCADE,
    CONSTRAINT `fk_id_producers` FOREIGN KEY (`ProducerId`) REFERENCES `producers` (`Id`) ON DELETE CASCADE
);
/*Data for table `movies`*/

insert into `movies` (`Id`,`Name`,`Description`,`Price`,`ImageURL`,`StartDate`,`EndDate`,`MovieCategory`,`CinemaId`,`ProducerId`)
values (1,'Scoob','This is the Scoob movie description','39.5','http://dotnethow.net/images/movies/movie-7.jpeg','27-Feb-23','29-Mar-23','Cartoon','1','3'),
       (2,'Race','This is the Race movie description','39.5','http://dotnethow.net/images/movies/movie-6.jpeg','27-Feb-23','29-Mar-23','Cartoon','1','2'),
       (3,'Ghost','This is the Ghost movie description','39.5','http://dotnethow.net/images/movies/movie-4.jpeg','27-Feb-23','29-Mar-23','Cartoon','4','4'),
       (4,'The Shawshank Redemption','This is the The Shawshank Redemption movie description','29.5','http://dotnethow.net/images/movies/movie-1.jpeg','27-Feb-23','29-Mar-23','Cartoon','1','1'),
       (5,'Life','This is the Life movie description','39.5','http://dotnethow.net/images/movies/movie-3.jpeg','27-Feb-23','29-Mar-23','Cartoon','3','3'),
       (6,'Cold Soles','This is the Cold Soles movie description','39.5','http://dotnethow.net/images/movies/movie-8.jpeg','27-Feb-23','29-Mar-23','Cartoon','1','5');

DROP TABLE IF EXISTS `actors_movies`;

CREATE TABLE `actors_movies` (
    `MovieId` int NOT NULL,
    `ActorId` int NOT NULL,
    PRIMARY KEY (`MovieId`,`ActorId`),
    CONSTRAINT `fk_id_actors` FOREIGN KEY (`ActorId`) REFERENCES `actors` (`Id`) ON DELETE CASCADE,
    CONSTRAINT `fk_id_movies` FOREIGN KEY (`MovieId`) REFERENCES `movies` (`Id`) ON DELETE CASCADE
);
/*Data for table `actors_movies`*/

insert into `actors_movies` (`MovieId`,`ActorId`)
values ('1','1'),
       ('1','3'),
       ('2','1'),
       ('2','4'),
       ('3','1'),
       ('3','2'),
       ('3','5'),
       ('4','2'),
       ('4','3'),
       ('4','4'),
       ('5','2'),
       ('5','3'),
       ('5','4'),
       ('5','5'),
       ('6','3'),
       ('6','4'),
       ('6','5');