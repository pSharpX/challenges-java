package com.challenger.common.findodd;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindOdd {

    public static int findIt(int[] a) {
        Map<Integer, Integer> dict = new HashMap<>();
        for (int i = 0; i < a.length; i++){
            int current = a[i];
            dict.put(current, dict.getOrDefault(current, 0) + 1);
        }
        return dict.entrySet().stream()
                .filter(entry -> entry.getValue() % 2 == 1)
                .findFirst()
                .map(Map.Entry::getKey).orElse(0);
    }

    public static int findIt2(int[] a) {
        return Arrays.stream(a).boxed().collect(Collectors.groupingBy(
                Function.identity(),
                Collectors.counting()
                )).entrySet().stream()
                .filter(entry -> entry.getValue() % 2 == 1)
                .findFirst()
                .map(Map.Entry::getKey).orElse(0);
    }

}
