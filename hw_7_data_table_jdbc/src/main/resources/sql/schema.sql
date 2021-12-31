create table if not exists company
(
    id   int auto_increment,
    name varchar(250) not null,
    primary key (id)
);

create table if not exists passenger
(
    id         int auto_increment,
    first_name varchar(100),
    last_name  varchar(100),
    primary key (id)
);

create table if not exists trip
(
    id         int auto_increment,
    id_company int          not null,
    plane_name varchar(30)  not null,
    town_from  varchar(100) not null,
    town_to    varchar(100) not null,
    time_out   time         not null,
    time_in    time         not null,
    date_out   date         not null,
    date_in    date         not null,
    primary key (id),
    foreign key (id_company) references company (id)
);

create table if not exists passenger_in_trip
(

    id           int auto_increment,
    id_trip      int         not null,
    id_passenger int         not null,
    place        varchar(10) not null,
    primary key (id),
    foreign key (id_passenger) references passenger (id),
    foreign key (id_trip) references trip (id)
);



