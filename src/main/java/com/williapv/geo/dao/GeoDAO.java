package com.williapv.geo.dao;

import com.williapv.geo.representation.GeonameZip;
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

    @SqlQuery("SELECT distinct state_name, state_abbr FROM geoname_zip WHERE country = :country AND state_name IS NOT NULL ORDER BY state_name")
    @RegisterMapper(StateMapper.class)
    List<GeonameZip> findStates(@Bind("country") String country);


}


