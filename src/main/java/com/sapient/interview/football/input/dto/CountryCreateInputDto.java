package com.sapient.interview.football.input.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CountryCreateInputDto {	
	@JsonProperty("name")
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
