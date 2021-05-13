package tqs.tp1.airquality;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import redis.clients.jedis.Jedis;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = AirqualityApplication.class)
@AutoConfigureMockMvc
class AirQualityAPITests {
    @Autowired
    private MockMvc mvc;

    @MockBean
    Utils utils;

    Jedis jedis;

    @BeforeEach
    void setup(){
        jedis=utils.connect();
    }

    @Test
    public void whenStart_thenReturnCities() throws Exception {

        jedis.set("mexico", "{\"status\":\"error\", \"data\":\"Unknown station\"}");
        jedis.set("tokio", "{\"status\":\"error\", \"data\":\"Unknown station\"}");

        mvc.perform(get("/api/v1/cities").contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
                //.andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                //.andExpect(jsonPath("$", hasSize(greaterThanOrEqualTo(2))))
                //.andExpect(jsonPath("$[1]", is("mexico"))); // porque o LPUSH insere à esquerda. Logo, como mexico foi o primeiro a ser inserido, vai estar na segunda posição
    }

    @Test
    public void whenSearch_thenReturnCity() throws Exception{

        mvc.perform(get("/api/v1/city/Porto").contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.status", is("ok")))
                .andExpect(jsonPath("$.data.city.name", is("Sobreiras-Lordelo do Ouro, Porto, Portugal")));
    }



}
