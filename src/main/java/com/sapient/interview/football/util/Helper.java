package com.sapient.interview.football.util;
import com.sapient.interview.football.entity.CountryEntity;
import com.sapient.interview.football.entity.LeagueEntity;
import com.sapient.interview.football.entity.TeamEntity;
import com.sapient.interview.football.output.dto.CountryOutputDto;
import com.sapient.interview.football.output.dto.LeagueOutputDto;
import com.sapient.interview.football.output.dto.TeamOutputDto;

public class Helper {
	
	private Helper() {	}	
	
	public static CountryOutputDto parseCountryToCountryDetails(CountryEntity country) {		
		CountryOutputDto countryOutputDto = new CountryOutputDto(country.getId(),country.getName());
		return countryOutputDto;
	}
	public static LeagueOutputDto parseLeagueToLeagueDetails(LeagueEntity league) {		
		LeagueOutputDto leagueOutputDto = new LeagueOutputDto(league.getId(),league.getName());
		return leagueOutputDto;
	}
	
	public static TeamOutputDto parseTeamToTeamDetails(TeamEntity team) {		
		TeamOutputDto teamOutputDto = new TeamOutputDto(team.getId(),team.getName());
		return teamOutputDto;
	}
	
}
