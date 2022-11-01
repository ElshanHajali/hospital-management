package com.example.hospital.service;

import com.example.hospital.dao.entity.DepartmentsEntity;
import com.example.hospital.dao.entity.DoctorsEntity;
import com.example.hospital.dao.repository.DepartmentsRepository;
import com.example.hospital.mapper.factory.DepartmentFactory;
import com.example.hospital.model.request.DepartmentsRequest;
import com.example.hospital.model.response.DepartmentsResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.example.hospital.mapper.DepartmentMapper.MAP;
import static com.example.hospital.mapper.factory.DepartmentFactory.buildDepartmentEntity;

@Service
@Slf4j
@RequiredArgsConstructor
public class DepartmentsService {
    private final DepartmentsRepository departmentsRepository;

    public List<DepartmentsResponse> getDepartments() {
        log.info("ActionLog.getDepartments.start");
        return departmentsRepository.findAll().stream()
                .map(MAP::entityToResponse)
                .collect(Collectors.toList());
    }

    public DepartmentsResponse getDepartment(Long id) {
        log.info("ActionLog.getDepartment.start");
        return MAP.entityToResponse(fetchDepartmentById(id));
    }

    public void saveDepartment(DoctorsEntity doctor, DepartmentsRequest request) {
        log.info("ActionLog.saveDepartment.start");

        departmentsRepository.save(buildDepartmentEntity(doctor, request));

        log.info("ActionLog.saveDepartment.success");
    }

    public void updateDepartment(long id, DepartmentsRequest request) {
        log.info("ActionLog.updateDepartment.start");
        var department = fetchDepartmentById(id);

        MAP.updateDepartmentFields(department, request);

        departmentsRepository.save(department);
        log.info("ActionLog.updateDepartment.success");
    }

    public void deleteDepartment(long id) {
        log.info("ActionLog.deleteDepartment.start");
        departmentsRepository.deleteById(id);
        log.info("ActionLog.deleteDepartment.success");
    }

    public DepartmentsEntity fetchDepartmentById(long id) {
        return departmentsRepository.findById(id)
                .orElseThrow(RuntimeException::new);
    }
}
