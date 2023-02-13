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
);


