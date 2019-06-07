package com.katie.weather;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
These are all wrong! I've been writing these unit tests that depend on the weather API--
I need to re-write the tests using mock objects that simulate the API calls. These are
not real unit tests.
*/

@RunWith(SpringRunner.class)
@SpringBootTest
public class WeatherAppApplicationTests {
	WeatherModel weatherModel;

	@Before
	public void setUp() {
		weatherModel = new WeatherModel();
	}

	@Test
	public void contextLoads() {
	}

	@Test
	public void fetchesSomethingForCurrentWeatherInChicago() {
		Assert.assertNotNull(weatherModel.getChicagoWeather());
	}

	@Test
	public void currentChicagoTempIsAReasonableNumber() {
		Double temperatureDouble = weatherModel.currentChicagoTemp();

		Assert.assertTrue(temperatureDouble > -20);
		Assert.assertTrue(temperatureDouble < 120);
	}

	@Test
	public void tempIsFormattedCorrectly() {
		Assert.assertTrue(Pattern.matches("[0-9].*°F$", weatherModel.formattedTemp()));
	}


}
