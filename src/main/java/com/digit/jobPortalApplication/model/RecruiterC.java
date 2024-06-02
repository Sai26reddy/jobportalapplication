package com.digit.jobPortalApplication.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RecruiterC {
	@Id
	@NotBlank(message="FirstName should not be null")
	@NotNull(message="FirstName should not be null")
	@Size(min=3,message="FirstName should be atleast 3 characters")
	private String firstName;
	@NotBlank(message="LastName should not be null")
	@NotNull(message="LastName should not be null")
	@Size(min=3,message="LastName should be atleast 3 characters")
	private String lastName;
	@NotBlank(message="Password should not be null")
	@NotNull(message="Password should not be null")
	@Pattern(regexp ="^(?=.*?[A-Z])(?=(.*[a-z]){1,})(?=(.*[\\d]){1,})(?=(.*[\\W]){1,})(?!.*\\s).{4,}$",message = "Password is not Strong please enter Strong password")
	private String password;
	@Pattern(regexp="[a-zA-Z0-9_.-]+@[a-zA-Z0-9_.-]+.[a-zA-Z0-9_.-]{3}",message="please enter proper mail")
	private String mail;
	@NotBlank(message="CoverLetter should not be null")
	@NotNull(message="CoverLetter should not be null")
	@Size(min=4,message="CoverLetter should be atleast 4 characters")
	private String coverLetter;
}
