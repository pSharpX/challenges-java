package com.challenger.common.sortdesc;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

public class SortDescChallenge {

    public static void main(String[] args) {

    }

    public static int sortDesc(final int num) {
        if (num <= 11) {
            return num;
        }
        return sortDescBubbleSort(num);
    }

    private static int sortDescDefault(final int num) {
        String digits = Arrays.stream((num + "").split(""))
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.joining());
        return Integer.parseInt(digits);
    }

    private static int sortDescBubbleSort(final int num) {
        String[] digits = (num + "").split("");
        for (int i = 0; i < digits.length; i++) {
            for (int j = 0; j < digits.length - 1; j++) {
                if (Integer.parseInt(digits[j]) < Integer.parseInt(digits[j+1])) {
                    String temp = digits[j];
                    digits[j] = digits[j+1];
                    digits[j+1] = temp;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (String digit : digits) {
            sb.append(digit);
        }

        return Integer.parseInt(sb.toString());
    }

}
