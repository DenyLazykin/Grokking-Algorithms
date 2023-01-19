package ru.job4j.chapter04;

import java.util.Arrays;

public class RecursiveSum {
    private static int sum(int[] array) {
        if (array.length == 0) {
            return 0;
        } else {
            return array[0] + sum(Arrays.copyOfRange(array, 1, array.length));
        }
    }

    public static void main(String[] args) {
        System.out.println(sum(new int[]{1, 2, 3, 4}));
    }
}
