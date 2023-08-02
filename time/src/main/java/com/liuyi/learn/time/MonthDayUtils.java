package com.liuyi.learn.time;

import java.time.MonthDay;
import java.time.format.DateTimeFormatter;

/**
 * MonthDayUtils
 *
 * @author Eason Liu
 * Create at: 2023/7/14
 */
public class MonthDayUtils {

    public static void main(String[] args) {
        MonthDay monthDay = MonthDay.parse("04-14", DateTimeFormatter.ofPattern("MM-dd"));
        System.out.println(monthDay);

        String result = monthDay.format(DateTimeFormatter.ofPattern("MM-dd"));
        System.out.println(result);
    }
}
