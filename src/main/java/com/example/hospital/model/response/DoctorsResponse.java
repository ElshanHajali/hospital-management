package com.example.hospital.model.response;

import lombok.*;

import java.util.List;

@Builder
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class DoctorsResponse {

    private Long id;
    private String name;
    private String specialization;
    private String phoneNo;
    private boolean available;

}
