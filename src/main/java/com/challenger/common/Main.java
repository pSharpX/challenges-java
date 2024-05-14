package com.challenger.common;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        Random random = new Random();
        int[] numbs = new int[1000000];
        for (int i = 0; i < numbs.length; i++) {
            numbs[i] = random.nextInt(10000000);
        }

        System.out.println("Before:");
        Arrays.stream(numbs).boxed().forEach(System.out::println);

        long initStart = System.currentTimeMillis();
        bubbleSort(numbs);
        long endStart = System.currentTimeMillis();
        System.out.println("\nAfter:");
        Arrays.stream(numbs).boxed().forEach(System.out::println);

        System.out.println("\nStart (ml): " + initStart);
        System.out.println("\nEnd (ml): " + endStart);
        System.out.println("\nTime (s): " + (endStart - initStart)/1000);
    }

    public static int[] countPositivesSumNegatives(int[] input)
    {
        if (input == null || input.length == 0) {
            return new int[]{};
        }
        int count = 0;
        int sum = 0;
        for (int i = 0; i < input.length; i++) {
            if (input[i] > 0) {
                count += 1;
            } else {
                sum += input[i];
            }
        }
        return new int[] {count, sum};
    }

    public static String repeatStr(final int repeat, final String string) {
        StringBuilder newString = new StringBuilder();
        for (int i = repeat; i > 0; i--) {
            newString.append(string);
        }
        return newString.toString();
    }

    public static String fakeBin(String numberString) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numberString.length(); i++) {
            if (Integer.parseInt(String.valueOf(numberString.charAt(i))) < 5){
                sb.append("0");
            } else {
                sb.append("1");
            }
        }
        return sb.toString();
    }

    public static String fakeBin2(String numberString) {
        return numberString.chars()
                .mapToObj(Character::toString)
                .map(charVar -> Integer.parseInt(charVar) < 5 ? "0": "1")
                .collect(Collectors.joining(""));
    }

    public static boolean zeroFuel(double distanceToPump, double mpg, double fuelLeft) {
        return mpg * fuelLeft >= distanceToPump;
    }

    public static String evenOrOdd(int number) {
        return number % 2 == 0 ? "Even": "Odd";
    }

    public static int[] digitize(long n) {
        if (n < 10) return new int[]{(int)n};

        String digitsInString = n+"";
        int[] digits = new int[digitsInString.length()];
        int lastIndex = digitsInString.length() - 1;
        for (int i = lastIndex; i >= 0; i--) {
            digits[lastIndex - i] = Integer.parseInt(Character.toString(digitsInString.charAt(i)));
        }
        return digits;
    }

    public static int[] digitizeDefaultOrder(int n) {
        if (n < 10) return new int[]{n};
        String digitsInString = n+"";
        return Stream.of(digitsInString.split("")).mapToInt(Integer::parseInt).toArray();
    }

    public static boolean betterThanAverage(int[] classPoints, int yourPoints) {
        return yourPoints > (IntStream.of(classPoints).sum() + yourPoints) / (classPoints.length + 1);
    }

    public int Liters(double time)  {
        return (int)(time * 0.5);
    }

    public static boolean isLove(final int flower1, final int flower2) {
        return ((flower1 & 1) == 0) != ((flower2 & 1) == 0);
    }

    public static int summation(int n) {
        if (n == 1) return n;
        return IntStream.range(0, n + 1)
                .sum();
    }

    public static int Past(int h, int m, int s) {
        return (s*1000)+(m*60*1000)+(h*60*60*1000);
    }

    public static void sortNumbersAsc(int[] array) {
        for (int i = 0; i < array.length-1; i ++) {
            int temp = array[i];
            for (int j = (i+1); j < array.length; j++){
                if (temp > array[j]) {
                    temp = array[j];
                    array[j] = array[i];
                    array[i] = temp;
                }
            }
        }
    }

    public static int[] sortNumbersAsc2(int[] array) {
        Integer[] numbers = Arrays.stream(array).boxed().toArray(Integer[]::new);
        SortedSet<Integer> numbs = new TreeSet<>(Arrays.asList(numbers));
        return numbs.stream().mapToInt(Integer::intValue).toArray();
    }

    public static int[][] twosDifference(int[] array) {
        sortNumbersAsc(array);

        List<int[]> result = new ArrayList<>();
        for (int i = 0; i < array.length-1; i++) {
            for (int j = i+1; j < array.length; j++) {
                if (array[j] - array[i] == 2) {
                    result.add(new int[] {array[i], array[j]});
                }
            }
        }
        return result.toArray(new int[][]{});
    }

    public static String makeComplement(String dna) {
        Map<String, String> dnaComplements = Map.of(
                "T", "A",
                "A", "T",
                "C", "G",
                "G", "C"
        );
        return Stream.of(dna.split("")).map(dnaComplements::get).collect(Collectors.joining(""));
    }

    public static int[] withdraw(int n) {
        if (n % 100 == 0) {
            return new int[]{n / 100, 0, 0};
        }

        int[] bills = new int[] {0,0,0};
        do {
            if (n % 20 != 0) {
                n -= 50;
                bills[1] = 1;
            } else {
                if (n > 100) {
                    bills[0] = n / 100;
                    n %= 100;
                } else if (n >= 20) {
                    bills[2] = n / 20;
                    n %= 20;
                } else {
                    throw new IllegalArgumentException("Argument not supported: " + n);
                }
            }
        } while (n > 0);
        return bills;
    }

    public static int closeToZero(int[] numbs) {
        if (numbs == null || numbs.length == 0){
            return 0;
        }

        Set<Integer> numbers = new TreeSet<>(Arrays.stream(numbs).boxed().toList());
        List<Integer> positives = numbers.stream().filter(x -> x > 0).toList();
        List<Integer> negatives = numbers.stream().filter(x -> x < 0).toList();

        int a = positives.isEmpty() ? 0: positives.get(0);
        int b = negatives.isEmpty() ? 0: negatives.get(negatives.size() - 1);

        if (a == 0) return b;
        if (b == 0) return a;

        return Math.abs(b) == a ? a: (Math.abs(b) > a ? a : b);
    }

    public static boolean getXO (String str) {
        Matcher x = Pattern.compile("x", Pattern.CASE_INSENSITIVE).matcher(str);
        Matcher o = Pattern.compile("o", Pattern.CASE_INSENSITIVE).matcher(str);

        if (x.matches() != o.matches()) {
            return false;
        }
        int xCount = 0;
        while(x.find()) {
            xCount++;
        }
        int oCount = 0;
        while(o.find()) {
            oCount++;
        }

        return xCount == oCount;
    }

    public static String printerError(String s) {
        return s.chars().filter(x -> x < 97 || x > 109).count() + "/" + s.length();
    }

    public static boolean  isIsogram(String str) {
        return str.length() == 0 || new TreeSet<>(str.toUpperCase().chars().boxed().toList()).size() == str.length();
    }

    public static boolean  isIsogram2(String str) {
        if (str.length() == 0) return true;

        String lc = str.toLowerCase();
        Map<Integer, String> holder = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            int c = Character.getNumericValue(str.charAt(i));
            if (holder.containsKey(c)) {
                return false;
            }
            holder.put(c, Character.toString(str.charAt(i)));
        }
        return true;
    }

    public static String highAndLow(String numbers) {
        String[] strNumbs = numbers.split(" ");
        return Arrays.stream(strNumbs).mapToInt(Integer::parseInt).max().getAsInt() +  " " + Arrays.stream(strNumbs).mapToInt(Integer::parseInt).min().getAsInt();
    }

    public static String highAndLow2(String numbers) {
        int[] numbs = Arrays.stream(numbers.split(" ")).mapToInt(Integer::parseInt).toArray();

        boolean swap = true;
        while (swap) {
            swap = false;
            for (int i = 0; i < numbs.length - 1; i++) {
                if (numbs[i] > numbs[i + 1]) {
                    int temp = numbs[i + 1];
                    numbs[i + 1] = numbs[i];
                    numbs[i] = temp;
                    swap = true;
                }
            }
        }

        return numbs[numbs.length - 1] + " " + numbs[0];
    }

    public static void bubbleSort(int[] numbs) {
        boolean swap = true;
        while (swap) {
            swap = false;
            for (int i = 0; i < numbs.length - 1; i++) {
                if (numbs[i] > numbs[i + 1]) {
                    int temp = numbs[i + 1];
                    numbs[i + 1] = numbs[i];
                    numbs[i] = temp;
                    swap = true;
                }
            }
        }
    }

    public static void quickSort(int[] numbs, int lowIndex, int highIndex) {

    }

    public static String millisecondToDate(long ml) {
        long sec = ml / 1000;
        long rMl = ml % 1000;

        long min = sec / 60;
        long rSec = sec % 60;

        long hour = ml / (60*60*1000);
        long rMin = ml % (60*60*1000);
        return String.format("%dh %dm %ds %dml", hour, min, sec, ml);
    }

    public static String longest (String s1, String s2) {
        return Stream.concat(s1.chars().boxed(), s2.chars().boxed()).distinct().sorted().map(Character::toString).collect(Collectors.joining());
    }

    public static int findShort(String s) {
        return Arrays.stream(s.split(" ")).min(Comparator.comparingInt(String::length)).map(String::length).orElse(0);
    }

    public static int findShort2(String s) {
        String[] words = s.split(" ");
        String shortest = words[0];
        for (int i = 1; i < words.length - 1; i++) {
            if (shortest.length() > words[i + 1].length()) {
                shortest = words[i + 1];
            }
        }
        return shortest.length();
    }

    public static int findShort3(String s) {
        return Arrays.stream(s.split(" ")).mapToInt(String::length).sorted().findFirst().orElse(0);
    }

    public static int century(int number) {
        return (number % 100 == 0) ? number / 100: (number / 100) + 1;
    }

    public static int century2(int number) {
        return (int) Math.ceil((double)number / 100);
    }

}
