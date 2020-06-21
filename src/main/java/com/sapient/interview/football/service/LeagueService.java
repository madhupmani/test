package com.sapient.interview.football.service;

import com.sapient.interview.football.input.dto.LeagueCreateInputDto;
import com.sapient.interview.football.output.dto.LeagueOutputDto;


public interface LeagueService {
	
	public LeagueOutputDto getLeague(int leagueId) ;
	public LeagueOutputDto createLeague(LeagueCreateInputDto leagueCreateInputDto) ;
	
}
