package com.example.hospital.dao.repository;

import com.example.hospital.dao.entity.BillsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Set;

public interface BillsRepository extends
        JpaRepository<BillsEntity, Long> {

    List<BillsEntity> findByNumIn(Set<Long> billIds);
}
