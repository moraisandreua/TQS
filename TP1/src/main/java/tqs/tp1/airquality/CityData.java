package tqs.tp1.airquality;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CityData {
    private Integer aqi;
    private Integer idx;
    private List<CityDataAttribution> attributions;
    private CityDataCity city;
    private String dominentpol;
    private CityDataIaqi iaqi;

    public CityData() {
    }

    public void setAqi(Integer aqi) {
        this.aqi = aqi;
    }

    public void setIdx(Integer idx) {
        this.idx = idx;
    }

    public void setAttributions(List<CityDataAttribution> attributions) {
        this.attributions = attributions;
    }

    public Integer getAqi() {
        return aqi;
    }

    public Integer getIdx() {
        return idx;
    }

    public List<CityDataAttribution> getAttributions() {
        return attributions;
    }

    public CityDataCity getCity() {
        return city;
    }

    public void setCity(CityDataCity city) {
        this.city = city;
    }

    public String getDominentpol() {
        return dominentpol;
    }

    public CityDataIaqi getIaqi() {
        return iaqi;
    }

    public void setDominentpol(String dominentpol) {
        this.dominentpol = dominentpol;
    }

    public void setIaqi(CityDataIaqi iaqi) {
        this.iaqi = iaqi;
    }

    @Override
    public String toString() {
        return "CityData{" +
                "aqi=" + aqi +
                ", idx=" + idx +
                ", attributions=" + attributions +
                ", city=" + city +
                ", dominentpol='" + dominentpol + '\'' +
                ", iaqi=" + iaqi +
                '}';
    }
}
