package com.example.hospital.mapper;

import com.example.hospital.dao.entity.BillsEntity;
import com.example.hospital.dao.entity.PatientDetailsEntity;
import com.example.hospital.dao.entity.PatientsEntity;
import com.example.hospital.dao.entity.RoomsEntity;
import com.example.hospital.mapper.factory.PatientDetailFactory;
import com.example.hospital.model.request.PatientDetailsRequest;
import com.example.hospital.model.request.PatientsRequest;
import com.example.hospital.model.response.PatientsResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@Mapper
public interface PatientMapper {
    PatientMapper MAP = Mappers.getMapper(PatientMapper.class);

    default PatientsResponse entityToResponse(PatientsEntity patient) {
        return PatientsResponse.builder()
                .id(patient.getId())
                .name(patient.getName())
                .phoneNo(patient.getPhoneNo())
                .receptionist(ReceptionistMapper.MAP.
                        entityToResponse(patient.getReceptionist()))
                .patientDetail(PatientDetailMapper.MAP
                        .entityToResponse(patient.getPatientDetail()))
                .doctor(DoctorMapper.MAP.entityToResponse(patient.getDoctor()))
                .build();
    }

    default void updatePatientFields(PatientsEntity patient,
                                     PatientsRequest request) {
        if (StringUtils.hasText(request.getName())) {
            patient.setName(request.getName());
        }
        if (StringUtils.hasText(request.getPhoneNo())) {
            patient.setPhoneNo(request.getPhoneNo());
        }
    }

    default void setRelationsToPatient(PatientsEntity patient,
                                       List<BillsEntity> bills,
                                       List<RoomsEntity> rooms,
                                       PatientDetailsEntity patientDetail) {
        patient.setBills(bills);

        patient.setRooms(rooms);

        patient.setPatientDetail(patientDetail);
    }


    default void updatePatientDetailFields(PatientDetailsEntity patientDetail,
                                           PatientDetailsRequest request) {
        if (StringUtils.hasText(request.getAddress())) {
            patientDetail.setAddress(request.getAddress());
        }
        if (StringUtils.hasText(request.getSex())) {
            patientDetail.setSex(request.getSex());
        }
        if (request.getAge() > 0) {
            patientDetail.setAge(request.getAge());
        }
        if (request.getBalance().compareTo(BigDecimal.valueOf(0)) > 0) {
            patientDetail.setBalance(request.getBalance());
        }
    }
}
