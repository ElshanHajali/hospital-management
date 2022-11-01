package com.example.hospital.mapper;

import com.example.hospital.dao.entity.PatientDetailsEntity;
import com.example.hospital.model.response.PatientDetailsResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PatientDetailMapper {
    PatientDetailMapper MAP = Mappers.getMapper(PatientDetailMapper.class);

    default PatientDetailsResponse entityToResponse(PatientDetailsEntity patientDetails) {
        return PatientDetailsResponse.builder()
                .address(patientDetails.getAddress())
                .id(patientDetails.getId())
                .age(patientDetails.getAge())
                .balance(patientDetails.getBalance())
                .sex(patientDetails.getSex())
                .patient(PatientMapper.MAP
                        .entityToResponse(patientDetails.getPatient()))
                .build();
    }
}
