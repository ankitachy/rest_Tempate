package com.stackroute.resttemplate.service;

import com.stackroute.resttemplate.model.Weather;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {

    //add your api key here
    private static final String API_KEY = "106c842d2f6fb2f3d0de6c5be0f2382e";

    //add the base api url here
    private static final String API_URL = "http://api.weatherstack.com/current?access_key="+API_KEY+"&query=";

    private final RestTemplate restTemplate;
    public WeatherService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    //using rest template, get the weather details of a city
    public Weather getWeather(String city) {
       Weather weather= restTemplate.getForObject(API_URL+city,Weather.class);
       return weather;
    }


}
