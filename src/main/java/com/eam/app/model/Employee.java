package com.eam.app.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import com.eam.app.model.field.Gender;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

	private long id;
	private String name;
	private String email;
	private String phone;
	private String address;
	private String position;
	@Enumerated(EnumType.ORDINAL)
	private Gender gender;
	private LocalDate employedDate;
	private LocalDate dateOfBirth;
	@ManyToOne
	@JoinColumn(name = "department_id")
	private Department department;
	@OneToMany(mappedBy = "employee")
	private List<Education> educations;
	@OneToMany(mappedBy = "employee")
	private List<Qualification> qualifications;
	private LocalDateTime createdOn;
	private LocalDateTime updatedOn;
	private boolean active;
	
	@PrePersist
	private void prePersist() {
		this.createdOn = LocalDateTime.now();
		this.updatedOn = LocalDateTime.now();
		this.active = true;
	}
	
	@PreUpdate
	private void preUpdate() {
	    this.updatedOn = LocalDateTime.now();
	}
	
}

