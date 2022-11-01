package com.example.hospital.mapper.factory;

import com.example.hospital.dao.entity.RoomsEntity;
import com.example.hospital.model.request.RoomsRequest;

public class RoomFactory {

    public static RoomsEntity buildRoomEntity(RoomsRequest request) {
        return RoomsEntity.builder().location(request.getLocation()).build();
    }

}
