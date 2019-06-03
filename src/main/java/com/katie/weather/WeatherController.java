package com.katie.weather;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/")
public class WeatherController {
    WeatherModel weatherModel = new WeatherModel();

    @RequestMapping(path = "/katherine.harte@grainger.com")
    public String getKatiesInfo() {
        return "katie";
    }

    @RequestMapping(path = "/weather/Chicago")
    public String showChicagoWeather(Model model) {
        model.addAttribute("cityID", weatherModel.getCityID());
        model.addAttribute("temperature", weatherModel.currentChicagoTemp());
        return "chicago";
    }

}
