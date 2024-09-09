package com.eam.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eam.app.model.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer>{

}
