package tqs.tp1.airquality;

import org.springframework.web.client.RestTemplate;
import tqs.tp1.airquality.api.CityResponse;
import tqs.tp1.airquality.api.CityResponseError;

public class AirQualityResolver {

    RestTemplate restTemplate;

    public AirQualityResolver(){
        restTemplate = new RestTemplate();
    }

    public CityResponse findResultForName(String name){
        return restTemplate.getForObject( "https://api.waqi.info/feed/"+name+"/?token=5c49ea620bd7657a43a14a9d17706172b71c38f4", CityResponse.class);
    }

    public CityResponseError findErrorForName(String name){
        return restTemplate.getForObject( "https://api.waqi.info/feed/"+name+"/?token=5c49ea620bd7657a43a14a9d17706172b71c38f4", CityResponseError.class);
    }
}
