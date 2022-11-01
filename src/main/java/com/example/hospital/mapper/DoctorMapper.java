package com.example.hospital.mapper;

import com.example.hospital.dao.entity.DoctorsEntity;
import com.example.hospital.model.request.DoctorsRequest;
import com.example.hospital.model.response.DoctorsResponse;
import liquibase.util.StringUtil;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.util.StringUtils;

import java.util.stream.Collectors;

@Mapper
public interface DoctorMapper {
    DoctorMapper MAP = Mappers.getMapper(DoctorMapper.class);

    default DoctorsResponse entityToResponse(DoctorsEntity doctor) {
        return DoctorsResponse.builder()
                .id(doctor.getId())
                .available(doctor.isAvailable())
                .name(doctor.getName())
                .phoneNo(doctor.getPhoneNo())
                .specialization(doctor.getSpecialization())
                .build();
    }

    default void updateDoctorFields(DoctorsEntity doctor, DoctorsRequest request) {
        if (StringUtils.hasText(request.getName())) {
            doctor.setName(request.getName());
        }
        if (StringUtils.hasText(request.getSpecialization())) {
            doctor.setSpecialization(request.getSpecialization());
        }
        if (StringUtils.hasText(request.getPhoneNo())) {
            doctor.setPhoneNo(request.getPhoneNo());
        }
    }
}
