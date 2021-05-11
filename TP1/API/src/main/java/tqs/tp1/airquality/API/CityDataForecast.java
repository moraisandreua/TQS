package tqs.tp1.airquality.API;

public class CityDataForecast {
    private CityDataForecastDaily daily;

    public CityDataForecast() {
    }

    public CityDataForecastDaily getDaily() {
        return daily;
    }

    public void setDaily(CityDataForecastDaily daily) {
        this.daily = daily;
    }

    @Override
    public String toString() {
        return "{" +
                "\"daily\": " + daily +
                "}";
    }
}
