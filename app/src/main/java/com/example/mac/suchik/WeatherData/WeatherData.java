package com.example.mac.suchik.WeatherData;

import java.util.List;

public class WeatherData {

        Info info;
        Fact fact;
        List<Forecasts> forecasts;


        // Getter Methods

    public Info getInfo() {
        return info;
    }

    public void setInfo(Info info) {
        this.info = info;
    }

    public Fact getFact() {
        return fact;
    }

    public List<Forecasts> getForecasts() {
        return forecasts;
    }
}

