package com.katie.weather;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.validation.constraints.AssertTrue;

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
	public void currentChicagoTempIsADoubleValue() {
		Assert.assertTrue(weatherModel.currentChicagoTemp().getClass().getName() == "java.lang.Double");
	}

	@Test
	public void currentChicagoTempIsAReasonableNumber() {
		Assert.assertTrue(weatherModel.currentChicagoTemp() > -20);
		Assert.assertTrue(weatherModel.currentChicagoTemp() < 120);
	}

	@Test
	public void fetchesSomethingForChicagoRainData() {
		Assert.assertTrue(false);
	}

}
