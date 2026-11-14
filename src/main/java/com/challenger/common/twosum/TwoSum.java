package com.challenger.common.twosum;

public class TwoSum {

    public static void main(String[] args) {

    }

    public static int[] twoSum(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; i++){
            int current = numbers[i];

            for (int j = 0; j < numbers.length; j++){
                if (j == i){
                    continue;
                }
                int next = numbers[j];
                if (current + next == target) {
                    return new int[] {i, j};
                }
            }
        }
        return new int[]{};
    }

}
