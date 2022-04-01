create table if not exists role(
	user_id int,
    role_name varchar(255)
);

create table if not exists  user(
	id int primary key auto_increment,
    name varchar(255),
    soname varchar(255),
    username varchar(255),
    password varchar(255),
    roles varchar(255)
);


create table if not exists  contacts(
	id int primary key auto_increment,
    fullname varchar(255),
    email varchar(255),
    subject varchar(255),
    message varchar(255),
    date_send datetime
);

create table if not exists  testimonals(
	id int primary key auto_increment,
    fullname varchar(355),
    message_testimonals varchar(500),
    date_send datetime
);

create table if not exists  car(
	id int primary key auto_increment,
    name varchar(255),
    price float,
    date_add date,
    count_buy int,
    description varchar(500)
);

create table if not exists  carphoto(
                         id int primary key auto_increment,
                         id_car int,
                         photourl varchar(700),
                         FOREIGN KEY (id_car) REFERENCES car (id)
);

create table if not exists  carextract(
                           id int primary key auto_increment,
                           id_car int,
                           extract varchar(255),
                           FOREIGN KEY (id_car) REFERENCES car (id)
);

create table if not exists  carinfo(
                        id int primary key auto_increment,
                        id_car int,
                        type varchar(255),
                        make varchar(255),
                        model varchar(255),
                        first_reg date,
                        mileage int,
                        fuel varchar(250),
                        enginesize int,
                        power int,
                        gearbox varchar(255),
                        numberseat int,
                        doors varchar(200),
                        color varchar(255),
                        FOREIGN KEY (id_car) REFERENCES car (id)
);


create table if not exists  basketuser(
	id_basket int primary key auto_increment,
    id_user int,
    FOREIGN KEY (id_user) REFERENCES user (id)
);

create table if not exists  basketcar(
	id_basket_user int,
    id_car int,
	FOREIGN KEY (id_basket_user) REFERENCES basketuser (id_basket),
	FOREIGN KEY (id_car) REFERENCES car (id)
);
