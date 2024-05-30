package com.gorest.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Builder
@Data
@NoArgsConstructor

public class UserLombok {

	@JsonProperty("name")
	private String name;

	@JsonProperty("gender")
	private String gender;

	@JsonProperty("email")
	private String email;

	@JsonProperty("status")
	private String status;

	public UserLombok(String name, String gender, String email, String status) {
		this.name = name;
		this.gender = gender;
		this.email = email;
		this.status = status;
	}

}
