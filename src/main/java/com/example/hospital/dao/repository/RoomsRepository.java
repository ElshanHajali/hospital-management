package com.example.hospital.dao.repository;

import com.example.hospital.dao.entity.RoomsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Set;

public interface RoomsRepository extends
        JpaRepository<RoomsEntity, Long> {
    List<RoomsEntity> findByNumIn(Set<Long> roomNo);
}
