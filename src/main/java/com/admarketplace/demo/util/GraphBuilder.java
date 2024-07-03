package com.admarketplace.demo.util;

import com.admarketplace.demo.model.CityGraph;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class GraphBuilder {

    private static final Logger logger = LoggerFactory.getLogger(GraphBuilder.class);

    public static CityGraph buildGraph(String filePath) throws IOException {
        CityGraph cityGraph = new CityGraph();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] cities = line.split(", ");
                cityGraph.addEdge(cities[0], cities[1]);
                logger.debug("Added edge between: {} and {}", cities[0], cities[1]);
            }
        } catch (IOException e) {
            logger.error("Error reading the file", e);
            throw e;
        }
        return cityGraph;
    }
}
