package com.onwelo.presentation.junit5;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
interface BeerRepository extends PagingAndSortingRepository<Beer, Long> {

    List<Beer> findAll();

    List<Beer> getBeerByBeerType(BeerType beerType);
}
