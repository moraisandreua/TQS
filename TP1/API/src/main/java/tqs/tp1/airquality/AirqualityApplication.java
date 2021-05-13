package tqs.tp1.airquality; // AirQualityController

import org.apache.log4j.BasicConfigurator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import tqs.tp1.airquality.API.CityResponse;

@SpringBootApplication
public class AirqualityApplication {

    private static final Logger log = LoggerFactory.getLogger(AirqualityApplication.class);

    public static void main(String[] args) {
        BasicConfigurator.configure();
        SpringApplication.run(AirqualityApplication.class, args);
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    @Bean
    public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
        log.info("Checking connection on startup");
        return args -> {
            CityResponse quote = restTemplate.getForObject(
                    "https://api.waqi.info/feed/Lisbon/?token=5c49ea620bd7657a43a14a9d17706172b71c38f4", CityResponse.class);

            if(quote != null)
                log.info(quote.toString());
            else
                log.info("Error creating object");
        };
    }
}
