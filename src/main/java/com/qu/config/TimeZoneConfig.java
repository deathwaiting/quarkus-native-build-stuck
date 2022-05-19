package com.qu.config;

import io.quarkus.runtime.StartupEvent;
import javax.enterprise.event.Observes;
import javax.inject.Singleton;
import java.util.TimeZone;

@Singleton
public class TimeZoneConfig {
    public void setTimezone(@Observes StartupEvent startupEvent) {
        System.setProperty("user.timezone", "UTC");
        TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
    }
}
