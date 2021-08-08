CREATE DATABASE zoo
    WITH 
    OWNER = postgres
    ENCODING = 'UTF8'
    CONNECTION LIMIT = -1;


CREATE TABLE public.species
(
    sp_id integer NOT NULL GENERATED BY DEFAULT AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    sp_name character varying(256) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT spicies_pkey PRIMARY KEY (sp_id),
    CONSTRAINT species_name UNIQUE (sp_name)
)

TABLESPACE pg_default;

ALTER TABLE public.species
    OWNER to postgres;


CREATE TABLE public.cages
(
    cage_id integer NOT NULL GENERATED BY DEFAULT AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    area numeric NOT NULL,
    availablefor integer,
    CONSTRAINT cages_pkey PRIMARY KEY (cage_id),
    CONSTRAINT spicies FOREIGN KEY (availablefor)
        REFERENCES public.species (sp_id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE
)

TABLESPACE pg_default;

ALTER TABLE public.cages
    OWNER to postgres;


CREATE TABLE public.animals
(
    name character varying(256) COLLATE pg_catalog."default" NOT NULL,
    species_id integer NOT NULL,
    cage_id integer NOT NULL,
    CONSTRAINT animals_pkey PRIMARY KEY (name),
    CONSTRAINT cage_id FOREIGN KEY (cage_id)
        REFERENCES public.cages (cage_id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE RESTRICT,
    CONSTRAINT species_id FOREIGN KEY (species_id)
        REFERENCES public.species (sp_id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE RESTRICT
)

TABLESPACE pg_default;

ALTER TABLE public.animals
    OWNER to postgres;


CREATE TABLE public.logs
(
    checkin date,
    checkout date,
    species character varying(256) COLLATE pg_catalog."default" NOT NULL,
    name character varying(256) COLLATE pg_catalog."default" NOT NULL,
    log_id integer NOT NULL GENERATED BY DEFAULT AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    CONSTRAINT logs_pkey PRIMARY KEY (log_id),
    CONSTRAINT species_name FOREIGN KEY (species)
        REFERENCES public.species (sp_name) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

ALTER TABLE public.logs
    OWNER to postgres;



INSERT INTO species(sp_name) VALUES('LEON');
INSERT INTO species(sp_name) VALUES('GIRAFFE');
INSERT INTO species(sp_name) VALUES('SQUIRREL');
INSERT INTO species(sp_name) VALUES('PENGUIN');
