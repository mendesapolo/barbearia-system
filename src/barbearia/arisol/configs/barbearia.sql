--
-- File generated with SQLiteStudio v3.3.3 on quarta abr. 20 10:18:32 2022
--
-- Text encoding used: System
--
PRAGMA foreign_keys = off;
BEGIN TRANSACTION;

-- Table: agendamentos
DROP TABLE IF EXISTS agendamentos;

CREATE TABLE agendamentos (
    id           INTEGER       PRIMARY KEY AUTOINCREMENT,
    data         DATETIME,
    valor        DOUBLE (8, 2) DEFAULT (0),
    is_cancelado BOOLEAN       DEFAULT (false),
    cliente_id   INT           CONSTRAINT agendamentos_cliente_id_clientes REFERENCES clientes (id) ON DELETE CASCADE
                                                                                                    ON UPDATE CASCADE,
    corte_id     INT           CONSTRAINT agendamentos_corte_id_cortes REFERENCES cortes (id) ON DELETE CASCADE
                                                                                              ON UPDATE CASCADE
);


-- Table: atendimentos
DROP TABLE IF EXISTS atendimentos;

CREATE TABLE atendimentos (
    id         INTEGER       PRIMARY KEY AUTOINCREMENT
                             NOT NULL,
    data       DATETIME,
    valor      DOUBLE (8, 2) DEFAULT (0),
    is_agenda  BOOLEAN       DEFAULT (false),
    corte_id   INT           CONSTRAINT atendimentos_corte_id_cortes REFERENCES cortes (id) ON DELETE CASCADE
                                                                                            ON UPDATE CASCADE,
    cliente_id INT           CONSTRAINT atendimentos_cliente_id_clientes REFERENCES clientes (id) ON DELETE CASCADE
                                                                                                  ON UPDATE CASCADE,
    agenda_id  INT           CONSTRAINT atendimentos_agenda_id_agendamentos REFERENCES agendamentos (id) ON DELETE CASCADE
                                                                                                         ON UPDATE CASCADE,
    user_id    INT           CONSTRAINT atendimentos_user_id_utilizadores REFERENCES utilizadores (id) ON DELETE CASCADE
                                                                                                       ON UPDATE CASCADE
);


-- Table: categorias
DROP TABLE IF EXISTS categorias;

CREATE TABLE categorias (
    id        INTEGER       PRIMARY KEY AUTOINCREMENT,
    nome      VARCHAR (60)  NOT NULL,
    descricao VARCHAR (120) 
);


-- Table: clientes
DROP TABLE IF EXISTS clientes;

CREATE TABLE clientes (
    id              INTEGER      PRIMARY KEY AUTOINCREMENT
                                 NOT NULL,
    nome            VARCHAR (60) NOT NULL,
    telefone        VARCHAR (15),
    identidade      VARCHAR (18),
    data_nascimento DATE,
    is_activo       BOOLEAN      DEFAULT (false),
    user_id         INT          CONSTRAINT clientes_user_id_utilizadores REFERENCES utilizadores (id) ON DELETE CASCADE
                                                                                                       ON UPDATE CASCADE
);


-- Table: cortes
DROP TABLE IF EXISTS cortes;

CREATE TABLE cortes (
    id           INTEGER       PRIMARY KEY AUTOINCREMENT
                               NOT NULL,
    nome         VARCHAR (100) NOT NULL,
    descricao    VARCHAR (150),
    preco        DOUBLE (8, 2) DEFAULT (0),
    categoria_id INT           CONSTRAINT cortes_categoria_id_categorias REFERENCES categorias (id) ON DELETE CASCADE
                                                                                                    ON UPDATE CASCADE,
    user_id      INT           CONSTRAINT cortes_user_id_utilizadores REFERENCES utilizadores (id) ON DELETE CASCADE
                                                                                                   ON UPDATE CASCADE
);


-- Table: sistema
DROP TABLE IF EXISTS sistema;

CREATE TABLE sistema (
    id              INTEGER      PRIMARY KEY AUTOINCREMENT
                                 NOT NULL,
    estabelecimento VARCHAR (50) UNIQUE
                                 NOT NULL,
    taxa_agenda     INT          DEFAULT (0) 
);


-- Table: utilizadores
DROP TABLE IF EXISTS utilizadores;

CREATE TABLE utilizadores (
    id        INTEGER      PRIMARY KEY AUTOINCREMENT
                           NOT NULL,
    nome      VARCHAR (60) NOT NULL,
    telefone  VARCHAR (15),
    username  VARCHAR (25) NOT NULL
                           UNIQUE,
    password  VARCHAR (60) NOT NULL,
    is_activo BOOLEAN      DEFAULT (false) 
);


COMMIT TRANSACTION;
PRAGMA foreign_keys = on;
