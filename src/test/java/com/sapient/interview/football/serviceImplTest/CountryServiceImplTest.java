package com.sapient.interview.football.serviceImplTest;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;

import com.sapient.interview.football.entity.CountryEntity;
import com.sapient.interview.football.repository.CountryRepository;
import com.sapient.interview.football.service.TeamService;
import com.sapient.interview.football.serviceImpl.CountryServiceImpl;

public class CountryServiceImplTest {
	
	@TestConfiguration
    static class CountryServiceImplTestContextConfiguration {  
        @Bean
        public TeamService countryService() {
            return new CountryServiceImpl();
        }
    }
	
	@Autowired
    private TeamService countryService;
 
    @MockBean
    private CountryRepository countryRepository;
    
	@Before(value = "")
	public void setUp() {
		CountryEntity country = new CountryEntity("india");	 
	    //Mockito.when(CountryRepository.existsByName(country.getName()).thenReturn("india");
	}
	
	@Test
	public void whenValidName_thenEmployeeShouldBeFound() {
	    String name = "India";
	    //CountryEntity found = countryService.getEmployeeByName(name);
	  
	    // assertThat(found.getName()).isEqualTo(name);
	 }
}
