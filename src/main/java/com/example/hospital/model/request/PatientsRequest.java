package com.example.hospital.model.request;

import lombok.*;

import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PatientsRequest {

    private String name;
    private String phoneNo;

    private PatientDetailsRequest detailsRequestDto;

    private Set<Long> roomNo;
    private Set<Long> billNo;

}
