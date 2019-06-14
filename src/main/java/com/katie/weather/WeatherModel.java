package com.katie.weather;

import com.katie.weather.apiResponse.CurrentWeatherResponse;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.net.MalformedURLException;
import java.text.DecimalFormat;

@Component
public class WeatherModel {

    private CurrentWeatherResponse chicagoWeather;

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
        /*
        TODO This violates the Law of Demeter.
        Does this fall under the exception for data structures with no behavior though?
        */
        Double tempInKelvin = chicagoWeather.getMain().getTemp();
        Double tempInFahrenheit = (tempInKelvin - 273.15) * 9/5 + 32.0;
        return tempInFahrenheit;
    }

    public String formattedTemp() {
        return new DecimalFormat("#.#").format(currentChicagoTemp()) + " °F";
    }

    public String currentWeatherType() {
        return chicagoWeather.getWeather().getMain();
    }

}