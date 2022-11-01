package com.example.hospital.controller;

import com.example.hospital.model.request.DepartmentsRequest;
import com.example.hospital.model.request.DoctorsRequest;
import com.example.hospital.model.request.PatientsRequest;
import com.example.hospital.model.response.DoctorsResponse;
import com.example.hospital.service.DoctorsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/doctors")
@RequiredArgsConstructor
public class DoctorsController {
    private final DoctorsService doctorsService;

    @GetMapping
    public List<DoctorsResponse> getDoctors() {
        return doctorsService.getDoctors();
    }

    @GetMapping("{id}")
    public DoctorsResponse getDoctor(@PathVariable long id) {
        return doctorsService.getDoctor(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void saveDoctor(@RequestBody DoctorsRequest request) {
        doctorsService.saveDoctor(request);
    }

    @PostMapping("{doctorId}/departments")
    @ResponseStatus(HttpStatus.CREATED)
    public void addDepartmentToDoctor(@PathVariable long doctorId,
                                      @RequestBody DepartmentsRequest request) {
        doctorsService.addDepartmentToDoctor(doctorId, request);
    }

    @PostMapping("{doctorId}/patients")
    @ResponseStatus(HttpStatus.CREATED)
    public void addPatientToDoctor(@PathVariable long doctorId,
                                   @RequestBody PatientsRequest request) {
        doctorsService.addPatientToDoctor(doctorId, request);
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateDoctor(@PathVariable long id,
                             @RequestBody DoctorsRequest request) {
        doctorsService.updateDoctor(id, request);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteDoctor(@PathVariable long id) {
        doctorsService.deleteDoctor(id);
    }
}
