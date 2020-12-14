drop database if exists superhero_sightings;

create database if not exists superhero_sightings;

use superhero_sightings;

create table if not exists Organization (
ID int(5) not null auto_increment primary key,
`Name` varchar(30) not null,
Description varchar(100) null,
Address varchar(30) null,
City varchar(30) null,
State char(2) null,
Phone char(10) null,
Email varchar(45) null,
Website varchar(45) null
);

create table if not exists Location (
ID int(11) not null auto_increment primary key,
`Name` varchar(45) not null,
Description varchar(100) not null,
Address varchar(45) null,
City varchar(30) not null,
State char(2) not null,
Latitude double null,
Longitude double null
);

create table if not exists HeroVillain (
ID int(5) not null auto_increment primary key,
`Name` varchar(30) not null,
Description varchar(100) null,
Power varchar(45) null
);

create table if not exists HeroVillain_Organization (
HeroVillainID int(5) not null,
OrganizationID int(5) not null,
primary key (HeroVillainID, OrganizationID),
constraint fk_HeroVillain_Organization_HeroVillainID foreign key (HeroVillainID) references HeroVillain (ID),
constraint fk_HeroVillain_Organization_OrganizationID foreign key (OrganizationID) references Organization (ID)
);

create table if not exists Sighting (
ID int(11) not null auto_increment primary key,
`Date` date not null,
LocationID int(11) not null,
constraint fk_Sighting_LocationID foreign key (LocationID) references Location (ID)
);

create table if not exists HeroVillain_Sighting (
HeroVillainID int(5) not null,
SightingID int(11) not null,
constraint fk_HeroVillain_Sighting_HeroVillainID foreign key (HeroVillainID) references HeroVillain (ID),
constraint fk_HeroVillain_Sighting_SightingID foreign key (SightingID) references Sighting (ID)
);

drop database if exists superhero_sightings_test;

create database if not exists superhero_sightings_test;

use superhero_sightings_test;

create table if not exists Organization (
ID int(5) not null auto_increment primary key,
`Name` varchar(30) not null,
Description varchar(100) null,
Address varchar(30) null,
City varchar(30) null,
State char(2) null,
Phone char(10) null,
Email varchar(45) null,
Website varchar(45) null
);

create table if not exists Location (
ID int(11) not null auto_increment primary key,
`Name` varchar(45) not null,
Description varchar(100) not null,
Address varchar(45) null,
City varchar(30) not null,
State char(2) not null,
Latitude double null,
Longitude double null
);

create table if not exists HeroVillain (
ID int(5) not null auto_increment primary key,
`Name` varchar(30) not null,
Description varchar(100) null,
Power varchar(45) null
);

create table if not exists HeroVillain_Organization (
HeroVillainID int(5) not null,
OrganizationID int(5) not null,
primary key (HeroVillainID, OrganizationID),
constraint fk_HeroVillain_Organization_HeroVillainID foreign key (HeroVillainID) references HeroVillain (ID),
constraint fk_HeroVillain_Organization_OrganizationID foreign key (OrganizationID) references Organization (ID)
);

create table if not exists Sighting (
ID int(11) not null auto_increment primary key,
`Date` date not null,
LocationID int(11) not null,
constraint fk_Sighting_LocationID foreign key (LocationID) references Location (ID)
);

create table if not exists HeroVillain_Sighting (
HeroVillainID int(5) not null,
SightingID int(11) not null,
constraint fk_HeroVillain_Sighting_HeroVillainID foreign key (HeroVillainID) references HeroVillain (ID),
constraint fk_HeroVillain_Sighting_SightingID foreign key (SightingID) references Sighting (ID)
);