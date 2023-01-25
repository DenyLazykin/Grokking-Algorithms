package ru.job4j.chapter06;

import java.util.*;

public class BreadthFirstSearch {
    private static Map<String, List<String>> graph = new HashMap<>();

    /**
     * (17)Список позволяющий отслеживать, каких людей вы искали ранее.
     * (20)Осуществляем поиск этого человека только в том случае, если вы еще не искали его.
     * (26)Добавляет пользователя в список, что бы он не проверялся заново.
     * @param name Имя, которое необходимо найти
     * @return False, если имя не найдено.
     */
    private static boolean search(String name) {
        Queue<String> searchQueue = new ArrayDeque<>(graph.get(name));
        List<String> searched = new ArrayList<>();
        while (!searchQueue.isEmpty()) {
            String person = searchQueue.poll();
            if (!searched.contains(person)) {
                if (personIsSeller(person)) {
                    System.out.println(person + " is a mango seller!");
                    return true;
                } else {
                    searchQueue.addAll(graph.get(person));
                    searched.add(person);
                }
            }
        }
        return false;
    }

    private static boolean personIsSeller(String name) {
        return name.endsWith("m");
    }

    public static void main(String[] args) {
        graph.put("you", Arrays.asList("alice", "bob", "claire"));
        graph.put("bob", Arrays.asList("anuj", "peggy"));
        graph.put("alice", List.of("peggy"));
        graph.put("claire", Arrays.asList("thom", "jonny"));
        graph.put("anuj", Collections.emptyList());
        graph.put("peggy", Collections.emptyList());
        graph.put("thom", Collections.emptyList());
        graph.put("jonny", Collections.emptyList());
        search("you");
    }
}
