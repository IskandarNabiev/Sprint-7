--liquibase formatted sql

--changeset isnabiev:insert_data

insert into account (amount, version) values (400, 0);
insert into account (amount, version) values (200, 0);