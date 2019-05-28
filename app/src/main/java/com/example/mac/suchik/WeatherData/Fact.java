package com.example.mac.suchik.WeatherData;

import com.caverock.androidsvg.SVG;

public class Fact {
    private float temp;
    private float feels_like;
    private String icon;
    private String condition;
    private float wind_speed;
    private String wind_dir;
    private float pressure_mm;
    private float humidity;
    private float prec_type;
    private float cloudness;
    private SVG imageIcon;


    public SVG getImageIcon() {
        return imageIcon;
    }

    public void setImageIcon(SVG imageIcon) {
        this.imageIcon = imageIcon;
    }

    // Getter Methods

    public float getTemp() {
        return temp;
    }

    public float getFeels_like() {
        return feels_like;
    }

    public String getIcon() {
        return icon;
    }

    public String getCondition() {
        return condition;
    }

    public float getWind_speed() {
        return wind_speed;
    }


    public String getWind_dir() {
        return wind_dir;
    }

    public float getPressure_mm() {
        return pressure_mm;
    }


    public float getHumidity() {
        return humidity;
    }

    // Setter Methods

    public void setTemp(float temp) {
        this.temp = temp;
    }

    public void setFeels_like(float feels_like) {
        this.feels_like = feels_like;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public void setWind_speed(float wind_speed) {
        this.wind_speed = wind_speed;
    }


    public void setWind_dir(String wind_dir) {
        this.wind_dir = wind_dir;
    }

    public void setPressure_mm(float pressure_mm) {
        this.pressure_mm = pressure_mm;
    }


    public void setHumidity(float humidity) {
        this.humidity = humidity;
    }

    public void setPrec_type(float prec_type) {
        this.prec_type = prec_type;
    }

    public void setCloudness(float cloudness) {
        this.cloudness = cloudness;
    }
}
