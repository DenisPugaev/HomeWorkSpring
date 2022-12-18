--
-- PostgreSQL database dump
--

-- Dumped from database version 14.5
-- Dumped by pg_dump version 14.5

-- Started on 2022-12-17 21:30:33

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

DROP DATABASE postgres;
--
-- TOC entry 3331 (class 1262 OID 13754)
-- Name: postgres; Type: DATABASE; Schema: -; Owner: postgres
--

CREATE DATABASE postgres WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'Russian_Russia.1251';


ALTER DATABASE postgres OWNER TO postgres;

\connect postgres

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 3332 (class 0 OID 0)
-- Dependencies: 3331
-- Name: DATABASE postgres; Type: COMMENT; Schema: -; Owner: postgres
--

COMMENT ON DATABASE postgres IS 'default administrative connection database';


--
-- TOC entry 4 (class 2615 OID 2200)
-- Name: public; Type: SCHEMA; Schema: -; Owner: postgres
--

CREATE SCHEMA public;


ALTER SCHEMA public OWNER TO postgres;

--
-- TOC entry 3333 (class 0 OID 0)
-- Dependencies: 4
-- Name: SCHEMA public; Type: COMMENT; Schema: -; Owner: postgres
--

COMMENT ON SCHEMA public IS 'standard public schema';


SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 215 (class 1259 OID 16946)
-- Name: orders; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.orders (
    id integer NOT NULL,
    id_user integer NOT NULL,
    id_products integer NOT NULL
);


ALTER TABLE public.orders OWNER TO postgres;

--
-- TOC entry 214 (class 1259 OID 16945)
-- Name: orders_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public.orders ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.orders_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- TOC entry 213 (class 1259 OID 16925)
-- Name: products; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.products (
    id integer NOT NULL,
    name character varying NOT NULL,
    cost real NOT NULL
);


ALTER TABLE public.products OWNER TO postgres;

--
-- TOC entry 212 (class 1259 OID 16924)
-- Name: products_id_product_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public.products ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.products_id_product_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- TOC entry 211 (class 1259 OID 16856)
-- Name: users; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.users (
    id integer NOT NULL,
    name character varying NOT NULL
);


ALTER TABLE public.users OWNER TO postgres;

--
-- TOC entry 210 (class 1259 OID 16855)
-- Name: users1_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public.users ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.users1_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- TOC entry 3325 (class 0 OID 16946)
-- Dependencies: 215
-- Data for Name: orders; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.orders OVERRIDING SYSTEM VALUE VALUES (1, 1, 2);
INSERT INTO public.orders OVERRIDING SYSTEM VALUE VALUES (2, 1, 5);
INSERT INTO public.orders OVERRIDING SYSTEM VALUE VALUES (3, 1, 3);
INSERT INTO public.orders OVERRIDING SYSTEM VALUE VALUES (4, 2, 4);
INSERT INTO public.orders OVERRIDING SYSTEM VALUE VALUES (5, 2, 1);
INSERT INTO public.orders OVERRIDING SYSTEM VALUE VALUES (6, 2, 2);
INSERT INTO public.orders OVERRIDING SYSTEM VALUE VALUES (7, 3, 5);
INSERT INTO public.orders OVERRIDING SYSTEM VALUE VALUES (8, 3, 1);
INSERT INTO public.orders OVERRIDING SYSTEM VALUE VALUES (9, 3, 2);


--
-- TOC entry 3323 (class 0 OID 16925)
-- Dependencies: 213
-- Data for Name: products; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.products OVERRIDING SYSTEM VALUE VALUES (1, 'PhoneA', 13656);
INSERT INTO public.products OVERRIDING SYSTEM VALUE VALUES (2, 'TVB', 23444);
INSERT INTO public.products OVERRIDING SYSTEM VALUE VALUES (3, 'StationPlayS', 13444);
INSERT INTO public.products OVERRIDING SYSTEM VALUE VALUES (4, 'TVBOXM', 3900);
INSERT INTO public.products OVERRIDING SYSTEM VALUE VALUES (5, 'HeadPhonesQ', 1900);


--
-- TOC entry 3321 (class 0 OID 16856)
-- Dependencies: 211
-- Data for Name: users; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.users OVERRIDING SYSTEM VALUE VALUES (1, 'Jack');
INSERT INTO public.users OVERRIDING SYSTEM VALUE VALUES (2, 'Bob');
INSERT INTO public.users OVERRIDING SYSTEM VALUE VALUES (3, 'Den');


--
-- TOC entry 3334 (class 0 OID 0)
-- Dependencies: 214
-- Name: orders_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.orders_id_seq', 9, true);


--
-- TOC entry 3335 (class 0 OID 0)
-- Dependencies: 212
-- Name: products_id_product_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.products_id_product_seq', 5, true);


--
-- TOC entry 3336 (class 0 OID 0)
-- Dependencies: 210
-- Name: users1_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.users1_id_seq', 3, true);


--
-- TOC entry 3178 (class 2606 OID 16931)
-- Name: products products_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.products
    ADD CONSTRAINT products_pk PRIMARY KEY (id);


--
-- TOC entry 3176 (class 2606 OID 16894)
-- Name: users users_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_pk PRIMARY KEY (id);


--
-- TOC entry 3180 (class 2606 OID 16954)
-- Name: orders orders_fk_products; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.orders
    ADD CONSTRAINT orders_fk_products FOREIGN KEY (id_products) REFERENCES public.products(id);


--
-- TOC entry 3179 (class 2606 OID 16949)
-- Name: orders orders_fk_users; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.orders
    ADD CONSTRAINT orders_fk_users FOREIGN KEY (id_user) REFERENCES public.users(id);


-- Completed on 2022-12-17 21:30:34

--
-- PostgreSQL database dump complete
--

