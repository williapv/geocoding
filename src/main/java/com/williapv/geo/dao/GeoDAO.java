package com.williapv.geo.dao;

import com.williapv.geo.representation.GeonameZip;
import com.williapv.geo.representation.State;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

import java.util.List;

/**
 * Created by paul on 3/20/14.
 */
@RegisterMapper(GeonameZipMapper.class)
public interface GeoDAO {

    @SqlQuery("SELECT * FROM geoname_zip WHERE place_name = :name")
    List<GeonameZip> findNameByName(@Bind("name") String name);

    @SqlQuery("SELECT * FROM geoname_zip WHERE place_name = :name AND country = :country")
    List<GeonameZip> findByNameCountry(@Bind("name") String name, @Bind("country") String country);

    @SqlQuery("SELECT * FROM geoname_zip WHERE country = :country")
    List<GeonameZip> findByCountry(@Bind("country") String country);

    @SqlQuery("SELECT distinct geoname_zip.state_name, geoname_zip.state_abbr FROM geoname_zip WHERE geoname_zip.country = :country AND geoname_zip.state_name IS NOT NULL ORDER BY geoname_zip.state_name")
    @RegisterMapper(StateMapper.class)
    List<State> findStates(@Bind("country") String country);

    @SqlQuery("SELECT place_name FROM geoname_zip WHERE country = :country AND state_abbr = :state ORDER BY place_name")
    List<String> findCities(@Bind("country") String country,@Bind("state") String state);

    @SqlQuery("SELECT postal_code FROM geoname_zip WHERE country = :country AND state_abbr = :state ORDER BY postal_code")
    List<String> findPostalCodes(@Bind("country") String country,@Bind("state") String state);


}


