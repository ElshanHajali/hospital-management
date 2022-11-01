package com.example.hospital.dao.repository;

import com.example.hospital.dao.entity.PatientDetailsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientDetailsRepository extends
        JpaRepository<PatientDetailsEntity, Long> {
}
