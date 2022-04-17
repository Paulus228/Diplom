create table if not exists orders(
    id int primary key auto_increment,
    name varchar(255),
    soname varchar(255),
    faname varchar(255),
    priceorder varchar(255),
    country varchar(255),
    city varchar(255),
    address varchar(255),
    contactphone varchar(255),
    commentorder varchar(255),
    date_order date
);