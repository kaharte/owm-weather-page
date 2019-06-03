package com.katie.weather;

import net.aksingh.owmjapis.api.APIException;
import net.aksingh.owmjapis.core.OWM;
import net.aksingh.owmjapis.model.CurrentWeather;
import net.aksingh.owmjapis.model.param.Main;

public class WeatherModel {
    public String owmApiKey = "0bbd0d0a5ab1ff072291b6d5e80c657f";
    public int cityID = 3582383; //this is Chicago ID, figure out how to get number from JSON file
    public OWM owm = new OWM(owmApiKey);
    public CurrentWeather chicagoWeather;

    {
        try {
            chicagoWeather = owm.currentWeatherByCityId(cityID);
        } catch (APIException e) {
            e.printStackTrace();
        }
    }

    public CurrentWeather getChicagoWeather() {
        System.out.println(chicagoWeather);
        return chicagoWeather;
    }

    public Double currentChicagoTemp() {

        Main chicagoMainData = chicagoWeather.getMainData();
        System.out.println(chicagoWeather.getMainData());;
        Double tempInKelvin = chicagoMainData.getTemp();
        Double tempInFahrenheit = (tempInKelvin - 273.15) * 9/5 + 32.0;
        System.out.println(tempInFahrenheit);
        return tempInFahrenheit;
    }
}

