package com.sapient.interview.football.serviceImpl;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sapient.interview.football.entity.LeagueEntity;
import com.sapient.interview.football.exception.ResourceUnavailableException;
import com.sapient.interview.football.exception.ResourseAlreadyExistsException;
import com.sapient.interview.football.input.dto.LeagueCreateInputDto;
import com.sapient.interview.football.output.dto.LeagueOutputDto;
import com.sapient.interview.football.repository.LeagueRepository;
import com.sapient.interview.football.service.LeagueService;
import com.sapient.interview.football.util.Helper;

@Service
public class LeagueServiceImpl implements LeagueService{
	
	@Autowired
	private LeagueRepository leaguerepository;
	
	@Transactional
	@Override
	public LeagueOutputDto createLeague(LeagueCreateInputDto leagueCreateInputDto) {		
		try {
			boolean isLeagueNameExist = leaguerepository.existsByName(leagueCreateInputDto.getName());
			
			if (isLeagueNameExist) {			
				throw new ResourseAlreadyExistsException("League "+ leagueCreateInputDto.getName() + " already exists" ) ;
			}
			
			LeagueEntity league = new LeagueEntity(leagueCreateInputDto.getName()) ;
			leaguerepository.save(league) ;
			
			LeagueOutputDto leagueOutputDto = Helper.parseLeagueToLeagueDetails(league);
			return leagueOutputDto;
		}catch(Exception ex) {
			throw new RuntimeException(ex.getMessage()) ;
		}
		
	}
	
	@Override
	public LeagueOutputDto getLeague(int leagueId) {
		try {
			Optional<LeagueEntity> leagueOptional = leaguerepository.findById(leagueId) ;		
			if (!leagueOptional.isPresent()) {			
				throw new ResourceUnavailableException("League Id "+ leagueId  + " not found" ) ;
			}
			
			LeagueEntity league = leagueOptional.get();
			
			LeagueOutputDto leagueOutputDto = Helper.parseLeagueToLeagueDetails(league);
			return leagueOutputDto;
		}catch(Exception ex) {
			throw new RuntimeException(ex.getMessage()) ;
		}
		
		
	}	
	
}
