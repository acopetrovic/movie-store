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