package com.example.hospital.model.response;

import lombok.*;

import java.util.List;

@Builder
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ReceptionistsResponse {

    private Long id;
    private String name;
    private BillsResponse bill;

}
