package com.example.hospital.mapper;

import com.example.hospital.dao.entity.RoomsEntity;
import com.example.hospital.model.request.RoomsRequest;
import com.example.hospital.model.response.RoomsResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.util.StringUtils;

@Mapper
public interface RoomMapper {
    RoomMapper MAP = Mappers.getMapper(RoomMapper.class);

    default RoomsResponse entityToResponse(RoomsEntity room) {
        return RoomsResponse.builder()
                .num(room.getNum())
                .available(room.isAvailable())
                .location(room.getLocation())
                .build();
    }

    default void updateRoomFields(RoomsEntity room, RoomsRequest request) {
        if (StringUtils.hasText(request.getLocation())) {
            room.setLocation(request.getLocation());
        }
    }
}
