package com.example.hospital.model.response;

import lombok.*;

import java.math.BigDecimal;

@Builder
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class PatientDetailsResponse {

    private Long id;
    private String address;
    private byte age;
    private String sex;
    private BigDecimal balance;

    private PatientsResponse patient;

}
