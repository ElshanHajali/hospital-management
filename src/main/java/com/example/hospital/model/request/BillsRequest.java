package com.example.hospital.model.request;

import lombok.*;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BillsRequest {

    private BigDecimal paidAmount;
    private Long queueNo;

}
