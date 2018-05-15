package com.capgemini.airport1.controller;

import com.capgemini.airport1.model.Airport;
import com.capgemini.airport1.repository.AirportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("api/airport/")
public class AirportController {


    private ArrayList<Airport> airports = new ArrayList<Airport>();
    private Airport dummyAirport = new Airport();

    @Autowired
    private AirportRepository airportRepository;

    //Get all airplanes
    @GetMapping("all")
    public Iterable<Airport> getAllAirports() {

        dummyAirport.setName("Test Airport");

        airportRepository.save(dummyAirport);
        return airportRepository.findAll();
    }


    //Find specific airplane with this id
    @GetMapping("{id}")
    public ResponseEntity<Airport> findById(@PathVariable long id) {

        Optional<Airport> optionalAirport= this.airportRepository.findById(id);
        if (optionalAirport.isPresent()) {
            return new ResponseEntity<Airport>(optionalAirport.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<Airport>(HttpStatus.NOT_FOUND);
        }
    }


    @PostMapping("/add/")
    public Airport addAirport(@RequestBody Airport airport) {

        System.out.println("The new airport in repo: " + airport.getName());
        return airportRepository.save(airport);
    }


}
