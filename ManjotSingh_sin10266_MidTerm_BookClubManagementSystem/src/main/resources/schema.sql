DROP TABLE IF EXISTS booktb;
CREATE TABLE booktb(
id INT AUTO_INCREMENT PRIMARY KEY,
title VARCHAR(30) NOT NULL,
author VARCHAR(20) NOT NULL,
edition VARCHAR(20) NOT NULL,
yearPublished VARCHAR(10) NOT NULL,
status VARCHAR(20) NOT NULL);