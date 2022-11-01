package com.example.hospital.mapper;

import com.example.hospital.dao.entity.ReceptionistsEntity;
import com.example.hospital.model.request.ReceptionistsRequest;
import com.example.hospital.model.response.ReceptionistsResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.util.StringUtils;

@Mapper
public interface ReceptionistMapper  {
    ReceptionistMapper MAP = Mappers.getMapper(ReceptionistMapper.class);

    default ReceptionistsResponse entityToResponse(ReceptionistsEntity receptionist){
        return ReceptionistsResponse.builder()
                .id(receptionist.getId())
                .name(receptionist.getName())
                .bill(BillMapper.MAP.entityToResponse(receptionist.getBill()))
                .build();
    }

    default void updateReceptionistFields(ReceptionistsEntity receptionist,
                                          ReceptionistsRequest request) {
        if (StringUtils.hasText(request.getName())) {
            receptionist.setName(request.getName());
        }
    }
}
