package com.admarketplace.demo.service;

import com.admarketplace.demo.model.CityGraph;
import com.admarketplace.demo.util.GraphBuilder;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

@Service
public class CityConnectionService {

    private static final Logger logger = LoggerFactory.getLogger(CityConnectionService.class);

    public boolean areCitiesConnected(String city1, String city2, String filePath) throws IOException {
        CityGraph cityGraph = GraphBuilder.buildGraph(filePath);
        return isConnected(cityGraph, city1, city2);
    }

    private boolean isConnected(CityGraph cityGraph, String city1, String city2) {
        if (!cityGraph.getAdjacencyList().containsKey(city1) || !cityGraph.getAdjacencyList().containsKey(city2)) {
            logger.debug("One or both cities are not in the graph: {}, {}", city1, city2);
            return false;
        }

        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.add(city1);

        while (!queue.isEmpty()) {
            String current = queue.poll();
            if (current.equals(city2)) {
                return true;
            }
            visited.add(current);
            for (String neighbor : cityGraph.getAdjacencyList().get(current)) {
                if (!visited.contains(neighbor)) {
                    queue.add(neighbor);
                }
            }
        }
        return false;
    }
}
