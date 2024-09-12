package com.eam.app.model;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Department {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id;
	private String name;
	private LocalDateTime createdOn;
	private LocalDateTime updatedOn;
	private boolean active;
	@OneToMany(mappedBy = "department", fetch = FetchType.EAGER)
	private List<Employee> employees;
	
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
