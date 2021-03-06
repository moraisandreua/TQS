package tqs.tp1.airquality.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CityDataCity {
    private List<Float> geo;
    private String name;
    private String url;

    public CityDataCity() {
        /*
        // GERADO AUTOMATICAMENTE PELO PARSER JSON
         */
    }

    public CityDataCity(List<Float> geo, String name, String url) {
        this.geo=geo;
        this.name=name;
        this.url=url;
    }

    public void setGeo(List<Float> geo) {
        this.geo = geo;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<Float> getGeo() {
        return geo;
    }

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }

    @Override
    public String toString() {
        return "{" +
                "\"geo\":" + geo +
                ", \"name\": \"" + name +
                "\", \"url\": \"" + url +
                "\"}";
    }
}
