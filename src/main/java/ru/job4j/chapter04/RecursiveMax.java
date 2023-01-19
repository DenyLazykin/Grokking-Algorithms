package ru.job4j.chapter04;

import java.util.Arrays;

public class RecursiveMax {
    private static int max(int[] list) {
        if (list.length == 2) {
            return Math.max(list[0], list[1]);
        }
        int subMax = max(Arrays.copyOfRange(list, 1, list.length));
        return Math.max(list[0], subMax);
    }

    public static void main(String[] args) {
        System.out.println(max(new int[]{1, 5, 10, 25, 165, 1}));
    }
}
