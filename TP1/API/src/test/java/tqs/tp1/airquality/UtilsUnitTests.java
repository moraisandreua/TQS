package tqs.tp1.airquality;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import tqs.tp1.airquality.api.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UtilsUnitTests {

    @Mock
    Utils utils;

    @BeforeEach
    void setup(){
        MockitoAnnotations.initMocks(this);
        utils.setName("braga");
        //ReflectionTestUtils.setField(utils, "name",  "braga"); // object to be injected
        utils.jedis.del("braga");
    }

    @Test
    void testCall_n_Parse() throws JsonProcessingException {

        assertNotNull(utils);

        String expected = "{\"status\":\"ok\",\"data\":{\"aqi\":85,\"idx\":8372,\"attributions\":[{\"url\":\"http://www.eea.europa.eu/themes/air/\",\"name\":\"European Environment Agency\",\"logo\":\"Europe-EEA.png\"},{\"url\":\"http://qualar.apambiente.pt/\",\"name\":\"Portugal -Agencia Portuguesa do Ambiente - Qualidade do Ar\",\"logo\":\"portugal-qualar.png\"},{\"url\":\"https://waqi.info/\",\"name\":\"World Air Quality Index Project\"}],\"city\":{\"geo\":[41.274166666667,-8.3761111111111],\"name\":\"Paços de Ferreira, Paços de Ferreira, Portugal\",\"url\":\"https://aqicn.org/city/portugal/pacos-de-ferreira/pacos-de-ferreira\"},\"dominentpol\":\"pm25\",\"iaqi\":{\"h\":{\"v\":74.4},\"o3\":{\"v\":41.9},\"p\":{\"v\":1018.6},\"pm10\":{\"v\":8},\"pm25\":{\"v\":85},\"t\":{\"v\":17.1},\"w\":{\"v\":12.4},\"wg\":{\"v\":12.4}},\"time\":{\"s\":\"2021-05-12 06:00:00\",\"tz\":\"+01:00\",\"v\":1620799200,\"iso\":\"2021-05-12T06:00:00+01:00\"},\"forecast\":{\"daily\":{\"o3\":[{\"avg\":32,\"day\":\"2021-05-10\",\"max\":36,\"min\":27},{\"avg\":32,\"day\":\"2021-05-11\",\"max\":39,\"min\":27},{\"avg\":34,\"day\":\"2021-05-12\",\"max\":37,\"min\":31},{\"avg\":32,\"day\":\"2021-05-13\",\"max\":39,\"min\":23},{\"avg\":32,\"day\":\"2021-05-14\",\"max\":42,\"min\":22},{\"avg\":33,\"day\":\"2021-05-15\",\"max\":33,\"min\":31}],\"pm10\":[{\"avg\":11,\"day\":\"2021-05-10\",\"max\":16,\"min\":6},{\"avg\":17,\"day\":\"2021-05-11\",\"max\":21,\"min\":11},{\"avg\":13,\"day\":\"2021-05-12\",\"max\":20,\"min\":6},{\"avg\":10,\"day\":\"2021-05-13\",\"max\":19,\"min\":6},{\"avg\":12,\"day\":\"2021-05-14\",\"max\":18,\"min\":8},{\"avg\":10,\"day\":\"2021-05-15\",\"max\":10,\"min\":9}],\"pm25\":[{\"avg\":25,\"day\":\"2021-05-10\",\"max\":34,\"min\":15},{\"avg\":29,\"day\":\"2021-05-11\",\"max\":38,\"min\":16},{\"avg\":26,\"day\":\"2021-05-12\",\"max\":35,\"min\":14},{\"avg\":23,\"day\":\"2021-05-13\",\"max\":45,\"min\":18},{\"avg\":32,\"day\":\"2021-05-14\",\"max\":53,\"min\":20},{\"avg\":25,\"day\":\"2021-05-15\",\"max\":25,\"min\":20}],\"uvi\":[{\"avg\":1,\"day\":\"2021-05-10\",\"max\":4,\"min\":0},{\"avg\":1,\"day\":\"2021-05-11\",\"max\":4,\"min\":0},{\"avg\":1,\"day\":\"2021-05-12\",\"max\":5,\"min\":0},{\"avg\":0,\"day\":\"2021-05-13\",\"max\":3,\"min\":0},{\"avg\":1,\"day\":\"2021-05-14\",\"max\":8,\"min\":0},{\"avg\":1,\"day\":\"2021-05-15\",\"max\":3,\"min\":0},{\"avg\":1,\"day\":\"2021-05-16\",\"max\":4,\"min\":0}]}},\"debug\":{\"sync\":\"2021-05-12T17:48:00+09:00\"}}}";
        when(utils.callAPI()).thenReturn(expected);

        CityResponse expectedCR = new CityResponse();
        CityData cd = new CityData();
        CityDataAttribution attrA = new CityDataAttribution("http://www.eea.europa.eu/themes/air/", "European Environment Agency", "Europe-EEA.png");
        CityDataAttribution attrB = new CityDataAttribution("http://qualar.apambiente.pt/", "Portugal -Agencia Portuguesa do Ambiente - Qualidade do Ar", "portugal-qualar.png");
        CityDataAttribution attrC = new CityDataAttribution("https://waqi.info/", "World Air Quality Index Project", "null");
        CityDataCity cdc = new CityDataCity(List.of( (float)41.274166666667, (float)-8.3761111111111), "Paços de Ferreira, Paços de Ferreira, Portugal", "https://aqicn.org/city/portugal/pacos-de-ferreira/pacos-de-ferreira");
        CityDataIaqi cdi = new CityDataIaqi();
        CityDataTime cdt = new CityDataTime("2021-05-12 06:00:00", "+01:00", 1620799200, "2021-05-12T06:00:00+01:00");

        cdi.setH(new CityDataIaqiIndicator((float)74.4));
        cdi.setO3(new CityDataIaqiIndicator((float)41.9));
        cdi.setP(new CityDataIaqiIndicator((float)1018.6));
        cdi.setPm10(new CityDataIaqiIndicator((float)8));
        cdi.setPm25(new CityDataIaqiIndicator((float)85));
        cdi.setT(new CityDataIaqiIndicator((float)17.1));
        cdi.setW(new CityDataIaqiIndicator((float)12.4));
        cdi.setWg(new CityDataIaqiIndicator((float)12.4));

        cd.setAqi(85);
        cd.setIdx(8372);
        cd.setAttributions(List.of(attrA, attrB, attrC));
        cd.setCity(cdc);
        cd.setDominentpol("pm25");
        cd.setIaqi(cdi);
        cd.setTime(cdt);
        cd.setForecast(
                new CityDataForecast(
                    new CityDataForecastDaily(
                            List.of(
                                    new CityDataForecastDailyIndicator(32, "2021-05-10", 36, 27),
                                    new CityDataForecastDailyIndicator(32, "2021-05-11", 39, 27),
                                    new CityDataForecastDailyIndicator(34, "2021-05-12", 37, 31),
                                    new CityDataForecastDailyIndicator(32, "2021-05-13", 39, 23),
                                    new CityDataForecastDailyIndicator(32, "2021-05-14", 42, 22),
                                    new CityDataForecastDailyIndicator(33, "2021-05-15", 33, 31)),
                            List.of(
                                    new CityDataForecastDailyIndicator(11, "2021-05-10", 16, 6),
                                    new CityDataForecastDailyIndicator(17, "2021-05-11", 21, 11),
                                    new CityDataForecastDailyIndicator(13, "2021-05-12", 20, 6),
                                    new CityDataForecastDailyIndicator(10, "2021-05-13", 19, 6),
                                    new CityDataForecastDailyIndicator(12, "2021-05-14", 18, 8),
                                    new CityDataForecastDailyIndicator(10, "2021-05-15", 10, 9)),
                            List.of(new CityDataForecastDailyIndicator(25, "2021-05-10", 34, 15),
                                    new CityDataForecastDailyIndicator(29, "2021-05-11", 38, 16),
                                    new CityDataForecastDailyIndicator(26, "2021-05-12", 35, 14),
                                    new CityDataForecastDailyIndicator(23, "2021-05-13", 45, 18),
                                    new CityDataForecastDailyIndicator(32, "2021-05-14", 53, 20),
                                    new CityDataForecastDailyIndicator(25, "2021-05-15", 25, 20)),
                            List.of(new CityDataForecastDailyIndicator(1, "2021-05-10", 4, 0),
                                    new CityDataForecastDailyIndicator(1, "2021-05-11", 4, 0),
                                    new CityDataForecastDailyIndicator(1, "2021-05-12", 5, 0),
                                    new CityDataForecastDailyIndicator(0, "2021-05-13", 3, 0),
                                    new CityDataForecastDailyIndicator(1, "2021-05-14", 8, 0),
                                    new CityDataForecastDailyIndicator(1, "2021-05-15", 3, 0),
                                    new CityDataForecastDailyIndicator(1, "2021-05-16", 4, 0)
                            )
                    )
                )
        );

        expectedCR.setStatus("ok");
        expectedCR.setData(cd);

        assertEquals(expectedCR.toString(), new ObjectMapper().readValue(utils.callAPI(), CityResponse.class).toString());
    }

    @Test
    void testUtils_Validators(){
        // valida o nome da cidade/pais
        assertTrue(!utils.checkName());

        // valida que a cache não precisa ser atualizada
        assertTrue(!utils.getCacheUpdate());
    }
}
