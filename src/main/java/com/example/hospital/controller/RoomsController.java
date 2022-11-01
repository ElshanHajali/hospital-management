package com.example.hospital.controller;

import com.example.hospital.model.request.RoomsRequest;
import com.example.hospital.model.response.RoomsResponse;
import com.example.hospital.service.RoomsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/rooms")
@RequiredArgsConstructor
public class RoomsController {
    private final RoomsService roomsService;

    @GetMapping
    public List<RoomsResponse> getRooms() {
        return roomsService.getRooms();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void saveRoom(@RequestBody RoomsRequest request) {
        roomsService.saveRoom(request);
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateRoom(@PathVariable long id,
                           @RequestBody RoomsRequest request) {
        roomsService.updateRoom(id, request);
    }
}
