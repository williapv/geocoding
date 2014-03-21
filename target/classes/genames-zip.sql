CREATE TABLE geoname_zip
(
  id SERIAL,
  country VARCHAR(2),
  postal_code VARCHAR(20),
  place_name VARCHAR(180),
  state_name  VARCHAR(100),
  state_abbr VARCHAR(20),
  county_province VARCHAR(100),
  county_province_abbr VARCHAR(20),
  community_name VARCHAR(100),
  community_abbr VARCHAR(20),
  latitude FLOAT,
  longitude FLOAT,
  accuracy INT
);
