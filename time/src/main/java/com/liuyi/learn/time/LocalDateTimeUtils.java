package com.liuyi.learn.time;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.Date;

/**
 * LocalDateTimeUtils
 *
 * @author Eason Liu
 * Create at: 2023/6/19
 */
public class LocalDateTimeUtils {
    public static LocalDateTime now() {
        return LocalDateTime.now();
    }

    public static Month getMonth(LocalDateTime localDateTime) {
        return localDateTime.getMonth();
    }

    public static int getDay(LocalDateTime localDateTime){
        return localDateTime.getDayOfMonth();
    }

    public static Date toDate(LocalDateTime localDateTime, ZoneId zoneId) {
        return Date.from(localDateTime.atZone(zoneId).toInstant());
    }

    public static LocalDateTime fromCalendar(Calendar calendar) {
        // 将 Calendar 对象转换为 Date 对象
        Date date = calendar.getTime();
        // 将 Date 对象转换为 LocalDateTime 对象
        return LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
    }

    public static LocalDateTime from(long milliseconds, ZoneId zoneId) {
        return Instant.ofEpochMilli(milliseconds).atZone(zoneId).toLocalDateTime();
    }

    public static LocalDateTime from(long milliseconds) {
        return Instant.ofEpochMilli(milliseconds).atZone(ZoneId.systemDefault()).toLocalDateTime();
    }

    public static LocalDateTime convertToUtc(LocalDateTime sourceDateTime, ZoneId sourceZone, ZoneId targetZone) {
        // 将北京时间转换为北京时区的 ZonedDateTime 对象
        ZonedDateTime zonedDateTime = sourceDateTime.atZone(sourceZone);
        // 将北京时区的 ZonedDateTime 对象转换为 UTC 时区的 LocalDateTime 对象
        return zonedDateTime.withZoneSameInstant(targetZone).toLocalDateTime();
    }
}
