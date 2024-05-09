package com.challenger.common.anagram;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

public class AnagramTest {
    
    public static void main(String[] args) {
        System.out.println(isAnagram3("rescue", "secure"));
        System.out.println(groupAnagrams(new String[]{"lisent", "dda", "silent", " d ", "d  ", "rail safety", "add", "fairy tales", "cab", "ad", "abc", "dad", "dad"}));        
    }

    public static Map<String, List<String>> groupAnagrams(String[] list) {

        Map<String, List<String>> partitions = new HashMap<>();
        for(int i = 0; i < list.length; i++) {
            String word = list[i];
            
            Optional<String> optionalKey = partitions.keySet().stream()
            .filter(key -> isAnagram3(word, key))
            .findAny();

            List<String> current = optionalKey
            .map(key -> partitions.get(key))
            .orElse(new ArrayList<>());

            current.add(word);
            partitions.put(optionalKey.orElse(word), current);
        }
        return partitions;

    }

    public static boolean isAnagram(String a, String b) {
        if(a.length() != b.length()) {
            return false;
        }

        Map<String, Integer> m1 = new TreeMap<>();
        Map<String, Integer> m2 = new TreeMap<>();

        for(int i = 0; i < a.length(); i++){
            m1.put(Character.toString(a.charAt(i)), Optional.ofNullable(m1.get(Character.toString(a.charAt(i)))).map(x -> x + 1).orElse(1));
            m2.put(Character.toString(b.charAt(i)), Optional.ofNullable(m2.get(Character.toString(b.charAt(i)))).map(x -> x + 1).orElse(1));
        }

        
        return m1.equals(m2);
    }

    public static boolean isAnagram2(String a, String b) {
        if(a.length() != b.length()) {
            return false;
        }

        String[] c1 = a.split("");
        String[] c2 = b.split("");

        Arrays.sort(c1);
        Arrays.sort(c2);

        String m1 = String.join("", c1);
        String m2 = String.join("", c2);;

        return m1.equals(m2);
    }

    public static boolean isAnagram3(String a, String b){
        if(a.length() != b.length()) {
            return false;
        }

        int sumA = 0;
        int sumB = 0;

        for(int i = 0; i < a.length(); i++){
            sumA += (int)a.charAt(i);
            sumB += (int)b.charAt(i);
        }

        return sumA == sumB;
    }

}
