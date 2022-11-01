package com.example.hospital.mapper.factory;

import com.example.hospital.dao.entity.PatientDetailsEntity;
import com.example.hospital.dao.entity.PatientsEntity;
import com.example.hospital.model.request.PatientDetailsRequest;

public class PatientDetailFactory {

    public static PatientDetailsEntity buildPatientDetailEntity(
            PatientsEntity patient, PatientDetailsRequest detailsRequest) {
        return PatientDetailsEntity.builder()
                .id(patient.getId())
                .address(detailsRequest.getAddress())
                .age(detailsRequest.getAge())
                .balance(detailsRequest.getBalance())
                .sex(detailsRequest.getSex())
                .patient(patient)
                .build();
    }

}
