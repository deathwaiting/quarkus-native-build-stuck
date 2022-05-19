package com.qu.utils;

import org.jboss.logging.Logger;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.*;

import static java.time.ZoneOffset.UTC;
import static java.util.Objects.nonNull;
import static java.util.Optional.ofNullable;

public class Utils {
    private static final Logger logger = Logger.getLogger(Utils.class);

    static  public boolean anyIsNull(Object... objects){
        return ofNullable(objects)
                .map(Arrays::asList)
                .orElseGet(Collections::emptyList)
                .stream()
                .anyMatch(Objects::isNull);
    }



    static  public boolean allIsNull(Object... objects){
        return ofNullable(objects)
                .map(Arrays::asList)
                .orElseGet(Collections::emptyList)
                .stream()
                .allMatch(Objects::isNull);
    }


    static public boolean anyNonNull(Object ... objects){
        return ofNullable(objects)
                .map(Arrays::asList)
                .orElseGet(Collections::emptyList)
                .stream()
                .anyMatch(Objects::nonNull);
    }


    public static Optional<Long> parseLongSafely(String s) {
        try{
            return ofNullable(s)
                    .map(Long::parseLong);
        }catch(Throwable e){
            logger.error(e,e);
            return Optional.empty();
        }
    }


    public static LocalDateTime nowAtUtc() {
        return ZonedDateTime.now().withZoneSameInstant(UTC).toLocalDateTime();
    }


    public static ZonedDateTime atUtc(LocalDateTime time) {
        return time.atZone(TimeZone.getDefault().toZoneId())
                .withZoneSameInstant(UTC);
    }
}
