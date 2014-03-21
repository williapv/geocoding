package com.williapv.geo.dao;

import com.williapv.geo.representation.GeonameZip;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by paul on 3/21/14.
 */
public class GeonameZipMapper  implements ResultSetMapper<GeonameZip> {

    public GeonameZip map(int index, ResultSet r, StatementContext ctx) throws SQLException {
        GeonameZip zip = new GeonameZip();
        zip.setId(r.getLong("id"));
        zip.setLatitude(r.getFloat("latitude"));
        zip.setLongitude(r.getFloat("longitude"));
        zip.setAccuracy(r.getInt("accuracy"));
        zip.setCountry(r.getString("country"));
        zip.setCommunityAbbr(r.getString("community_abbr"));
        zip.setCommunityName(r.getString("community_name"));
        zip.setCountyProvince(r.getString("county_province"));
        zip.setCountyProvinceAbbr(r.getString("county_province_abbr"));
        zip.setPlaceName(r.getString("place_name"));
        zip.setPostalCode(r.getString("postal_code"));
        zip.setStateAbbr(r.getString("state_abbr"));
        zip.setStateName(r.getString("state_name"));

        return zip;

    }
}
