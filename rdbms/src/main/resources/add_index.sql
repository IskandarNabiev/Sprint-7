--liquibase formatted sql

--changeset isnabiev:add_index


create index first_index on account(id);