package com.katie.weather;

import net.aksingh.owmjapis.api.APIException;
import net.aksingh.owmjapis.core.OWM;
import net.aksingh.owmjapis.model.CurrentWeather;
import net.aksingh.owmjapis.model.HourlyWeatherForecast;
import net.aksingh.owmjapis.model.param.Main;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.io.Writer;
import java.text.DecimalFormat;

@Component
public class WeatherModel {
    public String owmApiKey = "0bbd0d0a5ab1ff072291b6d5e80c657f";
    public int cityID = 4887398; //this is Chicago ID, figure out how to get number from JSON file
    public String cityString = "Chicago";
    public OWM owm = new OWM(owmApiKey);
    public CurrentWeather chicagoWeather;
    public HourlyWeatherForecast chicagoHourlyForecast;

    {
        try {
            chicagoWeather = owm.currentWeatherByCityId(cityID);
            chicagoHourlyForecast = owm.hourlyWeatherForecastByCityId(cityID);
        } catch (APIException e) {
            e.printStackTrace();
        }
    }

    public CurrentWeather getChicagoWeather() {
        System.out.println(chicagoWeather);
        return chicagoWeather;
    }

    public String currentChicagoTemp() {

        Main chicagoMainData = chicagoWeather.getMainData();
        System.out.println(chicagoWeather.getMainData());;
        Double tempInKelvin = chicagoMainData.getTemp();
        Double tempInFahrenheit = (tempInKelvin - 273.15) * 9/5 + 32.0;
        System.out.println(tempInFahrenheit);
        return new DecimalFormat("#.##").format(tempInFahrenheit);
    }

    @Bean
    public int getCityID() {
        return cityID;
    }
}