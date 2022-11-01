package com.example.hospital.dao.repository;

import com.example.hospital.dao.entity.DoctorsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorsRepository extends
        JpaRepository<DoctorsEntity, Long> {
}
