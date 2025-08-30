create table if not exists pao
(
    id            serial
        primary key,
    tipo          varchar(100) not null
        unique,
    tempo_preparo interval     not null
);

alter table pao
    owner to postgres;

create table if not exists fornada
(
    id        serial
        primary key,
    data_hora timestamp default now() not null
);

alter table fornada
    owner to postgres;

create table if not exists pao_fornada
(
    pao            integer                 not null
        references pao,
    fornada        integer                 not null
        references fornada,
    quantidade_pao integer                 not null
        constraint pao_fornada_quantidade_pao_check
            check (quantidade_pao > 0),
    hora_entrada   timestamp default now() not null,
    hora_saida     timestamp,
    primary key (pao, fornada)
);

alter table pao_fornada
    owner to postgres;

INSERT INTO pao (tipo, tempo_preparo) VALUES ('Frances', '01:00:00');
INSERT INTO pao (tipo, tempo_preparo) VALUES ('Bolachao', '00:50:00');
INSERT INTO pao (tipo, tempo_preparo) VALUES ('Carteiro', '00:40:00');
INSERT INTO pao (tipo, tempo_preparo) VALUES ('Seda', '00:55:00');
INSERT INTO pao (tipo, tempo_preparo) VALUES ('Baguete', '01:10:00');
INSERT INTO pao (tipo, tempo_preparo) VALUES ('Recife', '00:45:00');
INSERT INTO pao (tipo, tempo_preparo) VALUES ('Croissant', '01:15:00');
INSERT INTO pao (tipo, tempo_preparo) VALUES ('Pao de Queijo', '00:35:00');
INSERT INTO pao (tipo, tempo_preparo) VALUES ('Pao Chocolate', '00:50:00');
INSERT INTO pao (tipo, tempo_preparo) VALUES ('Rosquinha', '00:40:00');
