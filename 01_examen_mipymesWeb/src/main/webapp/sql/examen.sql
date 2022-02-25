--
-- PostgreSQL database dump
--

-- Dumped from database version 14.1
-- Dumped by pg_dump version 14.1

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
-- Name: detalle_mantenimiento; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.detalle_mantenimiento (
    iddetallemantenimiento integer NOT NULL,
    descripcion character varying(50) NOT NULL,
    cantidad integer NOT NULL,
    valorunitario numeric(8,2) NOT NULL,
    valortotal numeric(8,2) NOT NULL,
    det_trabajo integer NOT NULL,
    det_mantenimiento integer NOT NULL
);


ALTER TABLE public.detalle_mantenimiento OWNER TO postgres;

--
-- Name: detalle_mantenimiento_iddetallemantenimiento_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.detalle_mantenimiento_iddetallemantenimiento_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.detalle_mantenimiento_iddetallemantenimiento_seq OWNER TO postgres;

--
-- Name: detalle_mantenimiento_iddetallemantenimiento_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.detalle_mantenimiento_iddetallemantenimiento_seq OWNED BY public.detalle_mantenimiento.iddetallemantenimiento;


--
-- Name: mantenimiento; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.mantenimiento (
    idmantenimiento integer NOT NULL,
    fechamantenimiento date NOT NULL,
    mant_vivienda integer NOT NULL,
    costototal numeric(8,2)
);


ALTER TABLE public.mantenimiento OWNER TO postgres;

--
-- Name: mantenimiento_idmantenimiento_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.mantenimiento_idmantenimiento_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.mantenimiento_idmantenimiento_seq OWNER TO postgres;

--
-- Name: mantenimiento_idmantenimiento_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.mantenimiento_idmantenimiento_seq OWNED BY public.mantenimiento.idmantenimiento;


--
-- Name: trabajo_mantenimiento; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.trabajo_mantenimiento (
    idtrabajo integer NOT NULL,
    nombretrabajo character varying(50) NOT NULL,
    valortrabajo numeric(8,2) NOT NULL
);


ALTER TABLE public.trabajo_mantenimiento OWNER TO postgres;

--
-- Name: trabajo_mantenimiento_idtrabajo_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.trabajo_mantenimiento_idtrabajo_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.trabajo_mantenimiento_idtrabajo_seq OWNER TO postgres;

--
-- Name: trabajo_mantenimiento_idtrabajo_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.trabajo_mantenimiento_idtrabajo_seq OWNED BY public.trabajo_mantenimiento.idtrabajo;


--
-- Name: vivienda; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.vivienda (
    idvivienda integer NOT NULL,
    nombrespropietario character varying(60) NOT NULL,
    apellidospropietario character varying(60) NOT NULL,
    direccion character varying(100) NOT NULL,
    numerocasa character varying(10) NOT NULL
);


ALTER TABLE public.vivienda OWNER TO postgres;

--
-- Name: vivienda_idvivienda_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.vivienda_idvivienda_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.vivienda_idvivienda_seq OWNER TO postgres;

--
-- Name: vivienda_idvivienda_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.vivienda_idvivienda_seq OWNED BY public.vivienda.idvivienda;


--
-- Name: detalle_mantenimiento iddetallemantenimiento; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.detalle_mantenimiento ALTER COLUMN iddetallemantenimiento SET DEFAULT nextval('public.detalle_mantenimiento_iddetallemantenimiento_seq'::regclass);


--
-- Name: mantenimiento idmantenimiento; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.mantenimiento ALTER COLUMN idmantenimiento SET DEFAULT nextval('public.mantenimiento_idmantenimiento_seq'::regclass);


--
-- Name: trabajo_mantenimiento idtrabajo; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.trabajo_mantenimiento ALTER COLUMN idtrabajo SET DEFAULT nextval('public.trabajo_mantenimiento_idtrabajo_seq'::regclass);


--
-- Name: vivienda idvivienda; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.vivienda ALTER COLUMN idvivienda SET DEFAULT nextval('public.vivienda_idvivienda_seq'::regclass);


--
-- Data for Name: detalle_mantenimiento; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.detalle_mantenimiento (iddetallemantenimiento, descripcion, cantidad, valorunitario, valortotal, det_trabajo, det_mantenimiento) FROM stdin;
1	ff	1	15.25	15.25	1	4
2	ff	1	15.25	15.25	1	4
3	ff	1	15.25	15.25	1	4
4		1	15.25	15.25	1	7
5		1	15.25	15.25	1	7
6		1	15.25	15.25	1	7
7		1	15.25	15.25	1	8
8		1	15.25	15.25	1	8
9		1	15.25	15.25	1	8
10		1	15.25	15.25	1	9
11		1	15.25	15.25	1	9
12		1	15.25	15.25	1	9
\.


--
-- Data for Name: mantenimiento; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.mantenimiento (idmantenimiento, fechamantenimiento, mant_vivienda, costototal) FROM stdin;
1	2022-02-16	12	15.25
2	2022-02-16	12	30.50
3	2022-02-16	17	30.50
4	2022-02-16	18	45.75
7	2022-02-16	19	45.75
8	2022-02-16	20	45.75
9	2022-02-16	12	45.75
\.


--
-- Data for Name: trabajo_mantenimiento; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.trabajo_mantenimiento (idtrabajo, nombretrabajo, valortrabajo) FROM stdin;
1	Pintura	15.25
2	cambio de baldosas	25.36
3	, lacado de pisos de madera	14.26
4	limpieza de alfombras	8.25
5	Mantenimiento Banios	67.23
\.


--
-- Data for Name: vivienda; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.vivienda (idvivienda, nombrespropietario, apellidospropietario, direccion, numerocasa) FROM stdin;
12	Mario	Salazar	Ibarra	10
17	l	l	l	11
18	12	12	12	12
19	13	2	13	13
20	15	15	15	15
\.


--
-- Name: detalle_mantenimiento_iddetallemantenimiento_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.detalle_mantenimiento_iddetallemantenimiento_seq', 12, true);


--
-- Name: mantenimiento_idmantenimiento_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.mantenimiento_idmantenimiento_seq', 9, true);


--
-- Name: trabajo_mantenimiento_idtrabajo_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.trabajo_mantenimiento_idtrabajo_seq', 5, true);


--
-- Name: vivienda_idvivienda_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.vivienda_idvivienda_seq', 20, true);


--
-- Name: detalle_mantenimiento pk_iddetmant; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.detalle_mantenimiento
    ADD CONSTRAINT pk_iddetmant PRIMARY KEY (iddetallemantenimiento);


--
-- Name: vivienda pk_idvivienda; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.vivienda
    ADD CONSTRAINT pk_idvivienda PRIMARY KEY (idvivienda);


--
-- Name: mantenimiento pk_mant; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.mantenimiento
    ADD CONSTRAINT pk_mant PRIMARY KEY (idmantenimiento);


--
-- Name: trabajo_mantenimiento pk_trabajo; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.trabajo_mantenimiento
    ADD CONSTRAINT pk_trabajo PRIMARY KEY (idtrabajo);


--
-- Name: detalle_mantenimiento fk_mantdet; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.detalle_mantenimiento
    ADD CONSTRAINT fk_mantdet FOREIGN KEY (det_mantenimiento) REFERENCES public.mantenimiento(idmantenimiento);


--
-- Name: detalle_mantenimiento fk_trabdet; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.detalle_mantenimiento
    ADD CONSTRAINT fk_trabdet FOREIGN KEY (det_trabajo) REFERENCES public.trabajo_mantenimiento(idtrabajo);


--
-- Name: mantenimiento fk_vm; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.mantenimiento
    ADD CONSTRAINT fk_vm FOREIGN KEY (mant_vivienda) REFERENCES public.vivienda(idvivienda);


--
-- PostgreSQL database dump complete
--

