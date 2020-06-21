package com.sapient.interview.football.serviceImpl;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sapient.interview.football.entity.CountryEntity;
import com.sapient.interview.football.exception.ResourceUnavailableException;
import com.sapient.interview.football.exception.ResourseAlreadyExistsException;
import com.sapient.interview.football.input.dto.CountryCreateInputDto;
import com.sapient.interview.football.output.dto.CountryOutputDto;
import com.sapient.interview.football.repository.CountryRepository;
import com.sapient.interview.football.service.CountryService;
import com.sapient.interview.football.util.Helper;

@Service
public class CountryServiceImpl implements CountryService{
	
	@Autowired
	private CountryRepository countryrepository;
	
	@Transactional
	@Override
	public CountryOutputDto createCountry(CountryCreateInputDto countryCreateInputDto) {		
		try {
			boolean isCountryNameExist = countryrepository.existsByName(countryCreateInputDto.getName());
			
			if (isCountryNameExist) {			
				throw new ResourseAlreadyExistsException("County "+ countryCreateInputDto.getName() + " already exists" ) ;
			}
			
			CountryEntity country = new CountryEntity(countryCreateInputDto.getName()) ;
			countryrepository.save(country) ;
			
			CountryOutputDto countryOutputDto = Helper.parseCountryToCountryDetails(country);
			return countryOutputDto;
		}catch(Exception ex) {
			throw new RuntimeException(ex.getMessage()) ;
		}
		
	}
	
	@Override
	public CountryOutputDto getCountry(int countryId) {
		try {
			Optional<CountryEntity> countryOptional = countryrepository.findById(countryId) ;		
			if (!countryOptional.isPresent()) {			
				throw new ResourceUnavailableException("ounty Id "+ countryId  + " not found" ) ;
			}
			
			CountryEntity country = countryOptional.get();
			
			CountryOutputDto countryOutputDto = Helper.parseCountryToCountryDetails(country);
			return countryOutputDto;
		}catch(Exception ex) {
			throw new RuntimeException(ex.getMessage()) ;
		}
		
		
	}	
	
}
