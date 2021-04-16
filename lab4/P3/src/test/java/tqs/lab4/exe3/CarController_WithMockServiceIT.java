package tqs.lab4.exe3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.internal.verification.VerificationModeFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CarController.class)
public class CarController_WithMockServiceIT {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private CarManagerService service;

    @BeforeEach
    public void setUp() throws Exception {
    }

    @Test
    public void whenPostCar_thenCreateCar( ) throws Exception {
        Car alex = new Car("Sierra 2.3 Diesel", "Ford");

        //given(service.save(Mockito.any())).willReturn(alex);
        when( service.save(Mockito.any()) ).thenReturn( alex);

        mvc.perform(post("/api/cars").contentType(MediaType.APPLICATION_JSON).content(JsonUtil.toJson(alex)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.model", is("Sierra 2.3 Diesel")));

        verify(service, times(1)).save(Mockito.any());
    }

    @Test
    public void givenCars_whenGetCars_thenReturnJsonArray() throws Exception {
        Car ford = new Car("Sierra 2.3 Diesel", "Ford");
        Car volkswagen = new Car("T-Roc", "Volkswagen");
        Car mercedes = new Car("CLS 320", "Mercedes");

        List<Car> allCars = Arrays.asList(ford, volkswagen, mercedes);

        given(service.getAllCars()).willReturn(allCars);

        mvc.perform(get("/api/cars").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk()).andExpect(jsonPath("$", hasSize(3))).andExpect(jsonPath("$[0].model", is(ford.getModel()))).andExpect(jsonPath("$[1].model", is(volkswagen.getModel())))
                .andExpect(jsonPath("$[2].model", is(mercedes.getModel())));
        verify(service, VerificationModeFactory.times(1)).getAllCars();
    }
}
