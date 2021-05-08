CREATE TABLE car
(
    car_id   BIGSERIAL PRIMARY KEY,
    maker varchar(100) not null,
    model varchar(100) not null,
    unique(model)
);

insert into car (maker, model)
values ('tesla', 'model3');

