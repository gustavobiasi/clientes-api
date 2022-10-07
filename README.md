JAVA 11

Script para aplicar no banco postgres 

CREATE TABLE public.tab_cliente (
id BIGSERIAL,
nome TEXT,
cpf TEXT,
dta_cadastro TIMESTAMP WITHOUT TIME ZONE,
CONSTRAINT tab_cliente_pkey PRIMARY KEY(id)
);