package tqs.tp1.airquality.api;

public class CityDataForecast {
    private CityDataForecastDaily daily;

    public CityDataForecast() {
        /*
        // GERADO AUTOMATICAMENTE PELO PARSER JSON
         */
    }

    public CityDataForecast(CityDataForecastDaily daily){
        this.daily=daily;
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
