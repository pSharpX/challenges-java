package com.challenger.common.stringutils;

import java.util.Arrays;
import java.util.stream.Collectors;

public class StringUtils {

    public static String toAlternativeString2(String string) {
        return Arrays.stream(string.split(""))
                .map(str -> {
                    char current = str.charAt(0);
                    if (!Character.isAlphabetic(current)) {
                        return str;
                    }

                    if (Character.isLowerCase(current)){
                        return Character.toUpperCase(current) + "";
                    }
                    return Character.toLowerCase(current) + "";
                }).collect(Collectors.joining());
    }

    public static String toAlternativeString(String string) {
        return string.chars().boxed()
                .map(val -> {
                    if (!Character.isAlphabetic(val)){
                        return val;
                    }
                    if (Character.isLowerCase(val)){
                        return Character.toUpperCase(val);
                    }
                    return Character.toLowerCase(val);
                }).map(val -> String.valueOf((char) val.intValue()))
                .collect(Collectors.joining());
    }

}
