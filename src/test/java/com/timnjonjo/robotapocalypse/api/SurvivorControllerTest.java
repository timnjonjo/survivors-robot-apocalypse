package com.timnjonjo.robotapocalypse.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.timnjonjo.robotapocalypse.models.FlagSurvivorRequest;
import com.timnjonjo.robotapocalypse.models.SurvivorData;
import com.timnjonjo.robotapocalypse.models.SurvivorResourceData;
import com.timnjonjo.robotapocalypse.persistence.entities.Location;
import com.timnjonjo.robotapocalypse.persistence.entities.Survivor;
import com.timnjonjo.robotapocalypse.persistence.repositories.SurvivorRepository;
import com.timnjonjo.robotapocalypse.utils.Helper;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author TMwaura on 02/06/2022
 * @Project robot-apocalypse
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@AutoConfigureMockMvc
class SurvivorControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private SurvivorRepository repository;

    @Before
    public void setup() {
        repository.deleteAll();
    }

    ObjectMapper mapper = Helper.objectMapper();

    @Test
    void createSurvivor() throws Exception {

        SurvivorData survivor = SurvivorData.builder()
                .fullname("Sir Njonjo")
                .gender("Female")
                .nationalId("30015987")
                .resources(List.of(SurvivorResourceData.builder().name("Food").quantity("One Bag").build()))
                .lastLocation(new Location(BigDecimal.valueOf(20.7), BigDecimal.valueOf(20.7)))
                .build();
        mockMvc.perform(post("/v1/api/survivor")
                        .contentType("application/json")
                        .content(mapper.writeValueAsString(survivor)))
                .andDo(print())
                .andExpect(status().isCreated());
    }

    @Test
    void reportSurvivorContamination() throws Exception {
        SurvivorData survivorData = SurvivorData.builder()
                .fullname("Sir Njonjo")
                .gender("Female")
                .nationalId("30015987")
                .resources(List.of(SurvivorResourceData.builder().name("Food").quantity("One Bag").build()))
                .lastLocation(new Location(BigDecimal.valueOf(20.7), BigDecimal.valueOf(20.7)))
                .build();

        Survivor survivor =  this.repository.save(survivorData.transform());



        mockMvc.perform(post("/v1/api/survivor/report-contamination")
                        .contentType("application/json")
                        .content(mapper.writeValueAsString(new FlagSurvivorRequest(survivor.getId()))))
                .andDo(print())
                .andExpect(status().isAccepted());


    }

    @Test
    void updateSurvivorLocation() {
    }
}