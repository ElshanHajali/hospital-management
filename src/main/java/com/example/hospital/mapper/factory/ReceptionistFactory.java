package com.example.hospital.mapper.factory;

import com.example.hospital.dao.entity.BillsEntity;
import com.example.hospital.dao.entity.ReceptionistsEntity;
import com.example.hospital.model.request.ReceptionistsRequest;

public class ReceptionistFactory {

    public static ReceptionistsEntity buildReceptionistEntity(
            ReceptionistsRequest request,
            BillsEntity bill) {
        return ReceptionistsEntity.builder()
                .name(request.getName())
                .bill(bill)
                .build();
    }
}
