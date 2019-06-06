package com.katie.weather;

import com.katie.weather.apiResponse.CurrentWeatherResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestTemplate;

import java.net.MalformedURLException;
import java.net.URL;

public class WeatherApiCall {

    private static final Logger LOG = LoggerFactory.getLogger(WeatherTestRun.class);

    public String getData() throws MalformedURLException {
        RestTemplate restTemplate = new RestTemplate();
        StringBuilder sb = new StringBuilder();
        WeatherModel model = new WeatherModel();

        sb.append("http://api.openweathermap.org/data/2.5/weather?id=");
        sb.append(model.cityID);
        sb.append("&appid=");
        sb.append(model.owmApiKey);

        CurrentWeatherResponse response = restTemplate.getForObject(sb.toString(), CurrentWeatherResponse.class);
        LOG.info(response.toString());
        System.out.println(response.getMain().getTemp());
        System.out.println(response.getWeather());
        System.out.println(response.getWeather().getMain());
        return "Not working yet";
    }
}
