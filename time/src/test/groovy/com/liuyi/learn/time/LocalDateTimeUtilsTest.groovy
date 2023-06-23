package com.liuyi.learn.time

import spock.lang.Specification
import spock.lang.Unroll

import java.time.LocalDateTime
import java.time.Month
import java.time.ZoneId
import java.time.ZoneOffset
import java.time.format.DateTimeFormatter

@Unroll
class LocalDateTimeUtilsTest extends Specification {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")

    def "test getMonth"() {
        given:
        LocalDateTime sourceDateTime = LocalDateTime.parse(source, formatter)

        expect:
        result == LocalDateTimeUtils.getMonth(sourceDateTime)

        where:
        source                || result
        "2023-06-19 15:40:00" || Month.JUNE
        "2023-01-19 15:40:00" || Month.JANUARY
    }

    def "test getDay"() {
        given:
        LocalDateTime sourceDateTime = LocalDateTime.parse(source, formatter)

        expect:
        result == LocalDateTimeUtils.getDay(sourceDateTime)

        where:
        source                || result
        "2023-06-19 15:40:00" || 19
        "2023-06-01 15:40:00" || 1
    }

    def "test convertToUtc"() {
        given:
        LocalDateTime sourceDateTime = LocalDateTime.parse(source, formatter)

        ZoneId sourceZone = ZoneId.of(sourceZoneId)
        ZoneId targetZone = ZoneId.of(targetZoneId)

        expect:
        def targetDateTime = LocalDateTimeUtils.convertToUtc(sourceDateTime, sourceZone, targetZone)
        result == targetDateTime.format(formatter)

        where:
        source                | sourceZoneId    | targetZoneId    || result
        "2023-06-19 15:40:00" | "Asia/Shanghai" | "Asia/Shanghai" || "2023-06-19 15:40:00"
        "2023-06-19 15:40:00" | "Asia/Shanghai" | "UTC"           || "2023-06-19 07:40:00"
    }

    def "test from milliseconds"() {
        expect:
        def time = LocalDateTimeUtils.from(millis, ZoneOffset.ofHours(zoneHour))
        result == formatter.format(time)

        where:
        millis        | zoneHour || result
        1687272523000 | 8        || "2023-06-20 22:48:43"
        1687272523000 | 0        || "2023-06-20 14:48:43"
    }
}
