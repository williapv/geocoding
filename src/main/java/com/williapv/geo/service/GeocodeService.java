package com.williapv.geo.service;

import com.williapv.geo.config.GeoConfig;
import com.williapv.geo.dao.GeoDAO;
import com.williapv.geo.healthcheck.GeoHealthCheck;
import com.williapv.geo.resource.GeocodeResource;
import com.yammer.dropwizard.Service;
import com.yammer.dropwizard.config.Bootstrap;
import com.yammer.dropwizard.config.Environment;
import com.yammer.dropwizard.db.DatabaseConfiguration;
import com.yammer.dropwizard.jdbi.DBIFactory;
import com.yammer.dropwizard.migrations.MigrationsBundle;
import org.skife.jdbi.v2.DBI;

/**
 * Created by paul on 3/20/14.
 */
public class GeocodeService extends Service<GeoConfig> {

    public static void main(String[] args) throws Exception {
        new GeocodeService().run(args);
    }

    @Override
    public void initialize(Bootstrap<GeoConfig> bootstrap) {
        bootstrap.setName("hello-geo-world");
        bootstrap.addBundle(new MigrationsBundle<GeoConfig>() {
            @Override
            public DatabaseConfiguration getDatabaseConfiguration(GeoConfig configuration) {
                return configuration.getDatabaseConfiguration();
            }
        });
    }

    @Override
    public void run(GeoConfig configuration,
                    Environment environment) throws ClassNotFoundException {
        final String template = configuration.getTemplate();
        final String defaultName = configuration.getDefaultName();


        final DBIFactory factory = new DBIFactory();
        final DBI jdbi = factory.build(environment, configuration.getDatabaseConfiguration(), "postgresql");
        final GeoDAO dao = jdbi.onDemand(GeoDAO.class);

        environment.addResource(new GeocodeResource(dao));
        environment.addHealthCheck(new GeoHealthCheck(template));
    }

}
