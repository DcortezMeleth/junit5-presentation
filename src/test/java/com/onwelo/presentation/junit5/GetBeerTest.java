package com.onwelo.presentation.junit5;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

@BeerTest
class GetBeerTest {

    @Autowired
    private BeerRepository beerRepository;

    private MockMvc mockMvc;

    @BeforeEach
    void init() {
        beerRepository.save(new Beer("Farmer", "Brokreacja", BeerType.LAGER));
        beerRepository.save(new Beer("Sweet Cow", "Brokreacja", BeerType.ALE));
        beerRepository.save(new Beer("Cop", "Brokreacja", BeerType.LAGER));
    }

    @BeforeEach
    void setUpMockMvc(WebApplicationContext context) {
        this.mockMvc = webAppContextSetup(context).build();
    }

    @AfterEach
    void cleanDB() {
        beerRepository.deleteAll();
    }

    @ParameterizedTest(name = "Should get {1} beers of type {2}")
    @CsvSource(value = {
            "LAGER, 2",
            "ALE, 1"
    })
    void getBeerByType(BeerType beerType, int count) throws Exception {
        this.mockMvc.perform(
                get("/beer")
                        .param("type", beerType.name()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(count)));
    }
}
