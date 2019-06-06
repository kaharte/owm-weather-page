package com.katie.weather;

import com.katie.weather.apiResponse.CurrentWeatherResponse;
import net.aksingh.owmjapis.api.APIException;
import net.aksingh.owmjapis.core.OWM;
import net.aksingh.owmjapis.model.CurrentWeather;
import net.aksingh.owmjapis.model.HourlyWeatherForecast;
import net.aksingh.owmjapis.model.param.Main;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.net.MalformedURLException;
import java.text.DecimalFormat;

@Component
public class WeatherModel {
//    public String owmApiKey = "0bbd0d0a5ab1ff072291b6d5e80c657f";
//    public int cityID = 4887398; //this is Chicago ID, figure out how to get number from JSON file
//    public String cityString = "Chicago";
//    public OWM owm = new OWM(owmApiKey);
    public CurrentWeatherResponse chicagoWeather;
//    public HourlyWeatherForecast chicagoHourlyForecast;

    {
        WeatherApiCall weatherApiCall = new WeatherApiCall();

        try {
            chicagoWeather = weatherApiCall.getData();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    public CurrentWeatherResponse getChicagoWeather() {
        return chicagoWeather;
    }

    public void setChicagoWeather(CurrentWeatherResponse chicagoWeather) {
        this.chicagoWeather = chicagoWeather;
    }

    public Double currentChicagoTemp() {

        Double tempInKelvin = chicagoWeather.getMain().getTemp();
        Double tempInFahrenheit = (tempInKelvin - 273.15) * 9/5 + 32.0;
        return tempInFahrenheit;
    }

    public String formattedTemp() {
        return new DecimalFormat("#.#").format(currentChicagoTemp()) + " °F";
    }

//    public int getCityID() {
//        return cityID;
//    }
}