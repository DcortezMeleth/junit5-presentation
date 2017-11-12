package com.onwelo.presentation.junit5;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

@BeerTest
class SaveBeerTest {

    @Autowired
    private BeerRepository beerRepository;

    @AfterEach
    void cleanDB() {
        beerRepository.deleteAll();
    }

    @Nested
    class WorkingRight {

        private BeerService beerService = new BeerServiceImpl(beerRepository, new SendingEmailServiceImpl());

        @Test
        void saveBeer_shouldSucceed() throws Exception {
            Beer beer = new Beer("name", "brand", BeerType.ALE, 500, 4.5);
            beerService.addBeer(beer);
            Assertions.assertEquals(beerRepository.count(), 1);
        }
    }

    @Nested
    class ThrowingException {

        private BeerService beerService = new BeerServiceImpl(beerRepository, new ExceptionThrowingSendingEmailService());

        @Test
        void saveBeer_shouldFailAndRollbackTransaction() {
            Beer beer = new Beer("name", "brand", BeerType.ALE, 500, 4.5);
            Assertions.assertThrows(NewsletterSendingException.class, () -> {
                beerService.addBeer(beer);
            });
        }
    }
}
