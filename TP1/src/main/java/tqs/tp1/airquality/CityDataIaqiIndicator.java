package tqs.tp1.airquality;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CityDataIaqiIndicator {
    private Float v;

    public CityDataIaqiIndicator() {
    }

    public Float getV() {
        return v;
    }

    public void setV(Float v) {
        this.v = v;
    }

    @Override
    public String toString() {
        return "CityDataIaqiIndicator{" +
                "v='" + v + '\'' +
                '}';
    }
}
