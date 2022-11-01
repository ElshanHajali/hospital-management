package com.example.hospital.service;

import com.example.hospital.dao.entity.DoctorsEntity;
import com.example.hospital.dao.entity.PatientsEntity;
import com.example.hospital.dao.repository.DoctorsRepository;
import com.example.hospital.mapper.factory.DepartmentFactory;
import com.example.hospital.mapper.factory.DoctorFactory;
import com.example.hospital.mapper.factory.PatientFactory;
import com.example.hospital.model.request.DepartmentsRequest;
import com.example.hospital.model.request.DoctorsRequest;
import com.example.hospital.model.request.PatientsRequest;
import com.example.hospital.model.response.DoctorsResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static com.example.hospital.mapper.DoctorMapper.MAP;

@Service
@Slf4j
@RequiredArgsConstructor
public class DoctorsService {
    private final DoctorsRepository doctorsRepository;

    public List<DoctorsResponse> getDoctors() {
        log.info("ActionLog.getDoctors.start");
        return doctorsRepository.findAll().stream()
                .map(MAP::entityToResponse)
                .collect(Collectors.toList());
    }

    public DoctorsResponse getDoctor(long id) {
        log.info("ActionLog.getDoctor.start");
        return MAP.entityToResponse(fetchDoctorById(id));
    }

    public void saveDoctor(DoctorsRequest request) {
        log.info("ActionLog.saveDoctor.start");
        doctorsRepository.save(DoctorFactory.buildDoctorEntity(request));
        log.info("ActionLog.saveDoctor.success");
    }

    @Transactional
    public void addDepartmentToDoctor(Long doctorId,
                                      DepartmentsRequest departmentDto) {
        log.info("ActionLog.addDoctorToDepartment.start");
        var doctor = fetchDoctorById(doctorId);
        var departments = doctor.getDepartments();

        if (Objects.nonNull(departmentDto)
        ) {
            departments.add(DepartmentFactory
                    .buildDepartmentEntity(doctor, departmentDto));

            doctor.setDepartments(departments);
        }

        doctorsRepository.save(doctor);
        log.info("ActionLog.addDoctorToDepartment.success");
    }

    @Transactional
    public void addPatientToDoctor(Long doctorId, PatientsRequest request) {
        log.info("ActionLog.addDoctorToDepartment.start");
        var doctor = fetchDoctorById(doctorId);
        var patients = doctor.getPatients();

        if (Objects.nonNull(request)) {
            patients.add(PatientFactory.buildPatientEntity(request, doctor));

            doctor.setPatients(patients);
            if (doctor.isAvailable()) doctor.setAvailable(!doctor.isAvailable());
        }

        doctorsRepository.save(doctor);
        log.info("ActionLog.addDoctorToDepartment.success");
    }

    public void updateDoctor(long id, DoctorsRequest request) {
        log.info("ActionLog.updateDoctor.start");
        var doctor = fetchDoctorById(id);

        MAP.updateDoctorFields(doctor, request);

        doctorsRepository.save(doctor);
        log.info("ActionLog.updateDoctor.success");
    }

    public void deleteDoctor(long id) {
        log.info("ActionLog.deleteDoctor.start");
        doctorsRepository.deleteById(id);
        log.info("ActionLog.deleteDoctor.success");
    }

    // prescribeMeds()
    // checkReports()
    // prescribeTest()
    // (receive) drawSalary()

    private DoctorsEntity fetchDoctorById(long id) {
        return doctorsRepository.findById(id)
                .orElseThrow(RuntimeException::new);
    }
}
