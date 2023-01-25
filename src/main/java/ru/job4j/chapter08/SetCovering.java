package ru.job4j.chapter08;

import java.util.*;

public class SetCovering {
    public static void main(String[] args) {
        var statesNeeded = new HashSet<>(Arrays.asList("mt", "wa", "or", "id", "nv", "ut", "ca", "az"));
        var stations = new LinkedHashMap<String, Set<String>>();
        stations.put("one", new HashSet<>(Arrays.asList("id", "nv", "ut")));
        stations.put("two", new HashSet<>(Arrays.asList("wa", "id", "mt")));
        stations.put("three", new HashSet<>(Arrays.asList("or", "nv", "ca")));
        stations.put("four", new HashSet<>(Arrays.asList("nv", "ut")));
        stations.put("five", new HashSet<>(Arrays.asList("ca", "az")));
        var finalStations = new HashSet<String>();
        while (!statesNeeded.isEmpty()) {
            String bestStation = null;
            var statesCovered = new HashSet<String>();
            for (var station : stations.entrySet()) {
                var covered = new HashSet<>(statesNeeded);
                covered.retainAll(station.getValue());
                if (covered.size() > statesCovered.size()) {
                    bestStation = station.getKey();
                    statesCovered = covered;
                }
            }
            statesNeeded.removeIf(statesCovered::contains);
            if (bestStation != null) {
                finalStations.add(bestStation);
            }
        }
        System.out.println(finalStations);
    }
}
