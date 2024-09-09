package com.eam.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eam.app.model.Education;

@Repository
public interface EducationRepository extends JpaRepository<Education, Long> {

}
