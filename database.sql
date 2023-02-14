/*
SQLyog Ultimate v10.00 Beta1
MySQL - 5.7.19 : Database - clojure_ecommerce
*********************************************************************
*/

CREATE DATABASE `clojure_ecommerce` ;

USE `clojure_ecommerce`;

DROP Table IF EXISTS `actors`;

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
       (5,'http://dotnethow.net/images/actors/actor-1.jpeg','Actor 1','This is the Bio of the first actor')


