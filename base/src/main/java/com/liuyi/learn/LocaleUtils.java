package com.liuyi.learn;

import java.util.Locale;

/**
 * LocaleUtils
 *
 * @author Eason Liu
 * Create at: 2023/8/8
 */
public class LocaleUtils {
    public static void main(String[] args) {
        System.out.println("Locale.CHINA.getDisplayLanguage() = " + Locale.CHINA.getDisplayLanguage());
        System.out.println("Locale.CHINA.getDisplayName() = " + Locale.CHINA.getDisplayName());
        System.out.println("Locale.CHINA.getLanguage() = " + Locale.CHINA.getLanguage());
        System.out.println("Locale.CHINA.getISO3Language() = " + Locale.CHINA.getISO3Language());
        System.out.println("Locale.CHINA.toLanguageTag() = " + Locale.CHINA.toLanguageTag());
        System.out.println("Locale.CHINA = " + Locale.CHINA);
        System.out.println("Locale.CHINA.getCountry() = " + Locale.CHINA.getCountry());
        System.out.println("Locale.CHINA.getISO3Language() = " + Locale.CHINA.getISO3Language());
        System.out.println("Locale.CHINA.getDisplayCountry() = " + Locale.CHINA.getDisplayCountry());
    }
}
