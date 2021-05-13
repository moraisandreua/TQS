package tqs.tp1.airquality.api;

public class CityDataForecastDailyIndicator {
    private Integer avg;
    private String day;
    private Integer max;
    private Integer min;

    public CityDataForecastDailyIndicator(){
        /*
        // GERADO AUTOMATICAMENTE PELO PARSER JSON
         */
    }

    public CityDataForecastDailyIndicator(Integer avg, String day, Integer max, Integer min) {
        this.avg=avg;
        this.day=day;
        this.max=max;
        this.min=min;
    }

    public Integer getAvg() {
        return avg;
    }

    public String getDay() {
        return day;
    }

    public Integer getMax() {
        return max;
    }

    public Integer getMin() {
        return min;
    }

    public void setAvg(Integer avg) {
        this.avg = avg;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public void setMax(Integer max) {
        this.max = max;
    }

    public void setMin(Integer min) {
        this.min = min;
    }

    @Override
    public String toString() {
        return "{" +
                "\"avg\": " + avg +
                ", \"day\": \"" + day + '\"' +
                ", \"max\": " + max +
                ", \"min\": " + min +
                "}";
    }
}
