package com.katie.weather;

import com.katie.weather.apiResponse.CurrentWeatherResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestTemplate;

import java.net.MalformedURLException;

public class WeatherTestRun {

    private static final Logger LOG = LoggerFactory.getLogger(WeatherTestRun.class);

    public static void main(String[] args) {

        WeatherApiCall weatherApiCall = new WeatherApiCall();
        WeatherModel model = new WeatherModel();

        try {
            model.chicagoWeather = weatherApiCall.getData();
        } catch (MalformedURLException e) {
            LOG.error("bad URL", e);
            e.printStackTrace();
        }

        System.out.println(model.chicagoWeather);
    }
}
