package tqs.tp1.airquality.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CityDataIaqi {
    private CityDataIaqiIndicator dew;
    private CityDataIaqiIndicator h;
    private CityDataIaqiIndicator no2;
    private CityDataIaqiIndicator o3;
    private CityDataIaqiIndicator p;
    private CityDataIaqiIndicator pm10;
    private CityDataIaqiIndicator pm25;
    private CityDataIaqiIndicator so2;
    private CityDataIaqiIndicator t;
    private CityDataIaqiIndicator w;
    private CityDataIaqiIndicator wg;

    public CityDataIaqi() {
        /*
        // GERADO AUTOMATICAMENTE PELO PARSER JSON
         */
    }

    public void setDew(CityDataIaqiIndicator dew) {
        this.dew = dew;
    }

    public void setH(CityDataIaqiIndicator h) {
        this.h = h;
    }

    public void setNo2(CityDataIaqiIndicator no2) {
        this.no2 = no2;
    }

    public void setO3(CityDataIaqiIndicator o3) {
        this.o3 = o3;
    }

    public void setP(CityDataIaqiIndicator p) {
        this.p = p;
    }

    public void setPm10(CityDataIaqiIndicator pm10) {
        this.pm10 = pm10;
    }

    public void setPm25(CityDataIaqiIndicator pm25) {
        this.pm25 = pm25;
    }

    public void setSo2(CityDataIaqiIndicator so2) {
        this.so2 = so2;
    }

    public void setT(CityDataIaqiIndicator t) {
        this.t = t;
    }

    public void setW(CityDataIaqiIndicator w) {
        this.w = w;
    }

    public void setWg(CityDataIaqiIndicator wg) {
        this.wg = wg;
    }

    public CityDataIaqiIndicator getDew() {
        return dew;
    }

    public CityDataIaqiIndicator getH() {
        return h;
    }

    public CityDataIaqiIndicator getNo2() {
        return no2;
    }

    public CityDataIaqiIndicator getO3() {
        return o3;
    }

    public CityDataIaqiIndicator getP() {
        return p;
    }

    public CityDataIaqiIndicator getPm10() {
        return pm10;
    }

    public CityDataIaqiIndicator getPm25() {
        return pm25;
    }

    public CityDataIaqiIndicator getSo2() {
        return so2;
    }

    public CityDataIaqiIndicator getT() {
        return t;
    }

    public CityDataIaqiIndicator getW() {
        return w;
    }

    public CityDataIaqiIndicator getWg() {
        return wg;
    }

    @Override
    public String toString() {
        return "{" +
                "\"dew\": " + dew +
                ", \"h\": " + h +
                ", \"no2\": " + no2 +
                ", \"o3\": " + o3 +
                ", \"p\": " + p +
                ", \"pm10\": " + pm10 +
                ", \"pm25\": " + pm25 +
                ", \"so2\": " + so2 +
                ", \"t\": " + t +
                ", \"w\": " + w +
                ", \"wg\": " + wg +
                "}";
    }
}
