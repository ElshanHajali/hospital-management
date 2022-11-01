package com.example.hospital.controller;

import com.example.hospital.model.response.DepartmentsResponse;
import com.example.hospital.service.DepartmentsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("v1/departments")
@RequiredArgsConstructor
public class DepartmentsController {
    private final DepartmentsService departmentsService;

    @GetMapping
    public List<DepartmentsResponse> getDepartments() {
        return departmentsService.getDepartments();
    }

    @GetMapping("{id}")
    public DepartmentsResponse getDepartment(@PathVariable long id) {
        return departmentsService.getDepartment(id);
    }
}
