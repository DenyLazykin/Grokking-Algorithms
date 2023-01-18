package ru.job4j.chapter05;

public class LoopSum {
    private static int sum(int[] array) {
        int total = 0;
        for (int j : array) {
            total += j;
        }
        return total;
    }

    public static void main(String[] args) {
        System.out.println(sum(new int[]{1, 2, 3, 4}));
    }
}
