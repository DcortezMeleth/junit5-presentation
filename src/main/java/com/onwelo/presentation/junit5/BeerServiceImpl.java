package com.onwelo.presentation.junit5;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
class BeerServiceImpl implements BeerService {

    @Autowired
    private BeerRepository beerRepository;

    @Override
    public Iterable<Beer> getAllBeers() {
        return beerRepository.findAll();
    }

    @Override
    public void addBeer(Beer beer) {
        beerRepository.save(beer);
    }

    @Override
    public Beer getBeer(long beerId) {
        return beerRepository.findOne(beerId);
    }

    @Override
    public List<Beer> getBeersByType(BeerType beerType) {
        return beerRepository.getBeerByBeerType(beerType);
    }
}
