package com.digit.jobPortalApplication.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class BookMarkFreeLancer {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@OneToOne
	private Skill skill;
	@OneToOne
	private FreeLancer freeLancer;
	@ManyToOne
	@JoinColumn(name = "recruiterId")
	private Recruiter recruiter;
}
