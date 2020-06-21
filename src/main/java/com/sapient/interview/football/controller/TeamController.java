package com.sapient.interview.football.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sapient.interview.football.exception.InputFormatException;
import com.sapient.interview.football.exception.ServiceUnavailableException;
import com.sapient.interview.football.input.dto.TeamCreateInputDto;
import com.sapient.interview.football.output.dto.TeamOutputDto;
import com.sapient.interview.football.service.TeamService;


//@CrossOrigin
@RestController
@RequestMapping("/country")
public class TeamController {	
	
	@Autowired
	private TeamService teamService;	
	
	@PostMapping()
	public ResponseEntity<TeamOutputDto> addTeam(
			@RequestBody TeamCreateInputDto teamCreateInputDto) {
		try {
			TeamOutputDto teamOutPutDto = teamService.createTeam(teamCreateInputDto);
			return new ResponseEntity<>(teamOutPutDto, HttpStatus.CREATED);
		}catch(InputFormatException ex){
			throw new InputFormatException("Input Format exception" ) ;
		}catch(ServiceUnavailableException ex){
			throw new ServiceUnavailableException("Service is not available" ) ;
		}catch(Exception ex){
			throw new ServiceUnavailableException(ex.getMessage()) ;
		}
		
	}
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<TeamOutputDto> getTeamForId(
			@PathVariable("id") int teamId){
		try {
			TeamOutputDto teamOutput = teamService.getTeam(teamId);
			return new ResponseEntity<>(teamOutput, HttpStatus.OK);
		}catch(InputFormatException ex){
			throw new InputFormatException("Input Format exception" ) ;
		}catch(ServiceUnavailableException ex){
			throw new ServiceUnavailableException("Service is not available" ) ;
		}catch(Exception ex){
			throw new ServiceUnavailableException(ex.getMessage()) ;
		}
		
	}
}
