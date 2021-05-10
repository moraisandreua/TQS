package tqs.tp1.airquality.API;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CityDataCity {
    private List<Float> geo;
    private String name;
    private String url;

    public CityDataCity() {
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
        return "CityDataCity{" +
                "geo=" + geo +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
