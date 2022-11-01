package com.example.hospital.model.request;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DoctorsRequest {

    private String name;
    private String specialization;
    private String phoneNo;

}