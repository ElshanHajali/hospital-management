package com.example.hospital.model.response;

import lombok.*;

@Builder
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentsResponse {

    private Long id;
    private String name;

    private DoctorsResponse doctor;

}
