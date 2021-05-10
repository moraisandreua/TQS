package tqs.tp1.airquality.API;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CityDataAttribution {
    private String url;
    private String name;
    private String logo;

    public CityDataAttribution() {
    }

    public String getUrl() {
        return url;
    }

    public String getName() {
        return name;
    }

    public String getLogo() {
        return logo;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    @Override
    public String toString() {
        return "CityDataAttribution{" +
                "url='" + url + '\'' +
                ", name='" + name + '\'' +
                ", logo='" + logo + '\'' +
                '}';
    }
}