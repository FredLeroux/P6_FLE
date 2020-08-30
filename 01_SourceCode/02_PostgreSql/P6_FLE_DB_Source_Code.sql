
CREATE SEQUENCE cliff.users_account_info_id_seq;

CREATE TABLE cliff.users_account_info (
                id INTEGER NOT NULL DEFAULT nextval('cliff.users_account_info_id_seq'),
                login VARCHAR(254) NOT NULL,
                password VARCHAR(60) NOT NULL,
                pseudonyme VARCHAR(30) NOT NULL,
                sign_up_date DATE NOT NULL,
                login_tentative_number INTEGER NOT NULL,
                security_level INTEGER NOT NULL,
                account_activation_status BOOLEAN DEFAULT false NOT NULL,
                is_member BOOLEAN DEFAULT false NOT NULL,
                activation_code CHAR(24),
                password_reset_code VARCHAR(36),
                CONSTRAINT users_account_info_pk PRIMARY KEY (id)
);
COMMENT ON COLUMN cliff.users_account_info.login IS '254 as can be e-mail address';
COMMENT ON COLUMN cliff.users_account_info.password IS '60 as encoded via bcrypt';
COMMENT ON COLUMN cliff.users_account_info.security_level IS 'define the rights of the account';
COMMENT ON COLUMN cliff.users_account_info.account_activation_status IS 'An account is activated (true) or not (false)';
COMMENT ON COLUMN cliff.users_account_info.is_member IS 'Determinate if an User is an association member or not';
COMMENT ON COLUMN cliff.users_account_info.password_reset_code IS 'the code sent to user in order to reset password';


ALTER SEQUENCE cliff.users_account_info_id_seq OWNED BY cliff.users_account_info.id;

CREATE UNIQUE INDEX users_account_login
 ON cliff.users_account_info
 ( login );

CREATE UNIQUE INDEX users_account_pseudo
 ON cliff.users_account_info
 ( pseudonyme );

CREATE SEQUENCE cliff.french_climbing_level_id_seq;

CREATE TABLE cliff.french_climbing_level (
                id INTEGER NOT NULL DEFAULT nextval('cliff.french_climbing_level_id_seq'),
                cotation_level VARCHAR(3) NOT NULL,
                CONSTRAINT french_climbing_level_id_pk PRIMARY KEY (id)
);
COMMENT ON TABLE cliff.french_climbing_level IS 'Contaisn the different climbing levels in france according to french cotation 
see https://fr.wikipedia.org/wiki/Cotation_en_escalade';


ALTER SEQUENCE cliff.french_climbing_level_id_seq OWNED BY cliff.french_climbing_level.id;

CREATE UNIQUE INDEX french_climbing_level_cotation_level_unique
 ON cliff.french_climbing_level
 ( cotation_level ASC );

CREATE SEQUENCE cliff.french_states_id_seq;

CREATE TABLE cliff.french_states (
                id INTEGER NOT NULL DEFAULT nextval('cliff.french_states_id_seq'),
                state_number NUMERIC(2) NOT NULL,
                state_name VARCHAR(30) NOT NULL,
                CONSTRAINT french_states_id PRIMARY KEY (id)
);
COMMENT ON TABLE cliff.french_states IS 'Contains all french states 
last update : 2018 
from https://www.insee.fr/';


ALTER SEQUENCE cliff.french_states_id_seq OWNED BY cliff.french_states.id;

CREATE UNIQUE INDEX french_states_number
 ON cliff.french_states
 ( state_number ASC );

CREATE UNIQUE INDEX french_states_name
 ON cliff.french_states
 ( state_name );

CREATE SEQUENCE cliff.french_counties_id_seq;

CREATE TABLE cliff.french_counties (
                id INTEGER NOT NULL DEFAULT nextval('cliff.french_counties_id_seq'),
                county_number VARCHAR(3) NOT NULL,
                county_name VARCHAR(30) NOT NULL,
                french_state_fk INTEGER NOT NULL,
                CONSTRAINT french_counties_id PRIMARY KEY (id)
);
COMMENT ON TABLE cliff.french_counties IS 'Contains all french counties 
update see french state
from : see french state';


ALTER SEQUENCE cliff.french_counties_id_seq OWNED BY cliff.french_counties.id;

CREATE UNIQUE INDEX french_counties_number
 ON cliff.french_counties
 ( county_number );

CREATE UNIQUE INDEX french_counties_name
 ON cliff.french_counties
 ( county_name );

CREATE SEQUENCE cliff.climbing_site_id_seq;

CREATE TABLE cliff.climbing_site (
                id INTEGER NOT NULL DEFAULT nextval('cliff.climbing_site_id_seq'),
                climbing_site_name VARCHAR(100) NOT NULL,
                official BOOLEAN NOT NULL,
                site_description VARCHAR(200),
                altitude INTEGER,
                height_min INTEGER,
                height_max INTEGER,
                number_of_routes INTEGER NOT NULL,
                access_to_site VARCHAR(500),
                french_state_fk INTEGER NOT NULL,
                french_county_fk INTEGER NOT NULL,
                CONSTRAINT climbing_site_pk PRIMARY KEY (id)
);
COMMENT ON COLUMN cliff.climbing_site.official IS 'Define a site as les amis de l escalade official';


ALTER SEQUENCE cliff.climbing_site_id_seq OWNED BY cliff.climbing_site.id;

CREATE UNIQUE INDEX climbing_site_ak
 ON cliff.climbing_site
 ( climbing_site_name );

CREATE SEQUENCE cliff.site_routes_id_seq;

CREATE TABLE cliff.site_routes (
                id INTEGER NOT NULL DEFAULT nextval('cliff.site_routes_id_seq'),
                route_name VARCHAR(100),
                climbing_site_fk INTEGER NOT NULL,
                CONSTRAINT site_routes_pk PRIMARY KEY (id)
);


ALTER SEQUENCE cliff.site_routes_id_seq OWNED BY cliff.site_routes.id;

CREATE SEQUENCE cliff.route_pitch_id_seq;

CREATE TABLE cliff.route_pitch (
                id INTEGER NOT NULL DEFAULT nextval('cliff.route_pitch_id_seq'),
                pitch_number INTEGER NOT NULL,
                site_route_fk INTEGER NOT NULL,
                french_climbing_level_fk INTEGER NOT NULL,
                CONSTRAINT route_pitch_pk PRIMARY KEY (id)
);


ALTER SEQUENCE cliff.route_pitch_id_seq OWNED BY cliff.route_pitch.id;

CREATE SEQUENCE cliff.climbing_site_comments_id_seq;

CREATE TABLE cliff.climbing_site_comments (
                id INTEGER NOT NULL DEFAULT nextval('cliff.climbing_site_comments_id_seq'),
                comment VARCHAR NOT NULL,
                comment_author VARCHAR(16) NOT NULL,
                post_date TIMESTAMP NOT NULL,
                climbing_site_fk INTEGER NOT NULL,
                CONSTRAINT climbing_site_comments_pk PRIMARY KEY (id)
);


ALTER SEQUENCE cliff.climbing_site_comments_id_seq OWNED BY cliff.climbing_site_comments.id;

CREATE SEQUENCE cliff.climbing_site_comment_modification_log_id_seq;

CREATE TABLE cliff.climbing_site_comment_modification_log (
                id INTEGER NOT NULL DEFAULT nextval('cliff.climbing_site_comment_modification_log_id_seq'),
                modificatio_date TIMESTAMP NOT NULL,
                author VARCHAR NOT NULL,
                comment_before_modification VARCHAR NOT NULL,
                climbing_site_comment_fk INTEGER NOT NULL,
                CONSTRAINT climbing_site_comment_modification_log_pk PRIMARY KEY (id)
);
COMMENT ON COLUMN cliff.climbing_site_comment_modification_log.comment_before_modification IS 'It is the comment before the modification';


ALTER SEQUENCE cliff.climbing_site_comment_modification_log_id_seq OWNED BY cliff.climbing_site_comment_modification_log.id;

CREATE SEQUENCE cliff.users_info_id_seq;

CREATE TABLE cliff.users_info (
                id INTEGER NOT NULL DEFAULT nextval('cliff.users_info_id_seq'),
                first_name VARCHAR(30),
                last_name VARCHAR(30),
                email_address VARCHAR(254) NOT NULL,
                birth_date DATE,
                gender VARCHAR(30),
                account_info_fk INTEGER NOT NULL,
                french_state_fk INTEGER,
                french_county_fk INTEGER,
                french_climbing_level_fk INTEGER,
                CONSTRAINT users_info_pk PRIMARY KEY (id)
);
COMMENT ON TABLE cliff.users_info IS 'Contains association users information';
COMMENT ON COLUMN cliff.users_info.first_name IS 'Can be null if user do not wich share it';
COMMENT ON COLUMN cliff.users_info.last_name IS 'Can be null if user do not wich share it';
COMMENT ON COLUMN cliff.users_info.email_address IS '254 see https://mydnic.be/post/longueur-dun-varchar-pour-un-champ-email';
COMMENT ON COLUMN cliff.users_info.birth_date IS 'Can be null if user do not wich share it';
COMMENT ON COLUMN cliff.users_info.gender IS 'Can be null if user do not wich share it
Note may think about LGBT community';
COMMENT ON COLUMN cliff.users_info.french_state_fk IS 'Can be null if user do not wich share it';
COMMENT ON COLUMN cliff.users_info.french_county_fk IS 'Can be null if user do not wich share it';
COMMENT ON COLUMN cliff.users_info.french_climbing_level_fk IS 'Can be null if user do not wich share it';


ALTER SEQUENCE cliff.users_info_id_seq OWNED BY cliff.users_info.id;

CREATE UNIQUE INDEX users_info_member_fk
 ON cliff.users_info
 ( account_info_fk );

CREATE SEQUENCE cliff.climbing_topo_id_seq;

CREATE TABLE cliff.climbing_topo (
                id INTEGER NOT NULL DEFAULT nextval('cliff.climbing_topo_id_seq'),
                title VARCHAR(100) NOT NULL,
                edition_year VARCHAR(4) NOT NULL,
                availabe BOOLEAN NOT NULL,
                topo_description VARCHAR(200),
                french_state_fk INTEGER NOT NULL,
                users_info_fk INTEGER NOT NULL,
                CONSTRAINT climbing_topo_pk PRIMARY KEY (id)
);
COMMENT ON COLUMN cliff.climbing_topo.title IS 'The complete topo title 100 char for now will be enough for subtitle too';
COMMENT ON COLUMN cliff.climbing_topo.edition_year IS 'past constraint';
COMMENT ON COLUMN cliff.climbing_topo.users_info_fk IS 'Is the topo owner';


ALTER SEQUENCE cliff.climbing_topo_id_seq OWNED BY cliff.climbing_topo.id;

CREATE SEQUENCE cliff.topo_lending_id_seq;

CREATE TABLE cliff.topo_lending (
                id INTEGER NOT NULL DEFAULT nextval('cliff.topo_lending_id_seq'),
                climbing_topo_fk INTEGER NOT NULL,
                lender_user_info_fk INTEGER NOT NULL,
                borrower_user_info_fk INTEGER NOT NULL,
                lending_status VARCHAR NOT NULL,
                CONSTRAINT topo_lending_pk PRIMARY KEY (id)
);


ALTER SEQUENCE cliff.topo_lending_id_seq OWNED BY cliff.topo_lending.id;

ALTER TABLE cliff.users_info ADD CONSTRAINT users_account_info_users_info_info_fk
FOREIGN KEY (account_info_fk)
REFERENCES cliff.users_account_info (id)
ON DELETE CASCADE
ON UPDATE CASCADE
NOT DEFERRABLE;

ALTER TABLE cliff.users_info ADD CONSTRAINT french_climbing_level_members_info_info_fk
FOREIGN KEY (french_climbing_level_fk)
REFERENCES cliff.french_climbing_level (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE cliff.route_pitch ADD CONSTRAINT french_climbing_level_route_pitch_fk
FOREIGN KEY (french_climbing_level_fk)
REFERENCES cliff.french_climbing_level (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE cliff.french_counties ADD CONSTRAINT french_states_french_counties_fk
FOREIGN KEY (french_state_fk)
REFERENCES cliff.french_states (id)
ON DELETE CASCADE
ON UPDATE CASCADE
NOT DEFERRABLE;

ALTER TABLE cliff.users_info ADD CONSTRAINT french_states_members_info_info_fk
FOREIGN KEY (french_state_fk)
REFERENCES cliff.french_states (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE cliff.climbing_topo ADD CONSTRAINT french_states_climbing_topo_fk
FOREIGN KEY (french_state_fk)
REFERENCES cliff.french_states (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE cliff.climbing_site ADD CONSTRAINT french_states_climbing_site_fk
FOREIGN KEY (french_state_fk)
REFERENCES cliff.french_states (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE cliff.users_info ADD CONSTRAINT french_counties_members_info_info_fk
FOREIGN KEY (french_county_fk)
REFERENCES cliff.french_counties (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE cliff.climbing_site ADD CONSTRAINT french_counties_climbing_site_fk
FOREIGN KEY (french_county_fk)
REFERENCES cliff.french_counties (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE cliff.climbing_site_comments ADD CONSTRAINT climbing_site_climbing_site_comments_fk
FOREIGN KEY (climbing_site_fk)
REFERENCES cliff.climbing_site (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE cliff.site_routes ADD CONSTRAINT climbing_site_site_routes_fk
FOREIGN KEY (climbing_site_fk)
REFERENCES cliff.climbing_site (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE cliff.route_pitch ADD CONSTRAINT site_routes_route_pitch_fk
FOREIGN KEY (site_route_fk)
REFERENCES cliff.site_routes (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE cliff.route_pitch ADD CONSTRAINT site_routes_route_pitch_fk1
FOREIGN KEY (site_route_fk)
REFERENCES cliff.site_routes (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE cliff.climbing_site_comment_modification_log ADD CONSTRAINT climbing_site_comments_climbing_site_comment_modification_lo40
FOREIGN KEY (climbing_site_comment_fk)
REFERENCES cliff.climbing_site_comments (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE cliff.climbing_topo ADD CONSTRAINT users_info_climbing_topo_fk
FOREIGN KEY (users_info_fk)
REFERENCES cliff.users_info (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE cliff.topo_lending ADD CONSTRAINT users_info_topo_lending_lender_fk
FOREIGN KEY (lender_user_info_fk)
REFERENCES cliff.users_info (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE cliff.topo_lending ADD CONSTRAINT users_info_topo_lending_borrower_fk
FOREIGN KEY (borrower_user_info_fk)
REFERENCES cliff.users_info (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE cliff.topo_lending ADD CONSTRAINT climbing_topo_topo_lending_fk
FOREIGN KEY (climbing_topo_fk)
REFERENCES cliff.climbing_topo (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;
