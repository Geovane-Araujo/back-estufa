alter table plantas add nomecientifico varchar(70);
alter table plantas add familia varchar(70);
alter table plantas add luminosidade varchar(70);
alter table plantas add ciclovida varchar(70);
alter table plantas add categoria varchar(70);


create table if not exists plantas_fases_crecimento(

    id serial primary key,
    idplanta int,
    idfase int,
    temperatura real,
    humidade real,
    nivelagua real,
    ph real,
    luminosidade real
);

create table nutrientes(

   id serial primary key,
   descricao varchar(70),
   un varchar(20)
);

create table planta_nutrientes(

    id serial primary key,
    idnutriente int,
    idplanta int,
    quantidade real
);

