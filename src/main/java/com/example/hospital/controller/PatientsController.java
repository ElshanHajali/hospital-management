package com.example.hospital.controller;

import com.example.hospital.model.request.PatientDetailsRequest;
import com.example.hospital.model.request.PatientsRequest;
import com.example.hospital.model.request.ReceptionistsRequest;
import com.example.hospital.model.response.PatientsResponse;
import com.example.hospital.service.PatientsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("v1/patients")
@RequiredArgsConstructor
public class PatientsController {
    private final PatientsService patientsService;

    @GetMapping
    public List<PatientsResponse> getPatients() {
        return patientsService.getPatients();
    }

    @GetMapping("{id}")
    public PatientsResponse getPatient(@PathVariable long id) {
        return patientsService.getPatient(id);
    }

    @PostMapping("{patientId}/details")
    @ResponseStatus(HttpStatus.CREATED)
    public void addDetailToPatient(@PathVariable long patientId,
                                   @RequestBody PatientDetailsRequest request) {
        patientsService.addDetailToPatient(patientId, request);
    }

    @PatchMapping("{patientId}/bills")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void addBillsToPatient(@PathVariable long patientId,
                                  @RequestParam("value") Set<Long> billNum) {
        patientsService.addBillsToPatient(patientId, billNum);
    }

    @PatchMapping("{patientId}/rooms")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void addRoomsToPatient(@PathVariable long patientId,
                                  @RequestParam("value") Set<Long> roomNum) {
        patientsService.addRoomsToPatient(patientId, roomNum);
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updatePatient(@PathVariable long id,
                              @RequestBody PatientsRequest request) {
        patientsService.updatePatient(id, request);
    }

    @PutMapping("{id}/details")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updatePatientDetail(@PathVariable long id,
                                    @RequestBody PatientDetailsRequest request) {
        patientsService.updatePatientDetails(id, request);
    }

}
