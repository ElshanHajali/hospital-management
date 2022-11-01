package com.example.hospital.mapper.factory;

import com.example.hospital.dao.entity.DepartmentsEntity;
import com.example.hospital.dao.entity.DoctorsEntity;
import com.example.hospital.model.request.DepartmentsRequest;

public class DepartmentFactory {

    public static DepartmentsEntity buildDepartmentEntity(
            DoctorsEntity doctor, DepartmentsRequest request) {
        return DepartmentsEntity.builder()
                .doctor(doctor)
                .name(request.getName())
                .build();
    }
}
