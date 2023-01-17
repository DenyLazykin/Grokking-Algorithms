package ru.job4j.chapter02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SelectionSort {
    public static void main(String[] args) {
        List<Integer> integerList = new ArrayList<>(Arrays.asList(3, 1, 4, 0, 8));
        System.out.println(selectionSort(integerList));
        int[] array = {3, 1, 4, 0, 8};
        System.out.println();
        selectionSort(array);
        System.out.println(Arrays.toString(array));
    }

    private static List<Integer> selectionSort(List<Integer> array) {
        List<Integer> newArray = new ArrayList<>(array.size());
        int size = array.size();
        for (int i = 0; i < size; i++) {
            int smallest = findSmallest(array);
            newArray.add(array.get(smallest));
            array.remove(smallest);
        }
        return newArray;
    }

    private static int findSmallest(List<Integer> array) {
        int smallest = array.get(0);
        int smallestIndex = 0;
        for (int i = 0; i < array.size(); i++) {
            if (array.get(i) < smallest) {
                smallest = array.get(i);
                smallestIndex = i;
            }
        }
        return smallestIndex;
    }

    public static void selectionSort(int[] target) {
        for (int i = 0; i < target.length - 1; i++) {
            int left = target[i];
            for (int j = i + 1; j < target.length; j++) {
                int right = target[j];
                if (left > right) {
                    target[i] = right;
                    target[j] = left;
                    left = right;
                }
            }
        }
    }
}
