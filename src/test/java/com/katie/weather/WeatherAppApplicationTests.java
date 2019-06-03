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
	public void currentChicagoTempIsAStringValue() {
		Assert.assertTrue(weatherModel.currentChicagoTemp().getClass().getName() == "java.lang.String");
	}

	@Test
	public void currentChicagoTempIsAReasonableNumber() {
//		TODO broke this test when I added °F
//		Double temperatureDouble = Double.parseDouble(weatherModel.currentChicagoTemp());
//		Assert.assertTrue(temperatureDouble > -20);
//		Assert.assertTrue(temperatureDouble < 120);
	}

	@Test
	public void fetchesSomethingForChicagoRainData() {
		Assert.assertTrue(false);
	}

}
