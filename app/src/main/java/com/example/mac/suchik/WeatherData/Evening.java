package com.example.mac.suchik.WeatherData;

import com.caverock.androidsvg.SVG;

public class Evening {
        private float temp_avg;
        private float feels_like;
        private String icon;
        private String condition;
        private float pressure_mm;
        private float humidity;


        // Getter Methods

        public float getTemp_avg() {
            return temp_avg;
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


        public float getPressure_mm() {
            return pressure_mm;
        }

        public float getHumidity() {
            return humidity;
        }



        public void setTemp_avg(float temp_avg) {
            this.temp_avg = temp_avg;
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

        public void setPressure_mm(float pressure_mm) {
            this.pressure_mm = pressure_mm;
        }

        public void setHumidity(float humidity) {
            this.humidity = humidity;
        }

}
