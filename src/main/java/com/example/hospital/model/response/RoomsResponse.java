package com.example.hospital.model.response;

import lombok.*;

@Builder
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class RoomsResponse {

    private Long num;
    private String location;
    private boolean available;
}
