package com.katie.weather;

import java.net.MalformedURLException;
import java.net.URL;

public class WeatherApiCall {
    public static String getData() throws MalformedURLException {
        URL apiURL = new URL("api.openweathermap.org/data/2.5/weather?q={Chicago}");
        return "Nope";
    }
}
