package tqs.tp1.airquality;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.junit.jupiter.inheritance.RedisContainer;
import tqs.tp1.airquality.api.CityResponse;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Testcontainers
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class JedisUnitTests {

    @Container
    private RedisContainer underTest = new RedisContainer("localhost", 6379);

    @BeforeEach
    public void setUp(){
        underTest.getJedis().set("tokio", "{\"status\":\"error\", \"data\":\"No city with that name\"}");
        underTest.getJedis().set("braga", "{\"status\":\"ok\", \"data\": {\"aqi\":27, \"idx\":8379}}");
        underTest.getJedis().set("braga_lastcheck", String.valueOf(System.currentTimeMillis()));
    }

    @AfterEach
    public void resetDb() {
        underTest.getJedis().del("tokio");
    }

    @Test
    void testGetKey(){
        String gotTokio = underTest.getJedis().get("tokio");

        assertEquals("{\"status\":\"error\", \"data\":\"No city with that name\"}", gotTokio);

        Long braga_lastcheck = Long.valueOf(underTest.getJedis().get("braga_lastcheck"));

        assertTrue(System.currentTimeMillis() > braga_lastcheck);

        assertTrue(System.currentTimeMillis() - braga_lastcheck < 3600000);
    }

    @Test
    void testParseJson_fromRedis() throws JsonProcessingException {
        String braga = underTest.getJedis().get("braga");

        CityResponse braga_cr = new ObjectMapper().readValue(braga, CityResponse.class);

        assertThat(braga_cr.getData().getAqi(), is(27));
    }
}
