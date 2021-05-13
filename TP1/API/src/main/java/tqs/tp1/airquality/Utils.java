package tqs.tp1.airquality;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import redis.clients.jedis.Jedis;
import tqs.tp1.airquality.API.CityResponse;
import tqs.tp1.airquality.API.CityResponseError;

public class Utils {

    static Logger log = Logger.getLogger(Utils.class.getName());
    static final String KEY_ERRORS="_errors";
    static final String KEY_LASTCHECK="_lastcheck";
    static final String KEY_REQUESTS="_requests";
    private String name;
    static Jedis jedis = connect();

    private AirQualityResolver airQualityResolver=new AirQualityResolver();

    public Utils(){
        BasicConfigurator.configure();
    }

    public Utils(String name){
        BasicConfigurator.configure();
        this.name=name.toLowerCase();
    }

    public void setName(String name){
        this.name=name.toLowerCase();
    }

    public String getName(){
        return this.name;
    }

    public String callAPI(){
        String retorno="";
        try{
            CityResponse quote = airQualityResolver.findResultForName(name);
            jedis.set(name.toLowerCase() + KEY_LASTCHECK, String.valueOf(System.currentTimeMillis()));
            retorno= quote.toString();
        }catch(Exception e){
            CityResponseError quote = null;
            try {
                quote = airQualityResolver.findErrorForName(name);

                retorno= quote.toString();
            }catch(Exception e2){
                retorno="{\"status\":\"error\", \"data\":\"Error on that place\"}";
            }
            String erros = jedis.get(name.toLowerCase()+KEY_ERRORS);

            if(erros==null)
                jedis.set(name.toLowerCase()+KEY_ERRORS, "1");

        }

        jedis.set(name.toLowerCase(), retorno);
        return retorno;
    }

    public boolean checkName(){
        return (!name.contains(KEY_REQUESTS) && !name.contains(KEY_ERRORS) && !name.contains(KEY_LASTCHECK) && !name.equals("_elapsedTime"));
    }

    public boolean getCacheUpdate(){
        // verifica se já passou um dia desde o ultimo pedido acedido à db
        return System.currentTimeMillis() - Long.valueOf(jedis.get(name.toLowerCase() + KEY_LASTCHECK)) > 3600000;
    }

    public static Jedis connect(){
        try (Jedis jedisNew = new Jedis("localhost")){
            log.info("The server is running " + jedisNew.ping());
            log.info("Connection Successful");
            return jedisNew;
        }catch(Exception e) {
            log.info(e);
        }
        return null;
    }
}
