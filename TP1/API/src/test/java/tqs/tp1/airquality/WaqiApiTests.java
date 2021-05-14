package tqs.tp1.airquality;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.client.RestTemplate;
import tqs.tp1.airquality.api.*;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.mockito.ArgumentMatchers.contains;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class WaqiApiTests {
    @Mock
    RestTemplate restTemplate;

    RestTemplate restTemplate2=new RestTemplate();

    @InjectMocks
    AirQualityResolver resolver;

    static Logger log = Logger.getLogger(Utils.class.getName());

    @Test
    void whenCorrectPlace_returnAirQuality() throws JsonProcessingException {
        CityResponse cr = restTemplate2.getForObject( "https://api.waqi.info/feed/Porto/?token=5c49ea620bd7657a43a14a9d17706172b71c38f4", CityResponse.class);
        log.fatal(cr.toString());
        assertThat(cr.getData().getCity().getName(), is("Sobreiras-Lordelo do Ouro, Porto, Portugal"));
    }

    @Test
    void whenGeo_returnAirQuality() throws JsonProcessingException {
        CityResponse cr = restTemplate2.getForObject( "https://api.waqi.info/feed/geo:41.1475;-8.6588888888889/?token=5c49ea620bd7657a43a14a9d17706172b71c38f4", CityResponse.class);
        log.fatal(cr.toString());
        assertThat(cr.getData().getCity().getName(), is("Sobreiras-Lordelo do Ouro, Porto, Portugal"));
    }

    @Test
    void whenWrongPlace_throwIncorrectName() {
        CityResponseError result=null;
        when(restTemplate.getForObject(contains("/feed/Coimbra/"), eq(CityResponseError.class))).thenThrow(IndexOutOfBoundsException.class);


        try{
            result = resolver.findErrorForName("Coimbra");
        }catch(Exception e){
            log.fatal("Coimbra does not exists");
        }

        assertThat(result, is(nullValue()));
    }
}
