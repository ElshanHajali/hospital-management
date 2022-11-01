package com.example.hospital.mapper.factory;

import com.example.hospital.dao.entity.DoctorsEntity;
import com.example.hospital.model.request.DoctorsRequest;

public class DoctorFactory {

    public static DoctorsEntity buildDoctorEntity(DoctorsRequest request) {
        return DoctorsEntity.builder()
                .phoneNo(request.getPhoneNo())
                .specialization(request.getSpecialization())
                .name(request.getName())
                .build();
    }
}
