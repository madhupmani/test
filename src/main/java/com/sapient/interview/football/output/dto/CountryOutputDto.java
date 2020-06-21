package com.sapient.interview.football.output.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CountryOutputDto {
	@JsonProperty("id")
	private int id;
	
	@JsonProperty("name")
	private String name;

	public CountryOutputDto(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
