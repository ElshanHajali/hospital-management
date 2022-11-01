package com.example.hospital.dao.repository;

import com.example.hospital.dao.entity.PatientsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientsRepository extends
        JpaRepository<PatientsEntity, Long> {
}
