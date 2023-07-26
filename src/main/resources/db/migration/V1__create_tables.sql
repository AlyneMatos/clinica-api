CREATE TABLE paciente
(

    id           bigint not null ,
    nome        varchar(255) not null,
    idade      integer      not null,
   nascimento date not null,
    cpf varchar(255) not null,
    cep varchar(255) not null,

    primary key (id)
);
CREATE TABLE medico (
    id bigint not null ,
    crm varchar(255) not null,
    especialidade varchar(255) not null,
    nome varchar(255) not null,
    primary key (id)
);
