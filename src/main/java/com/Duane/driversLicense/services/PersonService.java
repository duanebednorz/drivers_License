package com.Duane.driversLicense.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.Duane.driversLicense.models.License;
import com.Duane.driversLicense.models.Person;
import com.Duane.driversLicense.repositories.LicenseRepository;
import com.Duane.driversLicense.repositories.PersonRepository;

@Service
public class PersonService {

	private PersonRepository personRepo;
	private LicenseRepository licenseRepo;
	
	public PersonService(PersonRepository personRepo, LicenseRepository licenseRepo) {
		this.personRepo = personRepo;
		this.licenseRepo = licenseRepo;
	}
	
	public Person create(Person toCreate) {
		return personRepo.save(toCreate);
	}
	
	public License create(License toCreate) {
		return licenseRepo.save(toCreate);
	}
	
	public List<License> getAllLicenses(){
		return (List<License>) licenseRepo.findAll();
	}
	
	public List<Person> getAllPeople(){
		return (List<Person>) personRepo.findAll();
	}
	
	public Person findPerson(Long id) {
        Optional<Person> optionalSong = this.personRepo.findById(id);
        if(optionalSong.isPresent()) {
            return optionalSong.get();
        } else {
            return null;
        }
    }
}
