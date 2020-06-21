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
import com.sapient.interview.football.input.dto.CountryCreateInputDto;
import com.sapient.interview.football.output.dto.CountryOutputDto;
import com.sapient.interview.football.service.CountryService;


//@CrossOrigin
@RestController
@RequestMapping("/country")
public class CountryController {	
	
	@Autowired
	private CountryService countryService;	
	
	@PostMapping()
	public ResponseEntity<CountryOutputDto> addCountry(
			@RequestBody CountryCreateInputDto countryCreateInputDto) {
		try {
			CountryOutputDto countryOutPutDto = countryService.createCountry(countryCreateInputDto);
			return new ResponseEntity<>(countryOutPutDto, HttpStatus.CREATED);
		}catch(InputFormatException ex){
			throw new InputFormatException("Input Format exception" ) ;
		}catch(ServiceUnavailableException ex){
			throw new ServiceUnavailableException("Service is not available" ) ;
		}catch(Exception ex){
			throw new ServiceUnavailableException(ex.getMessage()) ;
		}
		
	}
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<CountryOutputDto> getCountryForId(
			@PathVariable("id") int countryId){
		try {
			CountryOutputDto countryOutput = countryService.getCountry(countryId);
			return new ResponseEntity<>(countryOutput, HttpStatus.OK);
		}catch(InputFormatException ex){
			throw new InputFormatException("Input Format exception" ) ;
		}catch(ServiceUnavailableException ex){
			throw new ServiceUnavailableException("Service is not available" ) ;
		}catch(Exception ex){
			throw new ServiceUnavailableException(ex.getMessage()) ;
		}
		
	}
}
