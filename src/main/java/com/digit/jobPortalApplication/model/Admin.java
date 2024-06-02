package com.digit.jobPortalApplication.model;


	import javax.persistence.Entity;
	import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
	import lombok.Data;
	import lombok.NoArgsConstructor;

	@Entity
	@Data
	@NoArgsConstructor
	@AllArgsConstructor
	public class Admin {
		@Id
		private long user_id;
		@NotBlank(message="Password should not be null")
		@NotNull(message="Password should not be null")
		@Pattern(regexp ="^(?=.*?[A-Z])(?=(.*[a-z]){1,})(?=(.*[\\d]){1,})(?=(.*[\\W]){1,})(?!.*\\s).{4,}$",message = "Password is not Strong please enter Strong password")
		private String password;
		@Pattern(regexp="[a-zA-Z0-9_.-]+@[a-zA-Z0-9_.-]+.[a-zA-Z0-9_.-]{3}",message="please enter proper mail")
		private String mail;
	}


