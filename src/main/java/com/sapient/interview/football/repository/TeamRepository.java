package com.sapient.interview.football.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sapient.interview.football.entity.TeamEntity;

@Repository
public interface TeamRepository extends JpaRepository<TeamEntity,Integer> {
	boolean existsByName(String name);
	
}
