create table geoname (
         geonameid       int,
         name            varchar(200),
         asciiname        varchar(200),
         alternatenames  varchar(10000),
         latitude        float,
         longitude       float,
         fclass  char(1),
         fcode   varchar(10),
         country varchar(2),
         cc2 varchar(60),
         admin1  varchar(20),
         admin2  varchar(80),
         admin3  varchar(20),
         admin4  varchar(20),
         population      bigint,
         elevation       int,
         gtopo30         int,
         timezone varchar(40),
         moddate         date
 );

alter table geoname add column id serial not null;
CREATE UNIQUE INDEX idx_geoname_id ON geoname (id);

CREATE INDEX idx_geoname_population ON geoname (population);
CREATE INDEX idx_geoname_fcode ON geoname(fcode);

alter table geoname add column the_geom geometry;

update geoname set the_geom = st_makepoint(longitude,latitude);

alter table geoname add constraint enforce_geotype_the_geom
CHECK (geometrytype(the_geom) = 'POINT'::text OR the_geom IS NULL);

CREATE INDEX idx_geoname_the_geom ON geoname USING gist(the_geom);


