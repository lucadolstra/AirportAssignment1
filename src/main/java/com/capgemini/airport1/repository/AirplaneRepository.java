package com.capgemini.airport1.repository;

import com.capgemini.airport1.model.Airplane;
import org.springframework.data.repository.CrudRepository;

public interface AirplaneRepository extends CrudRepository<Airplane, Long> {
}
