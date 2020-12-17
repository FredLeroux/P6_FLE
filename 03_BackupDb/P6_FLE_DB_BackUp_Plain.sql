--
-- PostgreSQL database dump
--

-- Dumped from database version 11.3
-- Dumped by pg_dump version 12.3

-- Started on 2020-12-17 12:31:04

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
-- TOC entry 7 (class 2615 OID 59712)
-- Name: cliff; Type: SCHEMA; Schema: -; Owner: cliff_Admin
--

CREATE SCHEMA cliff;


ALTER SCHEMA cliff OWNER TO "cliff_Admin";

SET default_tablespace = '';

--
-- TOC entry 196 (class 1259 OID 59713)
-- Name: climbing_site; Type: TABLE; Schema: cliff; Owner: cliff_Admin
--

CREATE TABLE cliff.climbing_site (
    id integer NOT NULL,
    climbing_site_name character varying(100) NOT NULL,
    official boolean NOT NULL,
    site_description character varying(200),
    altitude integer,
    height_min integer,
    height_max integer,
    number_of_routes integer NOT NULL,
    access_to_site character varying(500),
    french_state_fk integer NOT NULL,
    french_county_fk integer NOT NULL
);


ALTER TABLE cliff.climbing_site OWNER TO "cliff_Admin";

--
-- TOC entry 2973 (class 0 OID 0)
-- Dependencies: 196
-- Name: COLUMN climbing_site.official; Type: COMMENT; Schema: cliff; Owner: cliff_Admin
--

COMMENT ON COLUMN cliff.climbing_site.official IS 'Define a site as les amis de l escalade official';


--
-- TOC entry 197 (class 1259 OID 59719)
-- Name: climbing_site_comment_modification_log; Type: TABLE; Schema: cliff; Owner: cliff_Admin
--

CREATE TABLE cliff.climbing_site_comment_modification_log (
    id integer NOT NULL,
    modificatio_date timestamp without time zone NOT NULL,
    author character varying NOT NULL,
    comment_before_modification character varying NOT NULL,
    climbing_site_comment_fk integer NOT NULL
);


ALTER TABLE cliff.climbing_site_comment_modification_log OWNER TO "cliff_Admin";

--
-- TOC entry 2975 (class 0 OID 0)
-- Dependencies: 197
-- Name: COLUMN climbing_site_comment_modification_log.comment_before_modification; Type: COMMENT; Schema: cliff; Owner: cliff_Admin
--

COMMENT ON COLUMN cliff.climbing_site_comment_modification_log.comment_before_modification IS 'It is the comment before the modification';


--
-- TOC entry 198 (class 1259 OID 59725)
-- Name: climbing_site_comment_modification_log_id_seq; Type: SEQUENCE; Schema: cliff; Owner: cliff_Admin
--

CREATE SEQUENCE cliff.climbing_site_comment_modification_log_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE cliff.climbing_site_comment_modification_log_id_seq OWNER TO "cliff_Admin";

--
-- TOC entry 2977 (class 0 OID 0)
-- Dependencies: 198
-- Name: climbing_site_comment_modification_log_id_seq; Type: SEQUENCE OWNED BY; Schema: cliff; Owner: cliff_Admin
--

ALTER SEQUENCE cliff.climbing_site_comment_modification_log_id_seq OWNED BY cliff.climbing_site_comment_modification_log.id;


--
-- TOC entry 199 (class 1259 OID 59727)
-- Name: climbing_site_comments; Type: TABLE; Schema: cliff; Owner: cliff_Admin
--

CREATE TABLE cliff.climbing_site_comments (
    id integer NOT NULL,
    comment character varying NOT NULL,
    climbing_site_fk integer NOT NULL,
    post_date timestamp without time zone NOT NULL,
    comment_author character varying(16) NOT NULL
);


ALTER TABLE cliff.climbing_site_comments OWNER TO "cliff_Admin";

--
-- TOC entry 200 (class 1259 OID 59733)
-- Name: climbing_site_comments_id_seq; Type: SEQUENCE; Schema: cliff; Owner: cliff_Admin
--

CREATE SEQUENCE cliff.climbing_site_comments_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE cliff.climbing_site_comments_id_seq OWNER TO "cliff_Admin";

--
-- TOC entry 2980 (class 0 OID 0)
-- Dependencies: 200
-- Name: climbing_site_comments_id_seq; Type: SEQUENCE OWNED BY; Schema: cliff; Owner: cliff_Admin
--

ALTER SEQUENCE cliff.climbing_site_comments_id_seq OWNED BY cliff.climbing_site_comments.id;


--
-- TOC entry 201 (class 1259 OID 59735)
-- Name: climbing_site_id_seq; Type: SEQUENCE; Schema: cliff; Owner: cliff_Admin
--

CREATE SEQUENCE cliff.climbing_site_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE cliff.climbing_site_id_seq OWNER TO "cliff_Admin";

--
-- TOC entry 2982 (class 0 OID 0)
-- Dependencies: 201
-- Name: climbing_site_id_seq; Type: SEQUENCE OWNED BY; Schema: cliff; Owner: cliff_Admin
--

ALTER SEQUENCE cliff.climbing_site_id_seq OWNED BY cliff.climbing_site.id;


--
-- TOC entry 202 (class 1259 OID 59737)
-- Name: climbing_topo; Type: TABLE; Schema: cliff; Owner: cliff_Admin
--

CREATE TABLE cliff.climbing_topo (
    id integer NOT NULL,
    title character varying(100) NOT NULL,
    edition_year character varying(4) NOT NULL,
    availabe boolean NOT NULL,
    topo_description character varying(200),
    french_state_fk integer NOT NULL,
    users_info_fk integer NOT NULL
);


ALTER TABLE cliff.climbing_topo OWNER TO "cliff_Admin";

--
-- TOC entry 2984 (class 0 OID 0)
-- Dependencies: 202
-- Name: COLUMN climbing_topo.title; Type: COMMENT; Schema: cliff; Owner: cliff_Admin
--

COMMENT ON COLUMN cliff.climbing_topo.title IS 'The complete topo title 100 char for now will be enough for subtitle too';


--
-- TOC entry 2985 (class 0 OID 0)
-- Dependencies: 202
-- Name: COLUMN climbing_topo.edition_year; Type: COMMENT; Schema: cliff; Owner: cliff_Admin
--

COMMENT ON COLUMN cliff.climbing_topo.edition_year IS 'past constraint';


--
-- TOC entry 2986 (class 0 OID 0)
-- Dependencies: 202
-- Name: COLUMN climbing_topo.users_info_fk; Type: COMMENT; Schema: cliff; Owner: cliff_Admin
--

COMMENT ON COLUMN cliff.climbing_topo.users_info_fk IS 'Is the topo owner';


--
-- TOC entry 203 (class 1259 OID 59740)
-- Name: climbing_topo_id_seq; Type: SEQUENCE; Schema: cliff; Owner: cliff_Admin
--

CREATE SEQUENCE cliff.climbing_topo_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE cliff.climbing_topo_id_seq OWNER TO "cliff_Admin";

--
-- TOC entry 2988 (class 0 OID 0)
-- Dependencies: 203
-- Name: climbing_topo_id_seq; Type: SEQUENCE OWNED BY; Schema: cliff; Owner: cliff_Admin
--

ALTER SEQUENCE cliff.climbing_topo_id_seq OWNED BY cliff.climbing_topo.id;


--
-- TOC entry 204 (class 1259 OID 59742)
-- Name: french_climbing_level; Type: TABLE; Schema: cliff; Owner: cliff_Admin
--

CREATE TABLE cliff.french_climbing_level (
    id integer NOT NULL,
    cotation_level character varying(3) NOT NULL
);


ALTER TABLE cliff.french_climbing_level OWNER TO "cliff_Admin";

--
-- TOC entry 2990 (class 0 OID 0)
-- Dependencies: 204
-- Name: TABLE french_climbing_level; Type: COMMENT; Schema: cliff; Owner: cliff_Admin
--

COMMENT ON TABLE cliff.french_climbing_level IS 'Contaisn the different climbing levels in france according to french cotation 
see https://fr.wikipedia.org/wiki/Cotation_en_escalade';


--
-- TOC entry 205 (class 1259 OID 59745)
-- Name: french_climbing_level_id_seq; Type: SEQUENCE; Schema: cliff; Owner: cliff_Admin
--

CREATE SEQUENCE cliff.french_climbing_level_id_seq
    START WITH 1
    INCREMENT BY 1
    MINVALUE 0
    NO MAXVALUE
    CACHE 1;


ALTER TABLE cliff.french_climbing_level_id_seq OWNER TO "cliff_Admin";

--
-- TOC entry 2992 (class 0 OID 0)
-- Dependencies: 205
-- Name: french_climbing_level_id_seq; Type: SEQUENCE OWNED BY; Schema: cliff; Owner: cliff_Admin
--

ALTER SEQUENCE cliff.french_climbing_level_id_seq OWNED BY cliff.french_climbing_level.id;


--
-- TOC entry 206 (class 1259 OID 59747)
-- Name: french_counties; Type: TABLE; Schema: cliff; Owner: cliff_Admin
--

CREATE TABLE cliff.french_counties (
    id integer NOT NULL,
    county_number character varying(3) NOT NULL,
    county_name character varying(30) NOT NULL,
    french_state_fk integer NOT NULL
);


ALTER TABLE cliff.french_counties OWNER TO "cliff_Admin";

--
-- TOC entry 2994 (class 0 OID 0)
-- Dependencies: 206
-- Name: TABLE french_counties; Type: COMMENT; Schema: cliff; Owner: cliff_Admin
--

COMMENT ON TABLE cliff.french_counties IS 'Contains all french counties 
update see french state
from : see french state';


--
-- TOC entry 207 (class 1259 OID 59750)
-- Name: french_counties_id_seq; Type: SEQUENCE; Schema: cliff; Owner: cliff_Admin
--

CREATE SEQUENCE cliff.french_counties_id_seq
    START WITH 1
    INCREMENT BY 1
    MINVALUE 0
    NO MAXVALUE
    CACHE 1;


ALTER TABLE cliff.french_counties_id_seq OWNER TO "cliff_Admin";

--
-- TOC entry 2996 (class 0 OID 0)
-- Dependencies: 207
-- Name: french_counties_id_seq; Type: SEQUENCE OWNED BY; Schema: cliff; Owner: cliff_Admin
--

ALTER SEQUENCE cliff.french_counties_id_seq OWNED BY cliff.french_counties.id;


--
-- TOC entry 208 (class 1259 OID 59752)
-- Name: french_states; Type: TABLE; Schema: cliff; Owner: cliff_Admin
--

CREATE TABLE cliff.french_states (
    id integer NOT NULL,
    state_number numeric(2,0) NOT NULL,
    state_name character varying(30) NOT NULL
);


ALTER TABLE cliff.french_states OWNER TO "cliff_Admin";

--
-- TOC entry 2998 (class 0 OID 0)
-- Dependencies: 208
-- Name: TABLE french_states; Type: COMMENT; Schema: cliff; Owner: cliff_Admin
--

COMMENT ON TABLE cliff.french_states IS 'Contains all french states 
last update : 2018 
from https://www.insee.fr/';


--
-- TOC entry 209 (class 1259 OID 59755)
-- Name: french_states_id_seq; Type: SEQUENCE; Schema: cliff; Owner: cliff_Admin
--

CREATE SEQUENCE cliff.french_states_id_seq
    START WITH 1
    INCREMENT BY 1
    MINVALUE 0
    NO MAXVALUE
    CACHE 1;


ALTER TABLE cliff.french_states_id_seq OWNER TO "cliff_Admin";

--
-- TOC entry 3000 (class 0 OID 0)
-- Dependencies: 209
-- Name: french_states_id_seq; Type: SEQUENCE OWNED BY; Schema: cliff; Owner: cliff_Admin
--

ALTER SEQUENCE cliff.french_states_id_seq OWNED BY cliff.french_states.id;


--
-- TOC entry 210 (class 1259 OID 59757)
-- Name: route_pitch; Type: TABLE; Schema: cliff; Owner: cliff_Admin
--

CREATE TABLE cliff.route_pitch (
    id integer NOT NULL,
    pitch_number integer NOT NULL,
    site_route_fk integer NOT NULL,
    french_climbing_level_fk integer NOT NULL
);


ALTER TABLE cliff.route_pitch OWNER TO "cliff_Admin";

--
-- TOC entry 211 (class 1259 OID 59760)
-- Name: route_pitch_id_seq; Type: SEQUENCE; Schema: cliff; Owner: cliff_Admin
--

CREATE SEQUENCE cliff.route_pitch_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE cliff.route_pitch_id_seq OWNER TO "cliff_Admin";

--
-- TOC entry 3003 (class 0 OID 0)
-- Dependencies: 211
-- Name: route_pitch_id_seq; Type: SEQUENCE OWNED BY; Schema: cliff; Owner: cliff_Admin
--

ALTER SEQUENCE cliff.route_pitch_id_seq OWNED BY cliff.route_pitch.id;


--
-- TOC entry 212 (class 1259 OID 59762)
-- Name: site_routes; Type: TABLE; Schema: cliff; Owner: cliff_Admin
--

CREATE TABLE cliff.site_routes (
    id integer NOT NULL,
    route_name character varying(100),
    climbing_site_fk integer NOT NULL
);


ALTER TABLE cliff.site_routes OWNER TO "cliff_Admin";

--
-- TOC entry 213 (class 1259 OID 59765)
-- Name: site_routes_id_seq; Type: SEQUENCE; Schema: cliff; Owner: cliff_Admin
--

CREATE SEQUENCE cliff.site_routes_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE cliff.site_routes_id_seq OWNER TO "cliff_Admin";

--
-- TOC entry 3006 (class 0 OID 0)
-- Dependencies: 213
-- Name: site_routes_id_seq; Type: SEQUENCE OWNED BY; Schema: cliff; Owner: cliff_Admin
--

ALTER SEQUENCE cliff.site_routes_id_seq OWNED BY cliff.site_routes.id;


--
-- TOC entry 214 (class 1259 OID 59767)
-- Name: topo_lending; Type: TABLE; Schema: cliff; Owner: cliff_Admin
--

CREATE TABLE cliff.topo_lending (
    id integer NOT NULL,
    climbing_topo_fk integer NOT NULL,
    lender_user_info_fk integer NOT NULL,
    borrower_user_info_fk integer NOT NULL,
    lending_status character varying NOT NULL
);


ALTER TABLE cliff.topo_lending OWNER TO "cliff_Admin";

--
-- TOC entry 215 (class 1259 OID 59773)
-- Name: topo_lending_id_seq; Type: SEQUENCE; Schema: cliff; Owner: cliff_Admin
--

CREATE SEQUENCE cliff.topo_lending_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE cliff.topo_lending_id_seq OWNER TO "cliff_Admin";

--
-- TOC entry 3009 (class 0 OID 0)
-- Dependencies: 215
-- Name: topo_lending_id_seq; Type: SEQUENCE OWNED BY; Schema: cliff; Owner: cliff_Admin
--

ALTER SEQUENCE cliff.topo_lending_id_seq OWNED BY cliff.topo_lending.id;


--
-- TOC entry 216 (class 1259 OID 59775)
-- Name: users_account_info; Type: TABLE; Schema: cliff; Owner: cliff_Admin
--

CREATE TABLE cliff.users_account_info (
    id integer NOT NULL,
    login character varying(254) NOT NULL,
    password character varying(60) NOT NULL,
    pseudonyme character varying(30) NOT NULL,
    sign_up_date date NOT NULL,
    login_tentative_number integer NOT NULL,
    security_level integer NOT NULL,
    is_member boolean DEFAULT false NOT NULL,
    account_activation_status boolean DEFAULT false NOT NULL,
    activation_code character(24),
    password_reset_code character varying(36)
);


ALTER TABLE cliff.users_account_info OWNER TO "cliff_Admin";

--
-- TOC entry 3011 (class 0 OID 0)
-- Dependencies: 216
-- Name: COLUMN users_account_info.login; Type: COMMENT; Schema: cliff; Owner: cliff_Admin
--

COMMENT ON COLUMN cliff.users_account_info.login IS '254 as can be e-mail address';


--
-- TOC entry 3012 (class 0 OID 0)
-- Dependencies: 216
-- Name: COLUMN users_account_info.password; Type: COMMENT; Schema: cliff; Owner: cliff_Admin
--

COMMENT ON COLUMN cliff.users_account_info.password IS '60 as encoded via bcrypt';


--
-- TOC entry 3013 (class 0 OID 0)
-- Dependencies: 216
-- Name: COLUMN users_account_info.security_level; Type: COMMENT; Schema: cliff; Owner: cliff_Admin
--

COMMENT ON COLUMN cliff.users_account_info.security_level IS 'define the rights of the account';


--
-- TOC entry 3014 (class 0 OID 0)
-- Dependencies: 216
-- Name: COLUMN users_account_info.is_member; Type: COMMENT; Schema: cliff; Owner: cliff_Admin
--

COMMENT ON COLUMN cliff.users_account_info.is_member IS 'Determinate if an User is an association member or not';


--
-- TOC entry 3015 (class 0 OID 0)
-- Dependencies: 216
-- Name: COLUMN users_account_info.account_activation_status; Type: COMMENT; Schema: cliff; Owner: cliff_Admin
--

COMMENT ON COLUMN cliff.users_account_info.account_activation_status IS 'An account is activated (true) or not (false)';


--
-- TOC entry 217 (class 1259 OID 59780)
-- Name: users_account_info_id_seq; Type: SEQUENCE; Schema: cliff; Owner: cliff_Admin
--

CREATE SEQUENCE cliff.users_account_info_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE cliff.users_account_info_id_seq OWNER TO "cliff_Admin";

--
-- TOC entry 3017 (class 0 OID 0)
-- Dependencies: 217
-- Name: users_account_info_id_seq; Type: SEQUENCE OWNED BY; Schema: cliff; Owner: cliff_Admin
--

ALTER SEQUENCE cliff.users_account_info_id_seq OWNED BY cliff.users_account_info.id;


--
-- TOC entry 218 (class 1259 OID 59782)
-- Name: users_info; Type: TABLE; Schema: cliff; Owner: cliff_Admin
--

CREATE TABLE cliff.users_info (
    id integer NOT NULL,
    first_name character varying(30),
    last_name character varying(30),
    email_address character varying(254) NOT NULL,
    gender character varying(30),
    account_info_fk integer NOT NULL,
    french_state_fk integer,
    french_county_fk integer,
    french_climbing_level_fk integer,
    birth_date date
);


ALTER TABLE cliff.users_info OWNER TO "cliff_Admin";

--
-- TOC entry 3019 (class 0 OID 0)
-- Dependencies: 218
-- Name: TABLE users_info; Type: COMMENT; Schema: cliff; Owner: cliff_Admin
--

COMMENT ON TABLE cliff.users_info IS 'Contains association users information';


--
-- TOC entry 3020 (class 0 OID 0)
-- Dependencies: 218
-- Name: COLUMN users_info.first_name; Type: COMMENT; Schema: cliff; Owner: cliff_Admin
--

COMMENT ON COLUMN cliff.users_info.first_name IS 'Can be null if user do not wich share it';


--
-- TOC entry 3021 (class 0 OID 0)
-- Dependencies: 218
-- Name: COLUMN users_info.last_name; Type: COMMENT; Schema: cliff; Owner: cliff_Admin
--

COMMENT ON COLUMN cliff.users_info.last_name IS 'Can be null if user do not wich share it';


--
-- TOC entry 3022 (class 0 OID 0)
-- Dependencies: 218
-- Name: COLUMN users_info.email_address; Type: COMMENT; Schema: cliff; Owner: cliff_Admin
--

COMMENT ON COLUMN cliff.users_info.email_address IS '254 see https://mydnic.be/post/longueur-dun-varchar-pour-un-champ-email';


--
-- TOC entry 3023 (class 0 OID 0)
-- Dependencies: 218
-- Name: COLUMN users_info.gender; Type: COMMENT; Schema: cliff; Owner: cliff_Admin
--

COMMENT ON COLUMN cliff.users_info.gender IS 'Can be null if user do not wich share it
Note may think about LGBT community';


--
-- TOC entry 3024 (class 0 OID 0)
-- Dependencies: 218
-- Name: COLUMN users_info.french_state_fk; Type: COMMENT; Schema: cliff; Owner: cliff_Admin
--

COMMENT ON COLUMN cliff.users_info.french_state_fk IS 'Can be null if user do not wich share it';


--
-- TOC entry 3025 (class 0 OID 0)
-- Dependencies: 218
-- Name: COLUMN users_info.french_county_fk; Type: COMMENT; Schema: cliff; Owner: cliff_Admin
--

COMMENT ON COLUMN cliff.users_info.french_county_fk IS 'Can be null if user do not wich share it';


--
-- TOC entry 3026 (class 0 OID 0)
-- Dependencies: 218
-- Name: COLUMN users_info.french_climbing_level_fk; Type: COMMENT; Schema: cliff; Owner: cliff_Admin
--

COMMENT ON COLUMN cliff.users_info.french_climbing_level_fk IS 'Can be null if user do not wich share it';


--
-- TOC entry 219 (class 1259 OID 59785)
-- Name: users_info_id_seq; Type: SEQUENCE; Schema: cliff; Owner: cliff_Admin
--

CREATE SEQUENCE cliff.users_info_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE cliff.users_info_id_seq OWNER TO "cliff_Admin";

--
-- TOC entry 3028 (class 0 OID 0)
-- Dependencies: 219
-- Name: users_info_id_seq; Type: SEQUENCE OWNED BY; Schema: cliff; Owner: cliff_Admin
--

ALTER SEQUENCE cliff.users_info_id_seq OWNED BY cliff.users_info.id;


--
-- TOC entry 2755 (class 2604 OID 59923)
-- Name: climbing_site id; Type: DEFAULT; Schema: cliff; Owner: cliff_Admin
--

ALTER TABLE ONLY cliff.climbing_site ALTER COLUMN id SET DEFAULT nextval('cliff.climbing_site_id_seq'::regclass);


--
-- TOC entry 2756 (class 2604 OID 59924)
-- Name: climbing_site_comment_modification_log id; Type: DEFAULT; Schema: cliff; Owner: cliff_Admin
--

ALTER TABLE ONLY cliff.climbing_site_comment_modification_log ALTER COLUMN id SET DEFAULT nextval('cliff.climbing_site_comment_modification_log_id_seq'::regclass);


--
-- TOC entry 2757 (class 2604 OID 59925)
-- Name: climbing_site_comments id; Type: DEFAULT; Schema: cliff; Owner: cliff_Admin
--

ALTER TABLE ONLY cliff.climbing_site_comments ALTER COLUMN id SET DEFAULT nextval('cliff.climbing_site_comments_id_seq'::regclass);


--
-- TOC entry 2758 (class 2604 OID 59926)
-- Name: climbing_topo id; Type: DEFAULT; Schema: cliff; Owner: cliff_Admin
--

ALTER TABLE ONLY cliff.climbing_topo ALTER COLUMN id SET DEFAULT nextval('cliff.climbing_topo_id_seq'::regclass);


--
-- TOC entry 2759 (class 2604 OID 59927)
-- Name: french_climbing_level id; Type: DEFAULT; Schema: cliff; Owner: cliff_Admin
--

ALTER TABLE ONLY cliff.french_climbing_level ALTER COLUMN id SET DEFAULT nextval('cliff.french_climbing_level_id_seq'::regclass);


--
-- TOC entry 2760 (class 2604 OID 59928)
-- Name: french_counties id; Type: DEFAULT; Schema: cliff; Owner: cliff_Admin
--

ALTER TABLE ONLY cliff.french_counties ALTER COLUMN id SET DEFAULT nextval('cliff.french_counties_id_seq'::regclass);


--
-- TOC entry 2761 (class 2604 OID 59929)
-- Name: french_states id; Type: DEFAULT; Schema: cliff; Owner: cliff_Admin
--

ALTER TABLE ONLY cliff.french_states ALTER COLUMN id SET DEFAULT nextval('cliff.french_states_id_seq'::regclass);


--
-- TOC entry 2762 (class 2604 OID 59930)
-- Name: route_pitch id; Type: DEFAULT; Schema: cliff; Owner: cliff_Admin
--

ALTER TABLE ONLY cliff.route_pitch ALTER COLUMN id SET DEFAULT nextval('cliff.route_pitch_id_seq'::regclass);


--
-- TOC entry 2763 (class 2604 OID 59931)
-- Name: site_routes id; Type: DEFAULT; Schema: cliff; Owner: cliff_Admin
--

ALTER TABLE ONLY cliff.site_routes ALTER COLUMN id SET DEFAULT nextval('cliff.site_routes_id_seq'::regclass);


--
-- TOC entry 2764 (class 2604 OID 59932)
-- Name: topo_lending id; Type: DEFAULT; Schema: cliff; Owner: cliff_Admin
--

ALTER TABLE ONLY cliff.topo_lending ALTER COLUMN id SET DEFAULT nextval('cliff.topo_lending_id_seq'::regclass);


--
-- TOC entry 2767 (class 2604 OID 59933)
-- Name: users_account_info id; Type: DEFAULT; Schema: cliff; Owner: cliff_Admin
--

ALTER TABLE ONLY cliff.users_account_info ALTER COLUMN id SET DEFAULT nextval('cliff.users_account_info_id_seq'::regclass);


--
-- TOC entry 2768 (class 2604 OID 59934)
-- Name: users_info id; Type: DEFAULT; Schema: cliff; Owner: cliff_Admin
--

ALTER TABLE ONLY cliff.users_info ALTER COLUMN id SET DEFAULT nextval('cliff.users_info_id_seq'::regclass);


--
-- TOC entry 2943 (class 0 OID 59713)
-- Dependencies: 196
-- Data for Name: climbing_site; Type: TABLE DATA; Schema: cliff; Owner: cliff_Admin
--

COPY cliff.climbing_site (id, climbing_site_name, official, site_description, altitude, height_min, height_max, number_of_routes, access_to_site, french_state_fk, french_county_fk) FROM stdin;
25	La grimpe	f	Site d'escalade de type block	500	5	15	4	Plan d’accès disponible à l'office de tourisme	11	53
26	La Falaise	t	Site naturel	1100	20	40	7	Se rendre sur le site	16	43
\.


--
-- TOC entry 2944 (class 0 OID 59719)
-- Dependencies: 197
-- Data for Name: climbing_site_comment_modification_log; Type: TABLE DATA; Schema: cliff; Owner: cliff_Admin
--

COPY cliff.climbing_site_comment_modification_log (id, modificatio_date, author, comment_before_modification, climbing_site_comment_fk) FROM stdin;
\.


--
-- TOC entry 2946 (class 0 OID 59727)
-- Dependencies: 199
-- Data for Name: climbing_site_comments; Type: TABLE DATA; Schema: cliff; Owner: cliff_Admin
--

COPY cliff.climbing_site_comments (id, comment, climbing_site_fk, post_date, comment_author) FROM stdin;
147	Un commentaire	26	2020-08-25 22:17:50.518	Redfirce
148	Un autre commentaire	26	2020-08-25 22:18:49.15	Frederic
149	Un commentaire	25	2020-08-25 22:20:43.232	Frederic
\.


--
-- TOC entry 2949 (class 0 OID 59737)
-- Dependencies: 202
-- Data for Name: climbing_topo; Type: TABLE DATA; Schema: cliff; Owner: cliff_Admin
--

COPY cliff.climbing_topo (id, title, edition_year, availabe, topo_description, french_state_fk, users_info_fk) FROM stdin;
54	Un topo	2017	t	Un topo	15	147
55	Les sites de Franche-Comté	2010	t	Liste des différent spots de Franche-Comté	8	147
56	Almanach du Grimpeur	1985	t	Historique et liste 	6	147
\.


--
-- TOC entry 2951 (class 0 OID 59742)
-- Dependencies: 204
-- Data for Name: french_climbing_level; Type: TABLE DATA; Schema: cliff; Owner: cliff_Admin
--

COPY cliff.french_climbing_level (id, cotation_level) FROM stdin;
1	0
2	1
3	2
4	3
5	4
6	5
7	5a
8	5b
9	5c
10	6a
11	6a+
12	6b
13	6b+
14	6c
15	6c+
16	7a
17	7a+
18	7b
19	7b+
20	7c
21	7c+
22	8a
23	8a+
24	8b
25	8b+
26	8c
27	8c+
28	9a 
29	9a+
30	9b
31	9b+
32	9c
\.


--
-- TOC entry 2953 (class 0 OID 59747)
-- Dependencies: 206
-- Data for Name: french_counties; Type: TABLE DATA; Schema: cliff; Owner: cliff_Admin
--

COPY cliff.french_counties (id, county_number, county_name, french_state_fk) FROM stdin;
1	1	Ain	16
2	2	Aisne	10
3	3	Allier	16
4	4	Alpes-de-Haute-Provence	17
5	5	Hautes-Alpes	17
6	6	Alpes-Maritimes	17
7	7	Ardèche	16
8	8	Ardennes	11
9	9	Ariège	15
10	10	Aube	11
11	11	Aude	15
12	12	Aveyron	15
13	13	Bouches-du-Rhône	17
14	14	Calvados	9
15	15	Cantal	16
16	16	Charente	14
17	17	Charente-Maritime	14
18	18	Cher	7
19	19	Corrèze	14
20	21	Côte-d'Or	8
21	22	Côtes-d'Armor	13
22	23	Creuse	14
23	24	Dordogne	14
24	25	Doubs	8
25	26	Drôme	16
26	27	Eure	9
27	28	Eure-et-Loir	7
28	29	Finistère	13
29	2A	Corse-du-Sud	18
30	2B	Haute-Corse	18
31	30	Gard	15
32	31	Haute-Garonne	15
33	32	Gers	15
34	33	Gironde	14
35	34	Hérault	15
36	35	Ille-et-Vilaine	13
37	36	Indre	7
38	37	Indre-et-Loire	7
39	38	Isère	16
40	39	Jura	8
41	40	Landes	14
42	41	Loir-et-Cher	7
43	42	Loire	16
44	43	Haute-Loire	16
45	44	Loire-Atlantique	12
46	45	Loiret	7
47	46	Lot	15
48	47	Lot-et-Garonne	14
49	48	Lozère	15
50	49	Maine-et-Loire	12
51	50	Manche	9
52	51	Marne	11
53	52	Haute-Marne	11
54	53	Mayenne	12
55	54	Meurthe-et-Moselle	11
56	55	Meuse	11
57	56	Morbihan	13
58	57	Moselle	11
59	58	Nièvre	8
60	59	Nord	10
61	60	Oise	10
62	61	Orne	9
63	62	Pas-de-Calais	10
64	63	Puy-de-Dôme	16
65	64	Pyrénées-Atlantiques	14
66	65	Hautes-Pyrénées	15
67	66	Pyrénées-Orientales	15
68	67	Bas-Rhin	11
69	68	Haut-Rhin	11
70	69	Rhône	16
71	70	Haute-Saône	8
72	71	Saône-et-Loire	8
73	72	Sarthe	12
74	73	Savoie	16
75	74	Haute-Savoie	16
76	75	Paris	6
77	76	Seine-Maritime	9
78	77	Seine-et-Marne	6
79	78	Yvelines	6
80	79	Deux-Sèvres	14
81	80	Somme	10
82	81	Tarn	15
83	82	Tarn-et-Garonne	15
84	83	Var	17
85	84	Vaucluse	17
86	85	Vendée	12
87	86	Vienne	14
88	87	Haute-Vienne	14
89	88	Vosges	11
90	89	Yonne	8
91	90	Territoire de Belfort	8
92	91	Essonne	6
93	92	Hauts-de-Seine	6
94	93	Seine-Saint-Denis	6
95	94	Val-de-Marne	6
96	95	Val-d'Oise	6
97	971	Guadeloupe	1
98	972	Martinique	2
99	973	Guyane	3
100	974	La Réunion	4
101	976	Mayotte	5
102	0		19
\.


--
-- TOC entry 2955 (class 0 OID 59752)
-- Dependencies: 208
-- Data for Name: french_states; Type: TABLE DATA; Schema: cliff; Owner: cliff_Admin
--

COPY cliff.french_states (id, state_number, state_name) FROM stdin;
1	1	GUADELOUPE
2	2	MARTINIQUE
3	3	GUYANE
4	4	LA REUNION
5	6	MAYOTTE
6	11	ILE-DE-FRANCE
7	24	CENTRE-VAL DE LOIRE
8	27	BOURGOGNE-FRANCHE-COMTE
9	28	NORMANDIE
10	32	HAUTS-DE-FRANCE
11	44	GRAND EST
12	52	PAYS DE LA LOIRE
13	53	BRETAGNE
14	75	NOUVELLE-AQUITAINE
15	76	OCCITANIE
16	84	AUVERGNE-RHONE-ALPES
17	93	PROVENCE-ALPES-COTE D 'AZUR
18	94	CORSE
19	0	
\.


--
-- TOC entry 2957 (class 0 OID 59757)
-- Dependencies: 210
-- Data for Name: route_pitch; Type: TABLE DATA; Schema: cliff; Owner: cliff_Admin
--

COPY cliff.route_pitch (id, pitch_number, site_route_fk, french_climbing_level_fk) FROM stdin;
67	1	34	10
68	2	34	14
69	1	35	18
70	2	35	8
71	1	36	10
72	2	36	8
73	1	37	6
74	2	37	19
75	1	38	10
76	1	39	6
77	1	40	13
78	1	41	30
79	1	42	16
80	1	43	22
81	1	44	5
\.


--
-- TOC entry 2959 (class 0 OID 59762)
-- Dependencies: 212
-- Data for Name: site_routes; Type: TABLE DATA; Schema: cliff; Owner: cliff_Admin
--

COPY cliff.site_routes (id, route_name, climbing_site_fk) FROM stdin;
34	Block A	25
35	Block B	25
36	Block C	25
37	Block D	25
38	Voie 1	26
39	Facile 	26
40	Un peu moins facile	26
41	Extrême	26
42	Difficile	26
43	Un peu plus difficile	26
44	Pas compliquer	26
\.


--
-- TOC entry 2961 (class 0 OID 59767)
-- Dependencies: 214
-- Data for Name: topo_lending; Type: TABLE DATA; Schema: cliff; Owner: cliff_Admin
--

COPY cliff.topo_lending (id, climbing_topo_fk, lender_user_info_fk, borrower_user_info_fk, lending_status) FROM stdin;
\.


--
-- TOC entry 2963 (class 0 OID 59775)
-- Dependencies: 216
-- Data for Name: users_account_info; Type: TABLE DATA; Schema: cliff; Owner: cliff_Admin
--

COPY cliff.users_account_info (id, login, password, pseudonyme, sign_up_date, login_tentative_number, security_level, is_member, account_activation_status, activation_code, password_reset_code) FROM stdin;
27	Administrateur	$2a$10$y1BY1cdvMmAZtNnG24bhEu/KxUwLxCjA7gD5Xuy8RuyYzjbCa1.Tq	Administrateur	2020-03-31	0	0	t	t	x7Hi22JW1wr07T2IzA6BL9o0	\N
146	Trasheur	$2a$10$qicdGn9QRLDmha5QIA2rgOQvXGOIfW8KwrKgwtSTlkoR7hquPZjGq	Trasheur	2020-08-25	0	2	f	f	\N	\N
140	Pierre	$2a$10$Nmjnwwesj2JjyRvj4.lSPOSFWJP2DjLj6hTZerK0Wh6kIFGY9aA/.	Pierre	2020-04-25	0	2	f	t	\N	\N
141	Jacques	$2a$10$NBVf2YBWVEWjzpbQ8z.n0edmxpMEG1YoMkiNYrWpyaqZV3b32bnRm	Jacques	2020-05-01	0	1	t	t	\N	\N
142	Paula01	$2a$10$F.oFyOWDaPNjxWwETGraM.nzl8SNvPqguTTl/SyNgklDEWPusRQuW	Paula01	2020-08-20	0	2	f	t	\N	\N
143	Henrietta	$2a$10$0wE7WCsBQ2DZwydhQOtKK.bSk0YmRsfxJka7JapkoekhoVC0Wj/Le	Henrietta	2020-06-20	0	2	f	t	\N	\N
144	Charlie04	$2a$10$PfjSzMwJ1WPBj3uyEX1j8eeMPYFOmzCCQBcNLK0u2oAuBjnlXVQPK	Charlie04	2020-07-25	0	2	f	t	\N	\N
145	Denis005	$2a$10$wgrl8P273WDKkT/X.ogrDOEkZseDsplcsB2NpYPB/QDU6QOt1erCe	Denis005	2020-07-25	0	2	f	t	\N	\N
147	Frederic	$2a$10$rayA3wTmpgq58nsjwInYSOpt6RVSilCq1e8ax7/.DU7It/HyP2.SS	Frederic	2020-08-25	0	1	t	t	Kh1518Sv05Ax23OW4X724H47	\N
148	Redfirce	$2a$10$6hVu3bC3SUm36HMlbsU86e4cBqVLPRXjJnmawvfGWvvR3xI9kxq1u	Redfirce	2020-12-17	0	2	f	t	\N	\N
\.


--
-- TOC entry 2965 (class 0 OID 59782)
-- Dependencies: 218
-- Data for Name: users_info; Type: TABLE DATA; Schema: cliff; Owner: cliff_Admin
--

COPY cliff.users_info (id, first_name, last_name, email_address, gender, account_info_fk, french_state_fk, french_county_fk, french_climbing_level_fk, birth_date) FROM stdin;
140	Pierre	Paul	Pierre@populatingTesting.fr	male	140	7	37	10	\N
141	Jacques	Henri	Jacques@populatingTesting.fr	male	141	14	17	13	1985-01-18
142	Paula	Hernit	Paula@populatingTesting.fr	female	142	7	38	19	1960-08-18
143	Henrietta	Alpha	Henrietta@populatingTesting.fr	noGender	143	\N	\N	1	1975-08-25
144	Alpha	Tango	Alpha@populatingTesting.fr	female	144	15	32	14	1980-08-08
146	Trash	Trash	Trasheur@populatingTesting.fr	noGender	146	\N	\N	1	\N
145	Denis	Road	Denis@populatingTesting.fr	noGender	145	\N	\N	1	1981-01-18
30	Administrateur	Administrateur	ocp6.fle@gmail.com	male	27	\N	\N	1	\N
147	Frederic	Leroux	Nope@gmail.com	male	147	8	24	1	1982-03-29
148	Redfirce	AA	Nope2@gmail.com	male	148	8	24	\N	\N
\.


--
-- TOC entry 3030 (class 0 OID 0)
-- Dependencies: 198
-- Name: climbing_site_comment_modification_log_id_seq; Type: SEQUENCE SET; Schema: cliff; Owner: cliff_Admin
--

SELECT pg_catalog.setval('cliff.climbing_site_comment_modification_log_id_seq', 27, true);


--
-- TOC entry 3031 (class 0 OID 0)
-- Dependencies: 200
-- Name: climbing_site_comments_id_seq; Type: SEQUENCE SET; Schema: cliff; Owner: cliff_Admin
--

SELECT pg_catalog.setval('cliff.climbing_site_comments_id_seq', 149, true);


--
-- TOC entry 3032 (class 0 OID 0)
-- Dependencies: 201
-- Name: climbing_site_id_seq; Type: SEQUENCE SET; Schema: cliff; Owner: cliff_Admin
--

SELECT pg_catalog.setval('cliff.climbing_site_id_seq', 26, true);


--
-- TOC entry 3033 (class 0 OID 0)
-- Dependencies: 203
-- Name: climbing_topo_id_seq; Type: SEQUENCE SET; Schema: cliff; Owner: cliff_Admin
--

SELECT pg_catalog.setval('cliff.climbing_topo_id_seq', 56, true);


--
-- TOC entry 3034 (class 0 OID 0)
-- Dependencies: 205
-- Name: french_climbing_level_id_seq; Type: SEQUENCE SET; Schema: cliff; Owner: cliff_Admin
--

SELECT pg_catalog.setval('cliff.french_climbing_level_id_seq', 32, true);


--
-- TOC entry 3035 (class 0 OID 0)
-- Dependencies: 207
-- Name: french_counties_id_seq; Type: SEQUENCE SET; Schema: cliff; Owner: cliff_Admin
--

SELECT pg_catalog.setval('cliff.french_counties_id_seq', 102, true);


--
-- TOC entry 3036 (class 0 OID 0)
-- Dependencies: 209
-- Name: french_states_id_seq; Type: SEQUENCE SET; Schema: cliff; Owner: cliff_Admin
--

SELECT pg_catalog.setval('cliff.french_states_id_seq', 19, true);


--
-- TOC entry 3037 (class 0 OID 0)
-- Dependencies: 211
-- Name: route_pitch_id_seq; Type: SEQUENCE SET; Schema: cliff; Owner: cliff_Admin
--

SELECT pg_catalog.setval('cliff.route_pitch_id_seq', 81, true);


--
-- TOC entry 3038 (class 0 OID 0)
-- Dependencies: 213
-- Name: site_routes_id_seq; Type: SEQUENCE SET; Schema: cliff; Owner: cliff_Admin
--

SELECT pg_catalog.setval('cliff.site_routes_id_seq', 44, true);


--
-- TOC entry 3039 (class 0 OID 0)
-- Dependencies: 215
-- Name: topo_lending_id_seq; Type: SEQUENCE SET; Schema: cliff; Owner: cliff_Admin
--

SELECT pg_catalog.setval('cliff.topo_lending_id_seq', 241, true);


--
-- TOC entry 3040 (class 0 OID 0)
-- Dependencies: 217
-- Name: users_account_info_id_seq; Type: SEQUENCE SET; Schema: cliff; Owner: cliff_Admin
--

SELECT pg_catalog.setval('cliff.users_account_info_id_seq', 149, true);


--
-- TOC entry 3041 (class 0 OID 0)
-- Dependencies: 219
-- Name: users_info_id_seq; Type: SEQUENCE SET; Schema: cliff; Owner: cliff_Admin
--

SELECT pg_catalog.setval('cliff.users_info_id_seq', 149, true);


--
-- TOC entry 2770 (class 2606 OID 59800)
-- Name: climbing_site Unique_Site_Name; Type: CONSTRAINT; Schema: cliff; Owner: cliff_Admin
--

ALTER TABLE ONLY cliff.climbing_site
    ADD CONSTRAINT "Unique_Site_Name" UNIQUE (climbing_site_name);


--
-- TOC entry 2775 (class 2606 OID 59802)
-- Name: climbing_site_comment_modification_log climbing_site_comment_modification_log_pk; Type: CONSTRAINT; Schema: cliff; Owner: cliff_Admin
--

ALTER TABLE ONLY cliff.climbing_site_comment_modification_log
    ADD CONSTRAINT climbing_site_comment_modification_log_pk PRIMARY KEY (id);


--
-- TOC entry 2777 (class 2606 OID 59804)
-- Name: climbing_site_comments climbing_site_comments_pk; Type: CONSTRAINT; Schema: cliff; Owner: cliff_Admin
--

ALTER TABLE ONLY cliff.climbing_site_comments
    ADD CONSTRAINT climbing_site_comments_pk PRIMARY KEY (id);


--
-- TOC entry 2773 (class 2606 OID 59806)
-- Name: climbing_site climbing_site_pk; Type: CONSTRAINT; Schema: cliff; Owner: cliff_Admin
--

ALTER TABLE ONLY cliff.climbing_site
    ADD CONSTRAINT climbing_site_pk PRIMARY KEY (id);


--
-- TOC entry 2779 (class 2606 OID 59808)
-- Name: climbing_topo climbing_topo_pk; Type: CONSTRAINT; Schema: cliff; Owner: cliff_Admin
--

ALTER TABLE ONLY cliff.climbing_topo
    ADD CONSTRAINT climbing_topo_pk PRIMARY KEY (id);


--
-- TOC entry 2782 (class 2606 OID 59810)
-- Name: french_climbing_level french_climbing_level_id_pk; Type: CONSTRAINT; Schema: cliff; Owner: cliff_Admin
--

ALTER TABLE ONLY cliff.french_climbing_level
    ADD CONSTRAINT french_climbing_level_id_pk PRIMARY KEY (id);


--
-- TOC entry 2784 (class 2606 OID 59812)
-- Name: french_counties french_counties_id; Type: CONSTRAINT; Schema: cliff; Owner: cliff_Admin
--

ALTER TABLE ONLY cliff.french_counties
    ADD CONSTRAINT french_counties_id PRIMARY KEY (id);


--
-- TOC entry 2788 (class 2606 OID 59814)
-- Name: french_states french_states_id; Type: CONSTRAINT; Schema: cliff; Owner: cliff_Admin
--

ALTER TABLE ONLY cliff.french_states
    ADD CONSTRAINT french_states_id PRIMARY KEY (id);


--
-- TOC entry 2792 (class 2606 OID 59816)
-- Name: route_pitch route_pitch_pk; Type: CONSTRAINT; Schema: cliff; Owner: cliff_Admin
--

ALTER TABLE ONLY cliff.route_pitch
    ADD CONSTRAINT route_pitch_pk PRIMARY KEY (id);


--
-- TOC entry 2794 (class 2606 OID 59818)
-- Name: site_routes site_routes_pk; Type: CONSTRAINT; Schema: cliff; Owner: cliff_Admin
--

ALTER TABLE ONLY cliff.site_routes
    ADD CONSTRAINT site_routes_pk PRIMARY KEY (id);


--
-- TOC entry 2796 (class 2606 OID 59820)
-- Name: topo_lending topo_lending_pk; Type: CONSTRAINT; Schema: cliff; Owner: cliff_Admin
--

ALTER TABLE ONLY cliff.topo_lending
    ADD CONSTRAINT topo_lending_pk PRIMARY KEY (id);


--
-- TOC entry 2798 (class 2606 OID 59822)
-- Name: users_account_info users_account__info_pk; Type: CONSTRAINT; Schema: cliff; Owner: cliff_Admin
--

ALTER TABLE ONLY cliff.users_account_info
    ADD CONSTRAINT users_account__info_pk PRIMARY KEY (id);


--
-- TOC entry 2804 (class 2606 OID 59824)
-- Name: users_info users_info_pk; Type: CONSTRAINT; Schema: cliff; Owner: cliff_Admin
--

ALTER TABLE ONLY cliff.users_info
    ADD CONSTRAINT users_info_pk PRIMARY KEY (id);


--
-- TOC entry 2771 (class 1259 OID 59825)
-- Name: climbing_site_ak; Type: INDEX; Schema: cliff; Owner: cliff_Admin
--

CREATE UNIQUE INDEX climbing_site_ak ON cliff.climbing_site USING btree (climbing_site_name);


--
-- TOC entry 2780 (class 1259 OID 59826)
-- Name: french_climbing_level_cotation_level_unique; Type: INDEX; Schema: cliff; Owner: cliff_Admin
--

CREATE UNIQUE INDEX french_climbing_level_cotation_level_unique ON cliff.french_climbing_level USING btree (cotation_level);


--
-- TOC entry 2785 (class 1259 OID 59827)
-- Name: french_counties_name; Type: INDEX; Schema: cliff; Owner: cliff_Admin
--

CREATE UNIQUE INDEX french_counties_name ON cliff.french_counties USING btree (county_name);


--
-- TOC entry 2786 (class 1259 OID 59828)
-- Name: french_counties_number; Type: INDEX; Schema: cliff; Owner: cliff_Admin
--

CREATE UNIQUE INDEX french_counties_number ON cliff.french_counties USING btree (county_number);


--
-- TOC entry 2789 (class 1259 OID 59829)
-- Name: french_states_name; Type: INDEX; Schema: cliff; Owner: cliff_Admin
--

CREATE UNIQUE INDEX french_states_name ON cliff.french_states USING btree (state_name);


--
-- TOC entry 2790 (class 1259 OID 59830)
-- Name: french_states_number; Type: INDEX; Schema: cliff; Owner: cliff_Admin
--

CREATE UNIQUE INDEX french_states_number ON cliff.french_states USING btree (state_number);


--
-- TOC entry 2799 (class 1259 OID 59831)
-- Name: users_account_info_pk; Type: INDEX; Schema: cliff; Owner: cliff_Admin
--

CREATE UNIQUE INDEX users_account_info_pk ON cliff.users_account_info USING btree (id);


--
-- TOC entry 2800 (class 1259 OID 59832)
-- Name: users_account_login; Type: INDEX; Schema: cliff; Owner: cliff_Admin
--

CREATE UNIQUE INDEX users_account_login ON cliff.users_account_info USING btree (login);


--
-- TOC entry 2801 (class 1259 OID 59833)
-- Name: users_account_pseudo; Type: INDEX; Schema: cliff; Owner: cliff_Admin
--

CREATE UNIQUE INDEX users_account_pseudo ON cliff.users_account_info USING btree (pseudonyme);


--
-- TOC entry 2802 (class 1259 OID 59834)
-- Name: users_info_member_fk; Type: INDEX; Schema: cliff; Owner: cliff_Admin
--

CREATE UNIQUE INDEX users_info_member_fk ON cliff.users_info USING btree (account_info_fk);


--
-- TOC entry 2808 (class 2606 OID 59835)
-- Name: climbing_site_comments climbing_site_climbing_site_comments_fk; Type: FK CONSTRAINT; Schema: cliff; Owner: cliff_Admin
--

ALTER TABLE ONLY cliff.climbing_site_comments
    ADD CONSTRAINT climbing_site_climbing_site_comments_fk FOREIGN KEY (climbing_site_fk) REFERENCES cliff.climbing_site(id);


--
-- TOC entry 2807 (class 2606 OID 59840)
-- Name: climbing_site_comment_modification_log climbing_site_comments_climbing_site_comment_modification_lo40; Type: FK CONSTRAINT; Schema: cliff; Owner: cliff_Admin
--

ALTER TABLE ONLY cliff.climbing_site_comment_modification_log
    ADD CONSTRAINT climbing_site_comments_climbing_site_comment_modification_lo40 FOREIGN KEY (climbing_site_comment_fk) REFERENCES cliff.climbing_site_comments(id);


--
-- TOC entry 2814 (class 2606 OID 59845)
-- Name: site_routes climbing_site_site_routes_fk; Type: FK CONSTRAINT; Schema: cliff; Owner: cliff_Admin
--

ALTER TABLE ONLY cliff.site_routes
    ADD CONSTRAINT climbing_site_site_routes_fk FOREIGN KEY (climbing_site_fk) REFERENCES cliff.climbing_site(id);


--
-- TOC entry 2815 (class 2606 OID 59850)
-- Name: topo_lending climbing_topo_topo_lending_fk; Type: FK CONSTRAINT; Schema: cliff; Owner: cliff_Admin
--

ALTER TABLE ONLY cliff.topo_lending
    ADD CONSTRAINT climbing_topo_topo_lending_fk FOREIGN KEY (climbing_topo_fk) REFERENCES cliff.climbing_topo(id);


--
-- TOC entry 2818 (class 2606 OID 59855)
-- Name: users_info french_climbing_level_members_info_info_fk; Type: FK CONSTRAINT; Schema: cliff; Owner: cliff_Admin
--

ALTER TABLE ONLY cliff.users_info
    ADD CONSTRAINT french_climbing_level_members_info_info_fk FOREIGN KEY (french_climbing_level_fk) REFERENCES cliff.french_climbing_level(id);


--
-- TOC entry 2812 (class 2606 OID 59860)
-- Name: route_pitch french_climbing_level_route_pitch_fk; Type: FK CONSTRAINT; Schema: cliff; Owner: cliff_Admin
--

ALTER TABLE ONLY cliff.route_pitch
    ADD CONSTRAINT french_climbing_level_route_pitch_fk FOREIGN KEY (french_climbing_level_fk) REFERENCES cliff.french_climbing_level(id);


--
-- TOC entry 2805 (class 2606 OID 59865)
-- Name: climbing_site french_counties_climbing_site_fk; Type: FK CONSTRAINT; Schema: cliff; Owner: cliff_Admin
--

ALTER TABLE ONLY cliff.climbing_site
    ADD CONSTRAINT french_counties_climbing_site_fk FOREIGN KEY (french_county_fk) REFERENCES cliff.french_counties(id);


--
-- TOC entry 2819 (class 2606 OID 59870)
-- Name: users_info french_counties_members_info_info_fk; Type: FK CONSTRAINT; Schema: cliff; Owner: cliff_Admin
--

ALTER TABLE ONLY cliff.users_info
    ADD CONSTRAINT french_counties_members_info_info_fk FOREIGN KEY (french_county_fk) REFERENCES cliff.french_counties(id);


--
-- TOC entry 2806 (class 2606 OID 59875)
-- Name: climbing_site french_states_climbing_site_fk; Type: FK CONSTRAINT; Schema: cliff; Owner: cliff_Admin
--

ALTER TABLE ONLY cliff.climbing_site
    ADD CONSTRAINT french_states_climbing_site_fk FOREIGN KEY (french_state_fk) REFERENCES cliff.french_states(id);


--
-- TOC entry 2809 (class 2606 OID 59880)
-- Name: climbing_topo french_states_climbing_topo_fk; Type: FK CONSTRAINT; Schema: cliff; Owner: cliff_Admin
--

ALTER TABLE ONLY cliff.climbing_topo
    ADD CONSTRAINT french_states_climbing_topo_fk FOREIGN KEY (french_state_fk) REFERENCES cliff.french_states(id);


--
-- TOC entry 2811 (class 2606 OID 59885)
-- Name: french_counties french_states_french_counties_fk; Type: FK CONSTRAINT; Schema: cliff; Owner: cliff_Admin
--

ALTER TABLE ONLY cliff.french_counties
    ADD CONSTRAINT french_states_french_counties_fk FOREIGN KEY (french_state_fk) REFERENCES cliff.french_states(id) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- TOC entry 2820 (class 2606 OID 59890)
-- Name: users_info french_states_members_info_info_fk; Type: FK CONSTRAINT; Schema: cliff; Owner: cliff_Admin
--

ALTER TABLE ONLY cliff.users_info
    ADD CONSTRAINT french_states_members_info_info_fk FOREIGN KEY (french_state_fk) REFERENCES cliff.french_states(id);


--
-- TOC entry 2813 (class 2606 OID 59895)
-- Name: route_pitch site_routes_route_pitch_fk; Type: FK CONSTRAINT; Schema: cliff; Owner: cliff_Admin
--

ALTER TABLE ONLY cliff.route_pitch
    ADD CONSTRAINT site_routes_route_pitch_fk FOREIGN KEY (site_route_fk) REFERENCES cliff.site_routes(id);


--
-- TOC entry 2821 (class 2606 OID 59900)
-- Name: users_info users_account_info_users_info_info_fk; Type: FK CONSTRAINT; Schema: cliff; Owner: cliff_Admin
--

ALTER TABLE ONLY cliff.users_info
    ADD CONSTRAINT users_account_info_users_info_info_fk FOREIGN KEY (account_info_fk) REFERENCES cliff.users_account_info(id) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- TOC entry 2810 (class 2606 OID 59905)
-- Name: climbing_topo users_info_climbing_topo_fk; Type: FK CONSTRAINT; Schema: cliff; Owner: cliff_Admin
--

ALTER TABLE ONLY cliff.climbing_topo
    ADD CONSTRAINT users_info_climbing_topo_fk FOREIGN KEY (users_info_fk) REFERENCES cliff.users_info(id);


--
-- TOC entry 2816 (class 2606 OID 59910)
-- Name: topo_lending users_info_topo_lending_borrower_fk; Type: FK CONSTRAINT; Schema: cliff; Owner: cliff_Admin
--

ALTER TABLE ONLY cliff.topo_lending
    ADD CONSTRAINT users_info_topo_lending_borrower_fk FOREIGN KEY (borrower_user_info_fk) REFERENCES cliff.users_info(id);


--
-- TOC entry 2817 (class 2606 OID 59915)
-- Name: topo_lending users_info_topo_lending_lender_fk; Type: FK CONSTRAINT; Schema: cliff; Owner: cliff_Admin
--

ALTER TABLE ONLY cliff.topo_lending
    ADD CONSTRAINT users_info_topo_lending_lender_fk FOREIGN KEY (lender_user_info_fk) REFERENCES cliff.users_info(id);


--
-- TOC entry 2972 (class 0 OID 0)
-- Dependencies: 7
-- Name: SCHEMA cliff; Type: ACL; Schema: -; Owner: cliff_Admin
--

GRANT USAGE ON SCHEMA cliff TO "cliff_Users";


--
-- TOC entry 2974 (class 0 OID 0)
-- Dependencies: 196
-- Name: TABLE climbing_site; Type: ACL; Schema: cliff; Owner: cliff_Admin
--

GRANT ALL ON TABLE cliff.climbing_site TO "cliff_Users";


--
-- TOC entry 2976 (class 0 OID 0)
-- Dependencies: 197
-- Name: TABLE climbing_site_comment_modification_log; Type: ACL; Schema: cliff; Owner: cliff_Admin
--

GRANT ALL ON TABLE cliff.climbing_site_comment_modification_log TO "cliff_Users";


--
-- TOC entry 2978 (class 0 OID 0)
-- Dependencies: 198
-- Name: SEQUENCE climbing_site_comment_modification_log_id_seq; Type: ACL; Schema: cliff; Owner: cliff_Admin
--

GRANT ALL ON SEQUENCE cliff.climbing_site_comment_modification_log_id_seq TO "cliff_Users";


--
-- TOC entry 2979 (class 0 OID 0)
-- Dependencies: 199
-- Name: TABLE climbing_site_comments; Type: ACL; Schema: cliff; Owner: cliff_Admin
--

GRANT ALL ON TABLE cliff.climbing_site_comments TO "cliff_Users";


--
-- TOC entry 2981 (class 0 OID 0)
-- Dependencies: 200
-- Name: SEQUENCE climbing_site_comments_id_seq; Type: ACL; Schema: cliff; Owner: cliff_Admin
--

GRANT ALL ON SEQUENCE cliff.climbing_site_comments_id_seq TO lade_user;
GRANT ALL ON SEQUENCE cliff.climbing_site_comments_id_seq TO "cliff_Users";


--
-- TOC entry 2983 (class 0 OID 0)
-- Dependencies: 201
-- Name: SEQUENCE climbing_site_id_seq; Type: ACL; Schema: cliff; Owner: cliff_Admin
--

GRANT ALL ON SEQUENCE cliff.climbing_site_id_seq TO lade_user;
GRANT ALL ON SEQUENCE cliff.climbing_site_id_seq TO "cliff_Users";


--
-- TOC entry 2987 (class 0 OID 0)
-- Dependencies: 202
-- Name: TABLE climbing_topo; Type: ACL; Schema: cliff; Owner: cliff_Admin
--

GRANT ALL ON TABLE cliff.climbing_topo TO "cliff_Users";


--
-- TOC entry 2989 (class 0 OID 0)
-- Dependencies: 203
-- Name: SEQUENCE climbing_topo_id_seq; Type: ACL; Schema: cliff; Owner: cliff_Admin
--

GRANT ALL ON SEQUENCE cliff.climbing_topo_id_seq TO "cliff_Users";
GRANT ALL ON SEQUENCE cliff.climbing_topo_id_seq TO lade_user;


--
-- TOC entry 2991 (class 0 OID 0)
-- Dependencies: 204
-- Name: TABLE french_climbing_level; Type: ACL; Schema: cliff; Owner: cliff_Admin
--

GRANT ALL ON TABLE cliff.french_climbing_level TO "cliff_Users";


--
-- TOC entry 2993 (class 0 OID 0)
-- Dependencies: 205
-- Name: SEQUENCE french_climbing_level_id_seq; Type: ACL; Schema: cliff; Owner: cliff_Admin
--

GRANT ALL ON SEQUENCE cliff.french_climbing_level_id_seq TO "cliff_Users";
GRANT ALL ON SEQUENCE cliff.french_climbing_level_id_seq TO lade_user;


--
-- TOC entry 2995 (class 0 OID 0)
-- Dependencies: 206
-- Name: TABLE french_counties; Type: ACL; Schema: cliff; Owner: cliff_Admin
--

GRANT ALL ON TABLE cliff.french_counties TO "cliff_Users";


--
-- TOC entry 2997 (class 0 OID 0)
-- Dependencies: 207
-- Name: SEQUENCE french_counties_id_seq; Type: ACL; Schema: cliff; Owner: cliff_Admin
--

GRANT ALL ON SEQUENCE cliff.french_counties_id_seq TO lade_user;
GRANT ALL ON SEQUENCE cliff.french_counties_id_seq TO "cliff_Users";


--
-- TOC entry 2999 (class 0 OID 0)
-- Dependencies: 208
-- Name: TABLE french_states; Type: ACL; Schema: cliff; Owner: cliff_Admin
--

GRANT ALL ON TABLE cliff.french_states TO "cliff_Users";


--
-- TOC entry 3001 (class 0 OID 0)
-- Dependencies: 209
-- Name: SEQUENCE french_states_id_seq; Type: ACL; Schema: cliff; Owner: cliff_Admin
--

GRANT ALL ON SEQUENCE cliff.french_states_id_seq TO lade_user;
GRANT ALL ON SEQUENCE cliff.french_states_id_seq TO "cliff_Users";


--
-- TOC entry 3002 (class 0 OID 0)
-- Dependencies: 210
-- Name: TABLE route_pitch; Type: ACL; Schema: cliff; Owner: cliff_Admin
--

GRANT ALL ON TABLE cliff.route_pitch TO "cliff_Users";


--
-- TOC entry 3004 (class 0 OID 0)
-- Dependencies: 211
-- Name: SEQUENCE route_pitch_id_seq; Type: ACL; Schema: cliff; Owner: cliff_Admin
--

GRANT ALL ON SEQUENCE cliff.route_pitch_id_seq TO lade_user;
GRANT ALL ON SEQUENCE cliff.route_pitch_id_seq TO "cliff_Users";


--
-- TOC entry 3005 (class 0 OID 0)
-- Dependencies: 212
-- Name: TABLE site_routes; Type: ACL; Schema: cliff; Owner: cliff_Admin
--

GRANT ALL ON TABLE cliff.site_routes TO "cliff_Users";


--
-- TOC entry 3007 (class 0 OID 0)
-- Dependencies: 213
-- Name: SEQUENCE site_routes_id_seq; Type: ACL; Schema: cliff; Owner: cliff_Admin
--

GRANT ALL ON SEQUENCE cliff.site_routes_id_seq TO lade_user;
GRANT ALL ON SEQUENCE cliff.site_routes_id_seq TO "cliff_Users";


--
-- TOC entry 3008 (class 0 OID 0)
-- Dependencies: 214
-- Name: TABLE topo_lending; Type: ACL; Schema: cliff; Owner: cliff_Admin
--

GRANT ALL ON TABLE cliff.topo_lending TO "cliff_Users";


--
-- TOC entry 3010 (class 0 OID 0)
-- Dependencies: 215
-- Name: SEQUENCE topo_lending_id_seq; Type: ACL; Schema: cliff; Owner: cliff_Admin
--

GRANT ALL ON SEQUENCE cliff.topo_lending_id_seq TO "cliff_Users";


--
-- TOC entry 3016 (class 0 OID 0)
-- Dependencies: 216
-- Name: TABLE users_account_info; Type: ACL; Schema: cliff; Owner: cliff_Admin
--

GRANT ALL ON TABLE cliff.users_account_info TO "cliff_Users";


--
-- TOC entry 3018 (class 0 OID 0)
-- Dependencies: 217
-- Name: SEQUENCE users_account_info_id_seq; Type: ACL; Schema: cliff; Owner: cliff_Admin
--

GRANT ALL ON SEQUENCE cliff.users_account_info_id_seq TO "cliff_Users";
GRANT ALL ON SEQUENCE cliff.users_account_info_id_seq TO lade_user;


--
-- TOC entry 3027 (class 0 OID 0)
-- Dependencies: 218
-- Name: TABLE users_info; Type: ACL; Schema: cliff; Owner: cliff_Admin
--

GRANT ALL ON TABLE cliff.users_info TO "cliff_Users";


--
-- TOC entry 3029 (class 0 OID 0)
-- Dependencies: 219
-- Name: SEQUENCE users_info_id_seq; Type: ACL; Schema: cliff; Owner: cliff_Admin
--

GRANT ALL ON SEQUENCE cliff.users_info_id_seq TO "cliff_Users";
GRANT ALL ON SEQUENCE cliff.users_info_id_seq TO lade_user;


-- Completed on 2020-12-17 12:31:04

--
-- PostgreSQL database dump complete
--

