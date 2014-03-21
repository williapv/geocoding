package com.williapv.geo.resource;

import com.google.common.base.Optional;
import com.williapv.geo.dao.GeoDAO;
import com.williapv.geo.representation.GeonameZip;
import com.williapv.geo.representation.State;
import com.yammer.metrics.annotation.Timed;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by paul on 3/20/14.
 */
@Path("/geocode")
@Produces(MediaType.APPLICATION_JSON)
public class GeocodeResource {

    private final GeoDAO dao;

    public GeocodeResource(GeoDAO dao) {
        this.dao = dao;
    }

    @GET
    @Timed
    public List<GeonameZip> getGeo(@QueryParam("name") Optional<String> name, @QueryParam("country") Optional<String> country) {
        if (country.isPresent() && name.isPresent()) {
            return dao.findByNameCountry(name.get(), country.get());
        } else if (name.isPresent()) {

            return dao.findNameByName(name.get());
        } else if (country.isPresent()) {
            return dao.findByCountry(country.get());
        }
        return null;
    }

    @GET
    @Timed
    @Path("{country}")
    public List<State> getStates(@PathParam("country") String country) {

        return dao.findStates(country);

    }

    @GET
    @Timed
    @Path("{country}/{state}/cities")
    public List<String> getStates(@PathParam("country") String country,@PathParam("state") String state) {

        return dao.findCities(country,state);

    }

    @GET
    @Timed
    @Path("{country}/{state}/zips")
    public List<String> getZips(@PathParam("country") String country,@PathParam("state") String state) {

        return dao.findPostalCodes(country,state);

    }


}
