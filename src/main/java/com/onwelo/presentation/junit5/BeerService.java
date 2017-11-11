package com.onwelo.presentation.junit5;

import java.util.List;

interface BeerService {

    Iterable<Beer> getAllBeers();

    void addBeer(Beer beer) throws NewsletterSendingException;

    Beer getBeer(long beerId);

    List<Beer> getBeersByType(BeerType beerType);
}
