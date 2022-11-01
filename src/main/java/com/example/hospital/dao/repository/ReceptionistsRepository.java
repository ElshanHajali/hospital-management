package com.example.hospital.dao.repository;

import com.example.hospital.dao.entity.ReceptionistsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReceptionistsRepository extends
        JpaRepository<ReceptionistsEntity, Long> {
}
