--
-- PostgreSQL database dump
--

-- Dumped from database version 14.18 (Ubuntu 14.18-0ubuntu0.22.04.1)
-- Dumped by pg_dump version 14.18 (Ubuntu 14.18-0ubuntu0.22.04.1)

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

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: book; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.book (
    id bigint DEFAULT (floor((random() * (90000000)::double precision)) + (10000000)::double precision) NOT NULL,
    title character varying(255),
    author character varying(255),
    price character varying(50),
    quantity integer,
    image_url text
);


ALTER TABLE public.book OWNER TO postgres;

--
-- Name: flyway_schema_history; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.flyway_schema_history (
    installed_rank integer NOT NULL,
    version character varying(50),
    description character varying(200) NOT NULL,
    type character varying(20) NOT NULL,
    script character varying(1000) NOT NULL,
    checksum integer,
    installed_by character varying(100) NOT NULL,
    installed_on timestamp without time zone DEFAULT now() NOT NULL,
    execution_time integer NOT NULL,
    success boolean NOT NULL
);


ALTER TABLE public.flyway_schema_history OWNER TO postgres;

--
-- Data for Name: book; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.book (id, title, author, price, quantity, image_url) FROM stdin;
45291837	The 7 Habits of Highly Effective People	Stephen R. Covey	10.00	50	https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR5nsDuRs7Ch7Nb70L-hV2Yy7rQbCIM5fGhkQ&s
71938462	Thinks and Grow Rich	Jane Austen	11.25	40	https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQdyzA0blej9q0zMKv7Ra-3vb68C0_R0b1KLg&s
86420395	Moby Dick	Herman Melville	13.75	15	https://m.media-amazon.com/images/I/712mdW4zCcL._UF1000,1000_QL80_.jpg
10593847	War and Peace	Leo Tolstoy	20.00	12	https://m.media-amazon.com/images/I/91teiIZ5vwL._UF1000,1000_QL80_.jpg
59328471	The Catcher in the Rye	J.D. Salinger	14.20	30	https://m.media-amazon.com/images/I/7108sdEUEGL.jpg
34098275	The Hobbit	J.R.R. Tolkien	18.99	25	https://m.media-amazon.com/images/I/71jD4jMityL._UF894,1000_QL80_.jpg
72019384	Fahrenheit 451	Ray Bradbury	9.80	45	https://d3525k1ryd2155.cloudfront.net/f/265/673/9781451673265.SS.0.l.jpg
45918273	Jane Eyre	Charlotte Brontë	16.40	28	https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSdV1SC9h0g6P9-IToAIzQ9w4UneTgpGL4yOw&s
19712179	How to Win Friends and Influence People	Dale Carnegie	20	9	https://m.media-amazon.com/images/I/71vK0WVQ4rL._UF1000,1000_QL80_.jpg
98123456	Cannot Hurt Me	David Goggins	12.50	35	98123456.jpeg
23748591	To Kill a Mockingbird	Harper Lee	15.99	20	23748591.jpeg
\.


--
-- Data for Name: flyway_schema_history; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.flyway_schema_history (installed_rank, version, description, type, script, checksum, installed_by, installed_on, execution_time, success) FROM stdin;
1	1	create table books	SQL	V1__create_table_books.sql	815756889	postgres	2025-09-08 14:29:04.561367	138	t
2	2	add img col	SQL	V2__add_img_col.sql	1496930273	postgres	2025-09-08 14:50:55.492709	5	t
\.


--
-- Name: book book_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.book
    ADD CONSTRAINT book_pkey PRIMARY KEY (id);


--
-- Name: flyway_schema_history flyway_schema_history_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.flyway_schema_history
    ADD CONSTRAINT flyway_schema_history_pk PRIMARY KEY (installed_rank);


--
-- Name: flyway_schema_history_s_idx; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX flyway_schema_history_s_idx ON public.flyway_schema_history USING btree (success);


--
-- PostgreSQL database dump complete
--

