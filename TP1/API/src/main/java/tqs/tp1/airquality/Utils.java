package tqs.tp1.airquality;

import org.springframework.web.client.RestTemplate;
import redis.clients.jedis.Jedis;
import tqs.tp1.airquality.API.CityResponse;
import tqs.tp1.airquality.API.CityResponseError;

public class Utils {
    private String name;
    static Jedis jedis = connect();

    public Utils(String name){
        this.name=name.toLowerCase();
    }

    public String callAPI(){
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

    public boolean checkName(){
        if(name.contains("_requests") || name.contains("_errors")){
            return false;
        }
        return true;
    }

    public boolean getCacheUpdate(){
        // verifica se já passou um dia desde o ultimo pedido acedido à db
        return System.currentTimeMillis() - Long.valueOf(jedis.get(name.toLowerCase() + "_lastcheck")) > 3600000;
    }

    public static Jedis connect(){
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
}
