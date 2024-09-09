package com.eam.app.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Qualification {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long id;
	private String name;
	private LocalDate receivedOn;
	@ManyToOne
	@JoinColumn(name = "employee")
	private Employee employee;
	private LocalDateTime createdOn;
	private LocalDateTime updatedOn;
	
	@PrePersist
	private void prePersist() {
		this.createdOn = LocalDateTime.now();
		this.updatedOn = LocalDateTime.now();
	}
	
	@PreUpdate
	private void preUpdate() {
		this.updatedOn = LocalDateTime.now();
	}
	
	
}
