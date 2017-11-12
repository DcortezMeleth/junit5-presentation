package com.onwelo.presentation.junit5;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
class BeerServiceImpl implements BeerService {

    private BeerRepository beerRepository;

    private SendingEmailService sendingEmailService;

    @Override
    public Iterable<Beer> getAllBeers() {
        return beerRepository.findAll();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
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
