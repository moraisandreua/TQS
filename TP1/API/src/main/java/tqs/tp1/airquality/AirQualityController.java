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
import tqs.tp1.airquality.API.CityResponseError;

import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@RequestMapping("/api/v1")
public class AirQualityController {
    Jedis jedis = Utils.connect();

    // lista de cidades que vão sendo encontradas
    // é chamado de cada vez que alguem entra na página web
    @CrossOrigin(origins = "*")
    @GetMapping("/cities")
    public String getAllCities() {
        Set<String> cidades = jedis.keys("*");
        List<String> retorno = new ArrayList<>();
        System.out.println(cidades);
        for(String x : cidades)
            if(new Utils(x).checkName())
                retorno.add("\"" + x + "\"");

        return retorno.toString();
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/city/{name}")
    public String getCity(@PathVariable(value = "name") String name) throws JSONException {
        long startTime = System.nanoTime() / 1000000;

        Utils utils = new Utils(name);

        if(!utils.checkName())
            return "{\"status\":\"error\", \"data\":\"invalid search\"}";

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        String dia_atual = formatter.format(date);

        String cache = jedis.get(name.toLowerCase());
        String retorno = "";
        if(cache==null){
            jedis.set(name.toLowerCase()+"_requests", "1");
            retorno= utils.callAPI();
        }else {
            // no caso de a cache ser erro
            if(jedis.get(name.toLowerCase()+"_errors") != null){
                jedis.incr(name.toLowerCase()+"_errors");
                jedis.incr(name.toLowerCase()+"_requests");
                return cache;
            }

            jedis.incr(name+"_requests");
            JSONObject obj = new JSONObject(cache);
            JSONObject temp = (JSONObject) obj.getJSONObject("data").getJSONObject("forecast").getJSONObject("daily").getJSONArray("o3").get(0);
            String last_day = temp.getString("day");


            if (last_day.equals(dia_atual))
                retorno= cache;
            else
                if(utils.getCacheUpdate())
                    retorno= utils.callAPI();
                else
                    retorno= cache;
        }

        long endTime = System.nanoTime() / 1000000;
        long timeElapsed=endTime - startTime;

        jedis.lpush("_elapsedTime", String.valueOf(timeElapsed));
        return retorno;
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/logs")
    public String getLogs(){
        // requests
        Set<String> request = jedis.keys("*_requests");
        List<String> request_list = new ArrayList<>();
        request_list.add("[\"Requests\", \"Searches per city\"]");
        for(String x : request)
            if(x.contains("_requests"))
                request_list.add("[\""+x.replace("_requests", "")+"\", "+Integer.valueOf(jedis.get(x))+"]");

        //errors
        Set<String> error = jedis.keys("*_errors");
        List<String> error_list = new ArrayList<>();
        error_list.add("[\"Errors\", \"Failed searches per city\"]");
        for(String x : error)
            if(x.contains("_errors"))
                error_list.add("[\""+x.replace("_errors", "")+"\", "+Integer.valueOf(jedis.get(x))+"]");

        // elapsed time
        List<String> elTime = jedis.lrange("_elapsedTime", 0, 15);
        List<String> elTime_list = new ArrayList<>();
        elTime_list.add("[\"x\", \"Elapsed Time (ms)\"]");
        int counter=0;
        for(int i=elTime.size()-1; i>=0; i--){
            elTime_list.add("["+counter+", "+elTime.get(i)+"]");
            counter++;
        }

        return "{\"requests\": "+request_list+", \"errors\": "+error_list+", \"elapsed_time\":"+elTime_list+"}";
    }

    /*public Jedis connect(){
        try {
            Jedis jedis = new Jedis("localhost");
            System.out.println("The server is running " + jedis.ping());
            System.out.println("Connection Successful");
            return jedis;
        }catch(Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public String callAPI(String name){
        RestTemplate restTemplate = new RestTemplate();
        String retorno="";
        try{
            CityResponse quote = restTemplate.getForObject( "https://api.waqi.info/feed/"+name+"/?token=5c49ea620bd7657a43a14a9d17706172b71c38f4", CityResponse.class);
            jedis.set(name.toLowerCase() + "_lastcheck", String.valueOf(System.currentTimeMillis()));
            retorno= quote.toString();
        }catch(Exception e){
            CityResponseError quote = null;
            try {
                quote = restTemplate.getForObject("https://api.waqi.info/feed/" + name + "/?token=5c49ea620bd7657a43a14a9d17706172b71c38f4", CityResponseError.class);

                retorno= quote.toString();
            }catch(Exception e2){
                retorno="{\"status\":\"error\", \"data\":\"Error on that place\"}";
            }
            String erros = jedis.get(name.toLowerCase()+"_errors");

            if(erros==null)
                jedis.set(name.toLowerCase()+"_errors", "1");

        }

        jedis.set(name.toLowerCase(), retorno);
        return retorno;
    }

    private boolean checkName(String name){
        String temp = name.toLowerCase();
        if(temp.contains("_requests") || temp.contains("_errors")){
            return false;
        }
        return true;
    }

    public boolean getCacheUpdate(String name){
        // verifica se já passou um dia desde o ultimo pedido acedido à db
        return System.currentTimeMillis() - Long.valueOf(jedis.get(name.toLowerCase() + "_lastcheck")) > 3600000;
    }*/
}