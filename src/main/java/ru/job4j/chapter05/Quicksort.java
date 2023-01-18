package ru.job4j.chapter05;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

public class Quicksort {
    private static List<Integer> quicksort(List<Integer> list) {
        if (list.size() < 2) {
            return list;
        } else {
            Integer pivot = list.get(0);
            List<Integer> less = list.stream()
                    .skip(1)
                    .filter(el -> el <= pivot)
                    .toList();
            List<Integer> greater = list.stream()
                    .skip(1)
                    .filter(el -> el > pivot)
                    .toList();
            return Stream.of(quicksort(less).stream(),
                            Stream.of(pivot),
                            quicksort(greater).stream())
                    .flatMap(Function.identity()).toList();
        }
    }

    public static void main(String[] args) {
        System.out.println(quicksort(Arrays.asList(11, 94, 34, 9, 1)));
    }
}
