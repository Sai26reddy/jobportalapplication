package com.digit.jobPortalApplication.model;

import java.util.*;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
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
public class Job {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@OneToOne(cascade = CascadeType.ALL)
	private Skill skill;
	@OneToOne
	private FreeLancer awardedTo;
	@ManyToOne
	@JoinColumn(name = "recruiterId")
	private Recruiter recruiter;
	private Boolean active;
	@NotBlank(message="JobRole should not be null")
	@NotNull(message="JobRole should not be null")
	@Size(min=3,message="JobRole should be atleast 3 characters")
	private String jobRole;
	private Boolean jobStatus;
}
