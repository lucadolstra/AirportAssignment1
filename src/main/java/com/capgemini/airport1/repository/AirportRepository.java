package com.capgemini.airport1.repository;

import com.capgemini.airport1.model.Airport;
import org.springframework.data.repository.CrudRepository;

public interface AirportRepository extends CrudRepository<Airport, Long> {
}
