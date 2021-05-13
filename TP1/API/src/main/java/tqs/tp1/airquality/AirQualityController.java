package tqs.tp1.airquality; // AirQualityController

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import redis.clients.jedis.Jedis;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.List;
import org.apache.log4j.Logger;

@RestController
@RequestMapping("/api/v1")
public class AirQualityController {

    static final String KEY_ERRORS="_errors";
    static final String KEY_REQUESTS="_requests";

    Jedis jedis = Utils.connect();

    static Logger log = Logger.getLogger(AirQualityController.class.getName());

    // lista de cidades que vão sendo encontradas
    // é chamado de cada vez que alguem entra na página web
    @CrossOrigin(origins = "*")
    @GetMapping(value = "/cities", produces = MediaType.APPLICATION_JSON_VALUE)
    public String getAllCities() {
        Set<String> cidades = jedis.keys("*");
        List<String> retorno = new ArrayList<>();

        for(String x : cidades)
            if(new Utils(x).checkName())
                retorno.add("\"" + x + "\"");

        return retorno.toString();
    }

    @CrossOrigin(origins = "*")
    @GetMapping(value="/city/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
    public String getCity(@PathVariable(value = "name") String name) throws JSONException {
        long startTime = System.nanoTime() / 1000000;

        Utils utils = new Utils(name);

        if(!utils.checkName())
            return "{\"status\":\"error\", \"data\":\"invalid search\"}";

        String retorno = utils.getJson();

        long endTime = System.nanoTime() / 1000000;
        long timeElapsed=endTime - startTime;

        jedis.lpush("_elapsedTime", String.valueOf(timeElapsed));
        return retorno;
    }

    @CrossOrigin(origins = "*")
    @GetMapping(value="/city/{name}/{date}", produces = MediaType.APPLICATION_JSON_VALUE)
    public String getCityAndDate(@PathVariable(value = "name") String name, @PathVariable(value = "date") String date) throws JSONException {
        return "";
    }

    @CrossOrigin(origins = "*")
    @GetMapping(value="/logs", produces = MediaType.APPLICATION_JSON_VALUE)
    public String getLogs(){
        // requests
        Set<String> request = jedis.keys("*"+KEY_REQUESTS);
        List<String> requestList = new ArrayList<>();
        requestList.add("[\"Requests\", \"Searches per city\"]");
        for(String x : request)
            if(x.contains(KEY_REQUESTS))
                requestList.add("[\""+x.replace(KEY_REQUESTS, "")+"\", "+Integer.valueOf(jedis.get(x))+"]");

        //errors
        Set<String> error = jedis.keys("*" + KEY_ERRORS);
        List<String> errorList = new ArrayList<>();
        errorList.add("[\"Errors\", \"Failed searches per city\"]");
        for(String x : error)
            if(x.contains(KEY_ERRORS))
                errorList.add("[\""+x.replace(KEY_ERRORS, "")+"\", "+Integer.valueOf(jedis.get(x))+"]");

        // elapsed time
        List<String> elTime = jedis.lrange("_elapsedTime", 0, 15);
        List<String> elTimeList = new ArrayList<>();
        elTimeList.add("[\"x\", \"Elapsed Time (ms)\"]");
        int counter=0;
        for(int i=elTime.size()-1; i>=0; i--){
            elTimeList.add("["+counter+", "+elTime.get(i)+"]");
            counter++;
        }

        return "{\"requests\": "+requestList+", \"errors\": "+errorList+", \"elapsed_time\":"+elTimeList+"}";
    }
}