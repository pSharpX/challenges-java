package com.challenger.common.permutations;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SinglePermutationChallenge {

    public static List<String> singlePermutations(String s) {
        if (s.length() == 1) {
            return List.of(s);
        }
        List<String> permutations = Arrays.asList(s);
        StringBuilder sb = new StringBuilder(s);
        for (int i = 0; i < s.length(); i++) {
            String a = String.valueOf(sb.charAt(i));
            for (int j = 0; j < s.length(); j++) {
                if (i != j) {
                    String b = String.valueOf(sb.charAt(j));
                    //permutations.add(sb.replace());
                }
            }
        }
        Set<String> result = new HashSet<>(permutations);
        return result.stream().toList();
    }

}
