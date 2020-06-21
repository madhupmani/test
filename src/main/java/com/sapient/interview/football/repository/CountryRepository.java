package com.sapient.interview.football.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sapient.interview.football.entity.CountryEntity;

@Repository
public interface CountryRepository extends JpaRepository<CountryEntity,Integer> {
	boolean existsByName(String name);
	
}
