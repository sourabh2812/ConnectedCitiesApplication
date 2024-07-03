package com.admarketplace.demo.model;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CityGraph {
    private Map<String, Set<String>> adjacencyList;

    public CityGraph() {
        this.adjacencyList = new HashMap<>();
    }

    public void addEdge(String city1, String city2) {
        adjacencyList.putIfAbsent(city1, new HashSet<>());
        adjacencyList.putIfAbsent(city2, new HashSet<>());
        adjacencyList.get(city1).add(city2);
        adjacencyList.get(city2).add(city1);
    }

    public Map<String, Set<String>> getAdjacencyList() {
        return adjacencyList;
    }
}
