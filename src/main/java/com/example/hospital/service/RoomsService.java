package com.example.hospital.service;

import com.example.hospital.dao.entity.RoomsEntity;
import com.example.hospital.dao.repository.RoomsRepository;
import com.example.hospital.mapper.factory.RoomFactory;
import com.example.hospital.model.request.RoomsRequest;
import com.example.hospital.model.response.RoomsResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static com.example.hospital.mapper.RoomMapper.MAP;

@Service
@Slf4j
@RequiredArgsConstructor
public class RoomsService {
    private final RoomsRepository roomsRepository;

    public List<RoomsResponse> getRooms(){
        log.info("ActionLog.getRooms.start");
        return roomsRepository.findAll().stream()
                .map(MAP::entityToResponse)
                .collect(Collectors.toList());
    }

    public List<RoomsEntity> getRooms(Set<Long> roomNo){
        log.info("ActionLog.getRooms.start");
        return roomsRepository.findByNumIn(roomNo);
    }

    public RoomsResponse getRoom(Long roomNo) {
        log.info("ActionLog.getRoom.start");
        return MAP.entityToResponse(fetchRoomById(roomNo));
    }
    public void saveRoom(RoomsRequest request) {
        log.info("ActionLog.saveRoom.start");
        roomsRepository.save(RoomFactory.buildRoomEntity(request));
        log.info("ActionLog.saveRoom.success");
    }

    public void updateRoom(long id, RoomsRequest request) {
        log.info("ActionLog.updateRoom.start");
        var room = fetchRoomById(id);

        MAP.updateRoomFields(room, request);

        roomsRepository.save(room);
        log.info("ActionLog.updateRoom.success");
    }

    private RoomsEntity fetchRoomById(long id) {
        return roomsRepository.findById(id)
                .orElseThrow(RuntimeException::new);
    }
}
