package com.sapient.interview.football.service;

import com.sapient.interview.football.input.dto.CountryCreateInputDto;
import com.sapient.interview.football.output.dto.CountryOutputDto;


public interface CountryService {
	
	public CountryOutputDto getCountry(int countryId) ;
	public CountryOutputDto createCountry(CountryCreateInputDto countryCreateInputDto) ;
	
}
