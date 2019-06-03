package com.katie.weather;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/")
public class WeatherController {
    WeatherModel weatherModel = new WeatherModel();



}
