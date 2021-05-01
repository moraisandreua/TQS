package tqs.tp1.airquality.API;

public class CityDataForecastDailyIndicator {
    private Integer avg;
    private String day;
    private Integer max;
    private Integer min;

    public CityDataForecastDailyIndicator() {
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
        return "CityDataForecastDailyIndicator{" +
                "avg=" + avg +
                ", day='" + day + '\'' +
                ", max=" + max +
                ", min=" + min +
                '}';
    }
}
