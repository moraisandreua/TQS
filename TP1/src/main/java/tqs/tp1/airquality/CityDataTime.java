package tqs.tp1.airquality;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CityDataTime {
    private String s;
    private String tz;
    private Integer v;
    private String iso;

    
}
