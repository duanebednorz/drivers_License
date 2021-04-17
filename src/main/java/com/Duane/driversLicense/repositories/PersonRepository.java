package com.Duane.driversLicense.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.Duane.driversLicense.models.Person;

@Repository
public interface PersonRepository extends CrudRepository<Person, Long>{

}
