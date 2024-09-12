package com.eam.app.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.eam.app.model.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer>{

	@Modifying
	@Query("UPDATE Department d SET d.name = :name WHERE d.id = :id")
	void updateDepartmentName(@Param("id") int id, @Param("name") String name);
	
	@Modifying
	@Query("UPDATE Department d SET d.active = false WHERE d.id = :id")
	void removeDepartment(@Param("id") int id);
	
	@Query("SELECT d FROM Department d WEHRE d.active = true")
	Page<Department> getDepartments(Pageable pageable);
}
