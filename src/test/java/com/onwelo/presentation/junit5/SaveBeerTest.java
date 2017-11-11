package com.onwelo.presentation.junit5;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;

@BeerTest
class SaveBeerTest {
/*
    @Autowired
    private BeerRepository beerRepository;

    @AfterEach
    void cleanDB() {
        beerRepository.deleteAll();
    }

    @Nested
    class WorkingRight {

        @Autowired
        private BeerService beerService;

        @Test
        void saveBeer_shouldSucceed(@Mock Beer beer) throws Exception {
            beerService.addBeer(beer);
            Assertions.assertEquals(beerRepository.count(), 1);
        }
    }

    @Nested
    class ThrowingException {

        @Autowired
        private BeerService beerService;

        @Test
        void saveBeer_shouldFailAndRollbackTransaction(@Mock Beer beer) throws Exception {
            beerService.addBeer(beer);
            Assertions.assertEquals(beerRepository.count(), 0);
        }
    }*/
}
