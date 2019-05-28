package com.example.mac.suchik.WeatherData;

public class Info {
        private boolean f;
        private boolean n;
        private boolean p;
        private float lat;
        private float lon;


        // Getter Methods

        public boolean getF() {
            return f;
        }

        public boolean getN() {
            return n;
        }

        public boolean getP() {
            return p;
        }

        public float getLat() {
            return lat;
        }

        public float getLon() {
            return lon;
        }

        // Setter Methods

        public void setF(boolean f) {
            this.f = f;
        }

        public void setN(boolean n) {
            this.n = n;
        }

        public void setP(boolean p) {
            this.p = p;
        }

        public void setLat(float lat) {
            this.lat = lat;
        }

        public void setLon(float lon) {
            this.lon = lon;
        }

    }
