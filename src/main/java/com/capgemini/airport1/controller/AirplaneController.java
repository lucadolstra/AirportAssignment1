package com.capgemini.airport1.controller;


import com.capgemini.airport1.model.Airplane;
import com.capgemini.airport1.repository.AirplaneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("api/airplane/")
public class AirplaneController {

    private ArrayList<Airplane> airplanes = new ArrayList<Airplane>();
    private Airplane dummyAirplane = new Airplane();

    @Autowired
    private AirplaneRepository airplaneRepository;

   //Get all airplanes
    @GetMapping("all")
    public Iterable<Airplane> getAllAirplanes() {

        dummyAirplane.setName("Test Plane");
        dummyAirplane.setLocation("Amsterdam");
        dummyAirplane.setFuel(5);
        airplaneRepository.save(dummyAirplane);
        return airplaneRepository.findAll();
    }


    //Find specific airplane with this id
    @GetMapping("{id}")
    public ResponseEntity<Airplane> findById(@PathVariable long id) {

        Optional<Airplane> optionalAirplane = this.airplaneRepository.findById(id);
        if (optionalAirplane.isPresent()) {
            return new ResponseEntity<Airplane>(optionalAirplane.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<Airplane>(HttpStatus.NOT_FOUND);
        }
    }



   //Add airplane with a name and a location
    @GetMapping("/add/{name}/{location}")
    public Airplane addAirplane(@PathVariable String name, @PathVariable String location) {
        Airplane airplane = new Airplane();
        airplane.setName(name);
        airplane.setLocation(location);
        airplane.setFuel(5);

        System.out.println(airplane);
        return airplaneRepository.save(airplane);
    }

    //Delete Airplane by ID
    @RequestMapping(value = "delete/{id}", method = RequestMethod.DELETE)
    public void deleteAirplane(@PathVariable long id) {
       // Airplane airplane = airplaneRepository.findOne(id);
        Optional<Airplane> airplane = airplaneRepository.findById(id);
        Airplane currentPlane = airplane.get();
        airplaneRepository.delete(currentPlane);
    }

   //Update airplane's values
    @PutMapping("{id}")
    // http://localhost:8080/api/airplane/{id}
    public ResponseEntity<Airplane> updateById(@PathVariable long id, @RequestBody Airplane airplane) {

        Optional<Airplane> optionalAirplane = this.airplaneRepository.findById(id);
        if (optionalAirplane.isPresent()) {
            Airplane currentAirplane = optionalAirplane.get();
            currentAirplane.setName(airplane.getName());
            currentAirplane.setFuel(airplane.getFuel());
            currentAirplane.setLocation(airplane.getLocation());


            return new ResponseEntity<Airplane>(this.airplaneRepository.save(currentAirplane), HttpStatus.OK);
        } else {
            return new ResponseEntity<Airplane>(HttpStatus.NOT_FOUND);
        }
    }

    //api/airplane/fly/{id}
    //if id is found, and there is more than 2 tons of fuel in the plane, the plane is updated.
    @PutMapping("/fly/{id}/{location}")
    public ResponseEntity<Airplane> flyById(@PathVariable long id, @PathVariable String location, @RequestBody Airplane airplane) {
        Optional<Airplane> optionalAirplane = this.airplaneRepository.findById(id);
        if (optionalAirplane.isPresent()) {
            Airplane currentAirplane = optionalAirplane.get();
            if (airplane.getFuel() - 2 >= 0) {
                currentAirplane.setFuel((airplane.getFuel() - 2));
                currentAirplane.setLocation(location);
                return new ResponseEntity<Airplane>(this.airplaneRepository.save(currentAirplane), HttpStatus.OK);
            } else {
                return new ResponseEntity<Airplane>(this.airplaneRepository.save(currentAirplane), HttpStatus.OK);
            }
        } else return new ResponseEntity<Airplane>(HttpStatus.NOT_FOUND);

    }

}
