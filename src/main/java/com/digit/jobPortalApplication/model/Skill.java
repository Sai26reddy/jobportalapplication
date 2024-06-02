package com.digit.jobPortalApplication.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Skill {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@NotBlank(message="Name should not be null")
	@NotNull(message="Name should not be null")
	@Size(min=3,message="Name should be atleast 3 characters")
	private String name;
	@NotBlank(message="Description should not be null")
	@NotNull(message="Description should not be null")
	@Size(min=3,message="Description should be atleast 3 characters")
	private String description;
}
