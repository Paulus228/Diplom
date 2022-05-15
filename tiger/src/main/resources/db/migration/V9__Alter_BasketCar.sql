alter table basketcar
    add id int null;

alter table basketcar
    add constraint basketcar_pk
        primary key (id);