drop database if exists vending_inventory;

create database if not exists vending_inventory;

use vending_inventory;

create table if not exists item (
	id tinyint not null,
    `name` varchar(20) not null,
    price decimal(5, 2) not null default 0,
    quantity tinyint not null default 0
);

insert into item (id, `name`, price, quantity) values
(1, "Water", 2.00, 8),
(2, "Cola", 2.75, 0),
(3, "Candy", 1.50, 9),
(4, "Gum", 0.75, 10),
(5, "Ice Cream", 4.00, 6),
(6, "Yogurt", 2.75, 9),
(7, "Cookie", 1.00, 8),
(8, "Skittles", 1.00, 12),
(9, "Raisinets", 1.95, 7);
