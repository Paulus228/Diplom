INSERT INTO car(id, name, price, date_add, count_buy, description)
SELECT 775, 'TestCar',123.3,'2022-05-13',0,'Test description'
    WHERE
    NOT EXISTS (
        SELECT id FROM car WHERE id = 775
    );

INSERT INTO car(id, name, price, date_add, count_buy, description)
SELECT 776, 'TestCarDelete',123.3,'2022-05-13',0,'Test description'
    WHERE
    NOT EXISTS (
        SELECT id FROM car WHERE id = 776
    );

insert into carphoto(id, id_car, photourl)
SELECT 776, 775,'PhotoUrlDelete'
    WHERE
    NOT EXISTS (
        SELECT id FROM carphoto WHERE id = 776
    );

insert into carphoto(id, id_car, photourl)
SELECT 777, 775,'PhotoUrlDelete'
    WHERE
    NOT EXISTS (
        SELECT id FROM carphoto WHERE id = 777
    );

insert into contacts(id, fullname, email, subject, message, date_send)
SELECT 777, 'Contacts','PhotoUrlDelete','contacts','Contact','2020-05-12'
    WHERE
    NOT EXISTS (
        SELECT id FROM contacts WHERE id = 777
    );

insert into testimonals(id, fullname, message_testimonals, date_send)
SELECT 777, 'Contacts','PhotoUrlDelete','2020-05-12'
    WHERE
    NOT EXISTS (
        SELECT id FROM testimonals WHERE id = 777
    );

insert into carextract(id, id_car, extract)
SELECT 777, 775,'Testtest'
    WHERE
    NOT EXISTS (
        SELECT id FROM carextract WHERE id = 777
    );

insert into carextract(id, id_car, extract)
SELECT 778, 775,'Testtest'
    WHERE
    NOT EXISTS (
        SELECT id FROM carextract WHERE id = 778
    );