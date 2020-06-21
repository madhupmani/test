package com.sapient.interview.football.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sapient.interview.football.entity.LeagueEntity;

@Repository
public interface LeagueRepository extends JpaRepository<LeagueEntity,Integer> {
	boolean existsByName(String name);
	
}
