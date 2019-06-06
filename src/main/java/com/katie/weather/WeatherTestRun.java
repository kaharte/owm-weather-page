package com.katie.weather;

import com.katie.weather.apiResponse.CurrentWeatherResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestTemplate;

public class WeatherTestRun {

    private static final Logger LOG = LoggerFactory.getLogger(WeatherTestRun.class);

    public static void main(String[] args) {

        RestTemplate restTemplate = new RestTemplate();
        CurrentWeatherResponse response = restTemplate.getForObject("https://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=b6907d289e10d714a6e88b30761fae22", CurrentWeatherResponse.class);
        LOG.info(response.toString());
        System.out.println(response.getMain().getTemp());
        System.out.println(response.getWeather());
        System.out.println();
    }
}
