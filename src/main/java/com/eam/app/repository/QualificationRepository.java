package com.eam.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eam.app.model.Qualification;

@Repository
public interface QualificationRepository extends JpaRepository<Qualification, Long> {

}
