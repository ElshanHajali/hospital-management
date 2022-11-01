package com.example.hospital.mapper.factory;

import com.example.hospital.dao.entity.DoctorsEntity;
import com.example.hospital.dao.entity.PatientsEntity;
import com.example.hospital.dao.entity.ReceptionistsEntity;
import com.example.hospital.model.request.PatientsRequest;

public class PatientFactory {

    public static PatientsEntity buildPatientEntity(
            PatientsRequest request, DoctorsEntity doctor,
            ReceptionistsEntity receptionist) {

        return  PatientsEntity.builder()
                .name(request.getName())
                .phoneNo(request.getPhoneNo())
                .doctor(doctor)
                .receptionist(receptionist)
                .build();
    }

    public static PatientsEntity buildPatientEntity(
            PatientsRequest request, DoctorsEntity doctor) {

        return  PatientsEntity.builder()
                .name(request.getName())
                .phoneNo(request.getPhoneNo())
                .doctor(doctor)
                .build();
    }

    public static PatientsEntity buildPatientEntity(
            PatientsRequest request,
            ReceptionistsEntity receptionist) {
        return  PatientsEntity.builder()
                .name(request.getName())
                .phoneNo(request.getPhoneNo())
                .receptionist(receptionist)
                .build();
    }

    public static PatientsEntity buildPatientEntity(PatientsRequest request) {
        return  PatientsEntity.builder()
                .name(request.getName())
                .phoneNo(request.getPhoneNo())
                .build();
    }
}
