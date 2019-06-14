package com.katie.weather;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(path = "/")
public class WeatherController {
    private WeatherModel weatherModel = new WeatherModel();

    @RequestMapping(path = "/katherine.harte@grainger.com", method = RequestMethod.GET)
    public String getKatiesInfo() {
        return "katie";
    }

    @RequestMapping(path = "/weather/Chicago", method = RequestMethod.GET)
    public String showChicagoWeather(Model model) {
        model.addAttribute("cityID", ApiStaticInfo.cityID);
        model.addAttribute("temperature", weatherModel.formattedTemp());
        model.addAttribute("weather", weatherModel.currentWeatherType());
        return "chicago";
    }

}