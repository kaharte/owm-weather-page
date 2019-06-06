package com.katie.weather.apiResponse;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.stereotype.Controller;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Weather {
    //WeatherArray[] weather;
}
