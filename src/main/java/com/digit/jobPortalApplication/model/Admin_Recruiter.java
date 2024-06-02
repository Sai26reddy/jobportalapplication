package com.digit.jobPortalApplication.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Admin_Recruiter {
@Id
@NotBlank(message="Name should not be null")
@NotNull(message="Name should not be null")
@Size(min=3,message="Name should be atleast 3 characters")
private String firstName;
@NotBlank(message="Name should not be null")
@NotNull(message="Name should not be null")
@Size(min=1,message="Name should be atleast 1 characters")
private String lastName;
@NotBlank(message="CoverLetter should not be null")
@NotNull(message="CoverLetter should not be null")
@Size(min=4,message="CoverLetter should be atleast 4 characters")
private String coverLetter;
}
