package com.sapient.interview.football.serviceImpl;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sapient.interview.football.entity.TeamEntity;
import com.sapient.interview.football.exception.ResourceUnavailableException;
import com.sapient.interview.football.exception.ResourseAlreadyExistsException;
import com.sapient.interview.football.input.dto.TeamCreateInputDto;
import com.sapient.interview.football.output.dto.TeamOutputDto;
import com.sapient.interview.football.repository.TeamRepository;
import com.sapient.interview.football.service.TeamService;
import com.sapient.interview.football.util.Helper;

@Service
public class TeamServiceImpl implements TeamService{
	
	@Autowired
	private TeamRepository teamrepository;
	
	@Transactional
	@Override
	public TeamOutputDto createTeam(TeamCreateInputDto teamCreateInputDto) {		
		try {
			boolean isTeamNameExist = teamrepository.existsByName(teamCreateInputDto.getName());
			
			if (isTeamNameExist) {			
				throw new ResourseAlreadyExistsException("Team "+ teamCreateInputDto.getName() + " already exists" ) ;
			}
			
			TeamEntity team = new TeamEntity(teamCreateInputDto.getName()) ;
			teamrepository.save(team) ;
			
			TeamOutputDto teamOutputDto = Helper.parseTeamToTeamDetails(team);
			return teamOutputDto;
		}catch(Exception ex) {
			throw new RuntimeException(ex.getMessage()) ;
		}
		
	}
	
	@Override
	public TeamOutputDto getTeam(int teamId) {
		try {
			Optional<TeamEntity> teamOptional = teamrepository.findById(teamId) ;		
			if (!teamOptional.isPresent()) {			
				throw new ResourceUnavailableException("Team Id "+ teamId  + " not found" ) ;
			}
			
			TeamEntity team = teamOptional.get();
			
			TeamOutputDto teamOutputDto = Helper.parseTeamToTeamDetails(team);
			return teamOutputDto;
		}catch(Exception ex) {
			throw new RuntimeException(ex.getMessage()) ;
		}
		
		
	}	
	
}
