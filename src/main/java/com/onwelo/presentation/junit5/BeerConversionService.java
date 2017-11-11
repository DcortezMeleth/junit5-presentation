package com.onwelo.presentation.junit5;

import org.springframework.stereotype.Service;

@Service
class BeerConversionService {

    long getAlcInMg(Beer beer) {
        return Math.round(beer.getVolume() * beer.getAlcohol() / 100);
    }

    long getPlatoFromGravity(double sg) {
        if(sg < 1.0 || sg > 1.2) {
            throw new IllegalArgumentException("Invalid value for beer Standard Gravity");
        }
        return Math.round((-1 * 616.868) + (1111.14 * sg) - (630 * Math.pow(sg, 2)) + (135.997 * Math.pow(sg, 3)));
    }

    boolean isSupportedUnit(GravityUnit unit) {
        return unit != GravityUnit.BRIX;
    }
}
