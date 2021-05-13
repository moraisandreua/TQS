package tqs.tp1.airquality.API;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CityResponse {

    private String status;
    private CityData data;

    public CityResponse() {
        /*
        // GERADO AUTOMATICAMENTE PELO PARSER JSON
         */
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setData(CityData data) {
        this.data = data;
    }

    public CityData getData() {
        return data;
    }

    @Override
    public String toString() {
        return "{\"status\":\""+status+"\", \"data\":"+data.toString()+"}";
    }
}
