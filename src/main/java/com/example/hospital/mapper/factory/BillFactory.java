package com.example.hospital.mapper.factory;

import com.example.hospital.dao.entity.BillsEntity;
import com.example.hospital.model.request.BillsRequest;

public class BillFactory {

    public static BillsEntity buildBillEntity(BillsRequest request) {
        return BillsEntity.builder()
                .queueNo(request.getQueueNo())
                .paidAmount(request.getPaidAmount())
                .build();
    }
}
