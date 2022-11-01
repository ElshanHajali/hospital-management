package com.example.hospital.dao.repository;

import com.example.hospital.dao.entity.DepartmentsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentsRepository extends
        JpaRepository<DepartmentsEntity, Long> {
}
