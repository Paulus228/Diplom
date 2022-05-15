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

