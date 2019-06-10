package com.katie.weather;

import com.katie.weather.apiResponse.CurrentWeatherResponse;
import com.katie.weather.apiResponse.Main;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.MockitoRule;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.mockito.Mockito.*;

/*
These are all wrong! I've been writing these unit tests that depend on the weather API--
I need to re-write the tests using mock objects that simulate the API calls. These are
not real unit tests.
*/

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class WeatherAppApplicationTests {

	@Rule
	public MockitoRule mockitoRule = MockitoJUnit.rule();

	@Mock
	Main mainMock;

	@Mock
	CurrentWeatherResponse currentWeatherResponseMock;

	@InjectMocks
	WeatherModel weatherModel;

	@Before
	public void setUp() {
		when(mainMock.getTemp()).thenReturn(70.0);
		when(currentWeatherResponseMock.getMain()).thenReturn(mainMock);
		when(currentWeatherResponseMock.getBase()).thenReturn("BASE");
	}

	@Test
	public void contextLoads() {
	}

	@Test
	public void simpleMockObjectTest() {
		Assert.assertTrue(currentWeatherResponseMock.getBase() == "BASE");

		Assert.assertTrue(currentWeatherResponseMock.getMain().getTemp() == 70.0);
	}

	@Test
	public void fetchesSomethingForCurrentWeatherInChicago() {
		Assert.assertNotNull(weatherModel.getChicagoWeather());
	}

	@Test
	public void currentChicagoTempIsAReasonableNumber() {
		Double temperatureDouble = currentWeatherResponseMock.getMain().getTemp();


		Assert.assertTrue(temperatureDouble > -20);
		Assert.assertTrue(temperatureDouble < 120);
	}

	@Test
	public void tempIsFormattedCorrectly() {
//		Assert.assertTrue(Pattern.matches("[0-9].*°F$", weatherModel.formattedTemp()));
		System.out.println(weatherModel.formattedTemp());
		Assert.assertTrue(Pattern.matches("[-0-9].*°F$", weatherModel.formattedTemp()));
	}


}
