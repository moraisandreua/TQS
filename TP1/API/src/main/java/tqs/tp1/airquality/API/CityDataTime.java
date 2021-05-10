package tqs.tp1.airquality.API;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CityDataTime {
    private String s;
    private String tz;
    private Integer v;
    private String iso;

    public CityDataTime() {
    }

    public String getS() {
        return s;
    }

    public String getTz() {
        return tz;
    }

    public Integer getV() {
        return v;
    }

    public String getIso() {
        return iso;
    }

    public void setS(String s) {
        this.s = s;
    }

    public void setTz(String tz) {
        this.tz = tz;
    }

    public void setV(Integer v) {
        this.v = v;
    }

    public void setIso(String iso) {
        this.iso = iso;
    }

    @Override
    public String toString() {
        return "CityDataTime{" +
                "s='" + s + '\'' +
                ", tz='" + tz + '\'' +
                ", v=" + v +
                ", iso='" + iso + '\'' +
                '}';
    }
}
