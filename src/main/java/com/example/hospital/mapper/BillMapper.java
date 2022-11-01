package com.example.hospital.mapper;

import com.example.hospital.dao.entity.BillsEntity;
import com.example.hospital.model.request.BillsRequest;
import com.example.hospital.model.response.BillsResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.math.BigDecimal;
import java.util.stream.Collectors;

@Mapper
public interface BillMapper {
    BillMapper MAP = Mappers.getMapper(BillMapper.class);

    default BillsResponse entityToResponse(BillsEntity bill) {
        return BillsResponse.builder()
                .num(bill.getNum())
                .paid(bill.isPaid())
                .paidAmount(bill.getPaidAmount())
                .queueNo(bill.getQueueNo())
                .requestedAt(bill.getRequestedAt())
                .build();

    }

    default void updateBillFields(BillsEntity bill, BillsRequest request) {
        if (request.getPaidAmount() != null &&
                request.getPaidAmount().compareTo(BigDecimal.ZERO)>0){
            bill.setPaidAmount(request.getPaidAmount());
        }
        if (request.getQueueNo() != null && request.getQueueNo()>0){
            bill.setQueueNo(request.getQueueNo());
        }
    }
}
