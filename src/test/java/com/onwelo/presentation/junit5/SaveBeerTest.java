package com.onwelo.presentation.junit5;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;

@BeerTest
@DisplayName("Beer saving tests")
class SaveBeerTest {

    @Autowired
    private BeerRepository beerRepository;

    @AfterEach
    void cleanDB() {
        beerRepository.deleteAll();
    }

    @Nested
    @DisplayName("Saving fine")
    class WorkingRight {

        private BeerService beerService = new BeerServiceImpl(beerRepository, new SendingEmailServiceImpl());

        @Test
        @DisplayName("Should succeed saving beer")
        void saveBeer_shouldSucceed() throws Exception {
            Beer beer = new Beer("name", "brand", BeerType.ALE, 500, 4.5);
            beerService.addBeer(beer);
            Assertions.assertEquals(beerRepository.count(), 1);
        }
    }

    @Nested
    @DisplayName("Simulating exceptions")
    class ThrowingException {

        private BeerService beerService = new BeerServiceImpl(beerRepository, new ExceptionThrowingSendingEmailService());

        @Test
        @DisplayName("Should fail saving beer")
        void saveBeer_shouldFailAndRollbackTransaction() {
            Beer beer = new Beer("name", "brand", BeerType.ALE, 500, 4.5);
            Assertions.assertThrows(NewsletterSendingException.class, () -> {
                beerService.addBeer(beer);
            });
        }
    }
}
