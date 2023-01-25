package ru.job4j.chapter07;

import java.util.*;

public class DijkstrasAlgorithm {
    private static Map<String, Map<String, Double>> graph = new HashMap<>();
    private static List<String> processed = new ArrayList<>();

    /**
     * Для поиска узла, с наименьшей стоимостью.
     * (21) Проходим, по каждому узлу графа.
     * (23) Если это самая низкая стоимость на данный момент и она еще не была обработана
     * (24)Установите его в качестве нового узла с наименьшими затратами.
     *
     * @param costs Мапа с узлами.
     * @return Узел с наименьшей стоимостью.
     */
    private static String findLowestCostNode(Map<String, Double> costs) {
        Double lowestCost = Double.POSITIVE_INFINITY;
        String lowestCostNode = null;
        for (Map.Entry<String, Double> node : costs.entrySet()) {
            Double cost = node.getValue();
            if (cost < lowestCost && !processed.contains(node.getKey())) {
                lowestCost = cost;
                lowestCostNode = node.getKey();
            }
        }
        return lowestCostNode;
    }

    /**
     * (60) Проходим по всем соседям этого узла.
     * (63) Проходим через всех соседей этого узла.
     * (66) Если дешевле добраться до этого соседа, пройдя через этот узел
     * (67) Обновляем стоимость для этого узла.
     * (68) Этот узел становится новым родительским для этого соседа.
     * (71) Помечаем узел как обработанный.
     * (72) Находим следующий узел для обработки и выполняем цикл.
     *
     * @param args args
     */
    public static void main(String[] args) {
        graph.put("start", new HashMap<>());
        graph.get("start").put("a", 6.0);
        graph.get("start").put("b", 2.0);
        graph.put("a", new HashMap<>());
        graph.get("a").put("fin", 1.0);
        graph.put("b", new HashMap<>());
        graph.get("b").put("a", 3.0);
        graph.get("b").put("fin", 5.0);
        graph.put("fin", new HashMap<>());
        Map<String, Double> costs = new HashMap<>();
        costs.put("a", 6.0);
        costs.put("b", 2.0);
        costs.put("fin", Double.POSITIVE_INFINITY);
        Map<String, String> parents = new HashMap<>();
        parents.put("a", "start");
        parents.put("b", "start");
        parents.put("fin", null);
        String node = findLowestCostNode(costs);
        while (node != null) {
            Double cost = costs.get(node);
            Map<String, Double> neighbors = graph.get(node);
            for (String n : neighbors.keySet()) {
                double newCost = cost + neighbors.get(n);
                if (costs.get(n) > newCost) {
                    costs.put(n, newCost);
                    parents.put(n, node);
                }
            }
            processed.add(node);
            node = findLowestCostNode(costs);
        }
        System.out.println("Стоимость от начала до каждого узла");
        System.out.println(costs);
    }
}
