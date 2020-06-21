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
import com.sapient.interview.football.input.dto.LeagueCreateInputDto;
import com.sapient.interview.football.output.dto.LeagueOutputDto;
import com.sapient.interview.football.service.LeagueService;


//@CrossOrigin
@RestController
@RequestMapping("/league")
public class LeagueController {	
	
	@Autowired
	private LeagueService leagueService;	
	
	@PostMapping()
	public ResponseEntity<LeagueOutputDto> addCountry(
			@RequestBody LeagueCreateInputDto leagueCreateInputDto) {
		try {
			LeagueOutputDto leagueOutPutDto = leagueService.createLeague(leagueCreateInputDto);
			return new ResponseEntity<>(leagueOutPutDto, HttpStatus.CREATED);
		}catch(InputFormatException ex){
			throw new InputFormatException("Input Format exception" ) ;
		}catch(ServiceUnavailableException ex){
			throw new ServiceUnavailableException("Service is not available" ) ;
		}catch(Exception ex){
			throw new ServiceUnavailableException(ex.getMessage()) ;
		}
		
	}
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<LeagueOutputDto> getLeagueForId(
			@PathVariable("id") int leagueId){
		try {
			LeagueOutputDto leagueOutput = leagueService.getLeague(leagueId);
			return new ResponseEntity<>(leagueOutput, HttpStatus.OK);
		}catch(InputFormatException ex){
			throw new InputFormatException("Input Format exception" ) ;
		}catch(ServiceUnavailableException ex){
			throw new ServiceUnavailableException("Service is not available" ) ;
		}catch(Exception ex){
			throw new ServiceUnavailableException(ex.getMessage()) ;
		}
		
	}
}
