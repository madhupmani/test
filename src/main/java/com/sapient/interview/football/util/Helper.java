package com.sapient.interview.football.util;
//import com.sapient.interview.football.common.message.MessageParser;
import com.sapient.interview.football.entity.CountryEntity;
import com.sapient.interview.football.exception.ResourceUnavailableException;
import com.sapient.interview.football.exception.ServiceUnavailableException;
import com.sapient.interview.football.output.dto.CountryOutputDto;

public class Helper {
	
	private Helper() {	}	
	
	public static CountryOutputDto parseCountryToCountryDetails(CountryEntity country) {		
		CountryOutputDto countryOutputDto = new CountryOutputDto(country.getId(),country.getName());
		return countryOutputDto;
	}
	
	public static RuntimeException customException(Class exceptionClass, String exceptionMessage) {
		try {
			RuntimeException ex = (RuntimeException) exceptionClass.getDeclaredConstructor(String.class).newInstance(exceptionMessage);			
			return ex;
		} catch (Exception e) {
			return new ServiceUnavailableException(e.getMessage());
		}
	}
	
	/*
	public static RuntimeException resourceNotExistingException(String exceptionMessage) {
		try {
			RuntimeException ex = new ResourceUnavailableException(	MessageParser.getMessage(exceptionMessage));
			return ex;
		}catch (Exception e) {
			return new ServiceUnavailableException(e.getMessage());
		}
		
	} */
}
