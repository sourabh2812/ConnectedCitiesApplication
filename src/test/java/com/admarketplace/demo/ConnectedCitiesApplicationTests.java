package com.admarketplace.demo;

import com.admarketplace.demo.service.CityConnectionService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ConnectedCitiesApplicationTests {

	@Autowired
	private CityConnectionService cityConnectionService;

	private String testFilePath;

	@BeforeEach
	void setUp() {
		testFilePath = "src/test/resources/test_connected.txt";
	}

	@Test
	void testCitiesAreConnected() throws IOException {
		assertTrue(cityConnectionService.areCitiesConnected("New York", "Los Angeles", testFilePath));
		assertTrue(cityConnectionService.areCitiesConnected("Denver", "Nashville", testFilePath));
	}

	@Test
	void testCitiesAreNotConnected() throws IOException {
		assertFalse(cityConnectionService.areCitiesConnected("Los Angeles", "Nashville", testFilePath));
		assertFalse(cityConnectionService.areCitiesConnected("Chicago", "Seattle", testFilePath));
	}

	@Test
	void testCityIsConnectedToItself() throws IOException {
		assertTrue(cityConnectionService.areCitiesConnected("New York", "New York", testFilePath));
	}

	@Test
	void testCityNotInGraph() throws IOException {
		assertFalse(cityConnectionService.areCitiesConnected("New York", "NonExistentCity", testFilePath));
	}
}
