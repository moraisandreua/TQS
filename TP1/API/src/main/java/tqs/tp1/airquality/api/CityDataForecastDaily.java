package tqs.tp1.airquality.api;

import java.util.List;

public class CityDataForecastDaily {
    private List<CityDataForecastDailyIndicator> o3;
    private List<CityDataForecastDailyIndicator> pm10;
    private List<CityDataForecastDailyIndicator> pm25;
    private List<CityDataForecastDailyIndicator> uvi;

    public CityDataForecastDaily() {
        /*
        // GERADO AUTOMATICAMENTE PELO PARSER JSON
         */
    }

    public CityDataForecastDaily(List<CityDataForecastDailyIndicator> o3, List<CityDataForecastDailyIndicator> pm10, List<CityDataForecastDailyIndicator> pm25, List<CityDataForecastDailyIndicator> uvi) {
        this.o3=o3;
        this.pm10=pm10;
        this.pm25=pm25;
        this.uvi=uvi;
    }

    public List<CityDataForecastDailyIndicator> getO3() {
        return o3;
    }

    public List<CityDataForecastDailyIndicator> getPm10() {
        return pm10;
    }

    public List<CityDataForecastDailyIndicator> getPm25() {
        return pm25;
    }

    public List<CityDataForecastDailyIndicator> getUvi() {
        return uvi;
    }

    public void setO3(List<CityDataForecastDailyIndicator> o3) {
        this.o3 = o3;
    }

    public void setPm10(List<CityDataForecastDailyIndicator> pm10) {
        this.pm10 = pm10;
    }

    public void setPm25(List<CityDataForecastDailyIndicator> pm25) {
        this.pm25 = pm25;
    }

    public void setUvi(List<CityDataForecastDailyIndicator> uvi) {
        this.uvi = uvi;
    }

    @Override
    public String toString() {
        return "{" +
                "\"o3\": " + o3 +
                ", \"pm10\": " + pm10 +
                ", \"pm25\": " + pm25 +
                ", \"uvi\": " + uvi +
                "}";
    }
}
