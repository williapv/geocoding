CREATE TABLE geoname
(
    geonameid INT,
    name VARCHAR(200),
    asciiname VARCHAR(200),
    alternatenames VARCHAR,
    latitude DOUBLE PRECISION,
    longitude DOUBLE PRECISION,
    fclass CHAR(1),
    fcode VARCHAR(10),
    country VARCHAR(2),
    cc2 VARCHAR(60),
    admin1 VARCHAR(20),
    admin2 VARCHAR(80),
    admin3 VARCHAR(20),
    admin4 VARCHAR(20),
    population BIGINT,
    elevation INT,
    gtopo30 INT,
    timezone VARCHAR(40),
    moddate DATE,
    id INT DEFAULT nextval('geoname_id_seq'::regclass) NOT NULL,
    the_geom geometry
);
CREATE INDEX idx_geoname_the_geom ON geoname ( the_geom );


