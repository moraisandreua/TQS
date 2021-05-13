package tqs.tp1.airquality.API;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CityDataIaqiIndicator {
    private Float v;

    public CityDataIaqiIndicator() {
        /*
        // GERADO AUTOMATICAMENTE PELO PARSER JSON
         */
    }

    public CityDataIaqiIndicator(Float value) {
        this.v=value;
    }

    public Float getV() {
        return v;
    }

    public void setV(Float v) {
        this.v = v;
    }

    @Override
    public String toString() {
        return v.toString();
    }
}
