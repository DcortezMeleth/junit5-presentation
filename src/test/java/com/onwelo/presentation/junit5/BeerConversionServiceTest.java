package com.onwelo.presentation.junit5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.stream.Stream;

@BeerTest
class BeerConversionServiceTest {

    @DisplayName("Should get exception on invalid standard gravity value")
    @ParameterizedTest(name = "Should fail on value {0}")
    @ValueSource(doubles = {-1.0, 0.99, 1.21, 9999.99})
    void getExceptionOnIllegalSg(double sg, @Autowired BeerConversionService beerConversionService) {
        Throwable throwable = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            beerConversionService.getPlatoFromGravity(sg);
        });

        Assertions.assertEquals(throwable.getMessage(), "Invalid value for beer Standard Gravity");
    }

    @DisplayName("Convert standard gravity to plato")
    @ParameterizedTest(name = "Standard gravity of {0} should be {1} plato degrees")
    @CsvSource(value = {
            "1.004, 1",
            "1.024, 6",
            "1.159, 36",
            "1.179, 40"
    })
    void getPlatoBasedOnStandardGravity(double sg, long plato, @Autowired BeerConversionService beerConversionService) {
        Assertions.assertEquals(beerConversionService.getPlatoFromGravity(sg), plato);
    }

    @DisplayName("Convert standard gravity to plato - data from file")
    @ParameterizedTest(name = "Standard gravity of {0} should be {1} plato degrees")
    @CsvFileSource(resources = "/standardGravityToPlato.csv")
    void getPlatoBasedOnStandardGravityUsingFile(double sg, long plato, @Autowired BeerConversionService beerConversionService) {
        Assertions.assertEquals(beerConversionService.getPlatoFromGravity(sg), plato);
    }

    @DisplayName("Should support gravity type")
    @ParameterizedTest(name = "Should support unit {0}")
    @EnumSource(value = GravityUnit.class, names = {"BALLING", "PLATO"})
    void shouldSupportUnit(GravityUnit unit, @Autowired BeerConversionService beerConversionService) {
        Assertions.assertTrue(beerConversionService.isSupportedUnit(unit));
    }

    @DisplayName("Get alcohol content of a beer in mg")
    @ParameterizedTest(name = "Alcohol content of {0} should be equal to {1}")
    @MethodSource("createBeers")
    void getAlcInMg(Beer beer, long mg, @Autowired BeerConversionService beerConversionService) {
        Assertions.assertEquals(beerConversionService.getAlcInMg(beer), mg);
    }

    private static Stream<Arguments> createBeers() {
        return Stream.of(
                Arguments.of(new Beer("Sweet Cow", "AleBrowar", BeerType.ALE, 500, 5.5), 28L),
                Arguments.of(new Beer("Bommen und Granaten", "Brouwerij De Molen", BeerType.ALE, 330, 12), 40L),
                Arguments.of(new Beer("Baltic Abbyss", "SoliPiwko", BeerType.LAGER, 500, 10), 50L)
        );
    }
}
