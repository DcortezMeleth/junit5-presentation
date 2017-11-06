package com.onwelo.presentation.junit5;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping(value = "/beer")
class BeerController {

    @Autowired
    private BeerService beerService;

    @GetMapping
    Iterable<Beer> getAllBeers(@RequestParam("type") BeerType beerType) {
        if(beerType == null) {
            return beerService.getAllBeers();
        }

        return beerService.getBeersByType(beerType);
    }

    @PostMapping
    void addBeer(@RequestBody Beer beer) {
        beerService.addBeer(beer);
    }

    @GetMapping(value = "/{beerId}")
    ResponseEntity<Beer> getBeer(@PathVariable("beerId") long beerId) {
        Beer beer = beerService.getBeer(beerId);
        if(beer != null) {
            return ResponseEntity.ok(beer);
        }

        return ResponseEntity.notFound().build();
    }
}
