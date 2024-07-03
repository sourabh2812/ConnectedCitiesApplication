package com.admarketplace.demo;

import com.admarketplace.demo.service.CityConnectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
public class ConnectedCitiesApplication implements CommandLineRunner {

	private static final Logger logger = LoggerFactory.getLogger(ConnectedCitiesApplication.class);

	@Autowired
	private CityConnectionService cityConnectionService;

	public static void main(String[] args) {
		SpringApplication.run(ConnectedCitiesApplication.class, args);
	}

	@Override
	public void run(String... args) {
		if (args.length != 3) {
			logger.error("Usage: java -jar connected-cities.jar <city1> <city2> <filePath>");
			return;
		}

		String city1 = args[0];
		String city2 = args[1];
		String filePath = args[2];

		try {
			boolean connected = cityConnectionService.areCitiesConnected(city1, city2, filePath);
			logger.info(connected ? "CONNECTED" : "NOT CONNECTED");
		} catch (Exception e) {
			logger.error("Error processing the cities", e);
		}
	}
}
