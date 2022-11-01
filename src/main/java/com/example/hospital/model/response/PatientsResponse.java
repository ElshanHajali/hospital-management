package com.example.hospital.model.response;

import lombok.*;

import java.util.List;

@Builder
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class PatientsResponse {

    private Long id;
    private String name;
    private String phoneNo;

    private PatientDetailsResponse patientDetail;
    private DoctorsResponse doctor;
    private ReceptionistsResponse receptionist;

}
