package com.onwelo.presentation.junit5;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

@BeerTest
class SaveBeerTest {

    @Autowired
    private BeerRepository beerRepository;

    private MockMvc mockMvc;

    @BeforeEach
    void setUpMockMvc(WebApplicationContext context) {
        this.mockMvc = webAppContextSetup(context).build();
    }

    @AfterEach
    void cleanDB() {
        beerRepository.deleteAll();
    }

    @Test
    void saveBeer_shouldSucceed() throws Exception {
        this.mockMvc.perform(
                post("/beer")
                        .contentType(MediaType.APPLICATION_JSON_UTF8)
                        .content("{     \"name\": \"Farmer\",     \"brand\": \"Brokreacja\" }"))
                .andExpect(status().isOk());

        Assertions.assertEquals(beerRepository.count(), 1);
    }

    @ParameterizedTest(name = "{index}. Should add product")
    @ValueSource(strings = {
            "{     \"name\": \"Farmer\",     \"brand\": \"Brokreacja\" }",
            "{     \"name\": \"Sweet Cow\",     \"brand\": \"Ale Browar\" }",
            "{     \"name\": \"Tyskie\",     \"brand\": \"Tyskie Browary Ksiazece\" }"
    })
    void saveBeer_shouldSucceed(String json) throws Exception {
        this.mockMvc.perform(
                post("/beer")
                        .contentType(MediaType.APPLICATION_JSON_UTF8)
                        .content(json))
                .andExpect(status().isOk());

        Assertions.assertEquals(beerRepository.count(), 1);
    }
}
