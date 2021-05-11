package tqs.tp1.airquality; // AirQualityController

import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import redis.clients.jedis.Jedis;
import tqs.tp1.airquality.API.CityResponse;

import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@RequestMapping("/api/v1")
public class AirQualityController {
    Jedis jedis = connect();

    // lista de cidades que vão sendo encontradas
    @CrossOrigin(origins = "*")
    @GetMapping("/cities")
    public String getAllCities() {
        Set<String> cidades = jedis.keys("*");
        List<String> retorno = new ArrayList<>();

        for(String x : cidades)
            retorno.add("\"" + x + "\"");

        return retorno.toString();
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/city/{name}")
    public String getCity(@PathVariable(value = "name") String name) throws JSONException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        String dia_atual = formatter.format(date);

        String cache = jedis.get(name);
        if(cache==null){
            return callAPI(name);
        }else{
            JSONObject obj = new JSONObject(cache);
            JSONObject temp = (JSONObject) obj.getJSONObject("data").getJSONObject("forecast").getJSONObject("daily").getJSONArray("o3").get(0);
            String last_day = temp.getString("day");

            System.out.println(last_day + " / " + dia_atual);
            if(last_day.equals(dia_atual))
                return cache;
            else
                return callAPI(name);
        }
    }

    public Jedis connect(){
        try {
            Jedis jedis = new Jedis("localhost");
            // prints out "Connection Successful" if Java successfully connects to Redis server.
            System.out.println("Connection Successful");
            System.out.println("The server is running " + jedis.ping());
            return jedis;
        }catch(Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public String callAPI(String name){
        RestTemplate restTemplate = new RestTemplate();
        CityResponse quote = restTemplate.getForObject( "https://api.waqi.info/feed/"+name+"/?token=5c49ea620bd7657a43a14a9d17706172b71c38f4", CityResponse.class);
        jedis.set(name, quote.toString());
        return quote.toString();
    }
}