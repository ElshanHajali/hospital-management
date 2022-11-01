package com.example.hospital.controller;

import com.example.hospital.model.request.PatientsRequest;
import com.example.hospital.model.request.ReceptionistsRequest;
import com.example.hospital.service.ReceptionistsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/receptionists")
@RequiredArgsConstructor
public class ReceptionistsController {
    private final ReceptionistsService receptionistsService;

    @PostMapping("{receptionistId}/patients")
    @ResponseStatus(HttpStatus.CREATED)
    public void addPatientToReceptionist(@PathVariable long receptionistId,
                                         @RequestBody PatientsRequest request) {
        receptionistsService.addPatientToReceptionist(receptionistId, request);
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateReceptionist(@PathVariable long id,
                                   @RequestBody ReceptionistsRequest request) {
        receptionistsService.updateReceptionist(id, request);
    }
}
