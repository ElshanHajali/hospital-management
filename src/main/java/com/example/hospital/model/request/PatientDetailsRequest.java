package com.example.hospital.model.request;

import lombok.*;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PatientDetailsRequest {

    private String address;
    private byte age;
    private String sex;
    private BigDecimal balance;

}
