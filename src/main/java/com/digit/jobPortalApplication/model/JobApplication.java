package com.digit.jobPortalApplication.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class JobApplication {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private LocalDateTime appliedDate;
	@NotBlank(message="CoverLetter should not be null")
	@NotNull(message="CoverLetter should not be null")
	@Size(min=3,message="CoverLetter should be atleast 3 characters")
	private String coverLetter;
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "freeLancerId")
	private FreeLancer freeLancer;
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "jobId")
	private Job job;
}
