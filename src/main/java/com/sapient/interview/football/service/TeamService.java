package com.sapient.interview.football.service;

import com.sapient.interview.football.input.dto.TeamCreateInputDto;
import com.sapient.interview.football.output.dto.TeamOutputDto;


public interface TeamService {
	
	public TeamOutputDto getTeam(int teamId) ;
	public TeamOutputDto createTeam(TeamCreateInputDto teamCreateInputDto) ;
	
}
