package com.onwelo.presentation.junit5;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
class BeerServiceImpl implements BeerService {

    @Autowired
    private BeerRepository beerRepository;

    @Autowired
    private SendingEmailService sendingEmailService;

    @Override
    public Iterable<Beer> getAllBeers() {
        return beerRepository.findAll();
    }

    @Override
    @Transactional(rollbackFor = NewsletterSendingException.class)
    public void addBeer(Beer beer) throws NewsletterSendingException {
        beerRepository.save(beer);
        sendingEmailService.sandEmailToSubscribedCustomers();
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
