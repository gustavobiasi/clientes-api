JAVA 11

acessar swagger: http://localhost:[PORT]/swagger-ui/index.html

Necessário criação do banco de dados postgres.

spring.datasource.url=jdbc:postgresql://localhost:5432/clientes-api
spring.datasource.username=postgres
spring.datasource.password=postgres

Script para aplicar no banco postgres 

CREATE TABLE public.tab_cliente (
id BIGSERIAL,
nome TEXT,
cpf TEXT,
dta_cadastro TIMESTAMP WITHOUT TIME ZONE,
CONSTRAINT tab_cliente_pkey PRIMARY KEY(id)
);

CREATE TABLE public.tab_cidade ( 
id BIGSERIAL, 
cidade TEXT, 
dta_cadastro TIMESTAMP WITHOUT TIME ZONE, 
CONSTRAINT tab_cidade_pkey PRIMARY KEY(id) 
);