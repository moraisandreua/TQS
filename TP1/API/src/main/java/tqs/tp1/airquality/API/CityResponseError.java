package tqs.tp1.airquality.API;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CityResponseError {

    private String status;
    private String data;

    public CityResponseError() {
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() { return status; }

    public void setData(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }

    @Override
    public String toString() {
        return "{\"status\":\""+status+"\", \"data\": \""+data+"\"}";
    }
}
