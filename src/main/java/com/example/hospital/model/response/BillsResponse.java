package com.example.hospital.model.response;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Builder
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class BillsResponse {

    private Long num;
    private BigDecimal paidAmount;
    private boolean paid;
    private LocalDateTime requestedAt;
    private Long queueNo;

}
