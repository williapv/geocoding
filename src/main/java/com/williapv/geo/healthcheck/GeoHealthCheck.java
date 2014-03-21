package com.williapv.geo.healthcheck;

import com.yammer.metrics.core.HealthCheck;

/**
 * Created by paul on 3/20/14.
 */
public class GeoHealthCheck extends HealthCheck {
    private final String template;

    public GeoHealthCheck(String template) {
        super("template");
        this.template = template;
    }

    @Override
    protected Result check() throws Exception {
        final String saying = String.format(template, "TEST");
        if (!saying.contains("TEST")) {
            return Result.unhealthy("template doesn't include a name");
        }
        return Result.healthy();
    }

}
