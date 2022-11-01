package com.example.hospital.service;

import com.example.hospital.dao.entity.BillsEntity;
import com.example.hospital.dao.entity.PatientDetailsEntity;
import com.example.hospital.dao.entity.PatientsEntity;
import com.example.hospital.dao.entity.RoomsEntity;
import com.example.hospital.dao.repository.PatientsRepository;
import com.example.hospital.mapper.factory.PatientDetailFactory;
import com.example.hospital.mapper.factory.PatientFactory;
import com.example.hospital.model.request.PatientDetailsRequest;
import com.example.hospital.model.request.PatientsRequest;
import com.example.hospital.model.response.PatientsResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import static com.example.hospital.mapper.PatientMapper.MAP;

@Service
@Slf4j
@RequiredArgsConstructor
public class PatientsService {
    private final PatientsRepository patientsRepository;
    private final RoomsService roomsService;
    private final BillsService billsService;

    public List<PatientsResponse> getPatients() {
        log.info("ActionLog.getPatients.start");
        return patientsRepository.findAll().stream()
                .map(MAP::entityToResponse)
                .collect(Collectors.toList());
    }

    public PatientsResponse getPatient(long id) {
        log.info("ActionLog.getPatient.start");
        return MAP.entityToResponse(fetchPatientById(id));
    }

    public void savePatient(PatientsRequest request) {
        log.info("ActionLog.savePatient.start");
        var patient = PatientFactory.buildPatientEntity(request);
        var patientDetail = PatientDetailFactory
                .buildPatientDetailEntity(patient, request.getDetailsRequestDto());

        var bills = billsService.getBills(request.getBillNo());
        var rooms = roomsService.getRooms(request.getRoomNo());

        MAP.setRelationsToPatient(patient, bills, rooms, patientDetail);

        patientsRepository.save(patient);
        log.info("ActionLog.savePatient.success");
    }

    public void addDetailToPatient(Long id, PatientDetailsRequest request) {
        log.info("ActionLog.addDetailToPatient.start");
        var patient = fetchPatientById(id);

        patient.setPatientDetail(PatientDetailFactory
                .buildPatientDetailEntity(patient, request)
        );

        patientsRepository.save(patient);
        log.info("ActionLog.addDetailToPatient.success");
    }

    public void addRoomsToPatient(Long patientId, Set<Long> roomNo) {
        log.info("ActionLog.addRoomToPatient.start");
        var patient = fetchPatientById(patientId);
        var rooms = roomsService.getRooms(roomNo);

        patient.setRooms(rooms);

        patientsRepository.save(patient);
        log.info("ActionLog.addRoomToPatient.success");
    }

    public void addBillsToPatient(Long patientId, Set<Long> billNo) {
        log.info("ActionLog.addBillToPatient.start");
        var patient = fetchPatientById(patientId);
        var bills = billsService.getBills(billNo);

        patient.setBills(bills);

        patientsRepository.save(patient);
        log.info("ActionLog.addBillToPatient.success");
    }

    public void updatePatient(long id, PatientsRequest request) {
        log.info("ActionLog.updatePatient.start");
        var patient = fetchPatientById(id);

        MAP.updatePatientFields(patient, request);

        patientsRepository.save(patient);
        log.info("ActionLog.updatePatient.success");
    }

    public void updatePatientDetails(long id, PatientDetailsRequest request) {
        log.info("ActionLog.updatePatient.start");
        var patient = fetchPatientById(id);
        var patientDetail = patient.getPatientDetail();

        MAP.updatePatientDetailFields(patientDetail, request);

        patient.setPatientDetail(patientDetail);

        patientsRepository.save(patient);
        log.info("ActionLog.updatePatient.success");
    }

    public void deletePatient(long id) {
        log.info("ActionLog.deletePatient.start");
        patientsRepository.deleteById(id);
        log.info("ActionLog.deletePatient.success");
    }

    // payBills()

    private PatientsEntity fetchPatientById(long id) {
        return patientsRepository.findById(id)
                .orElseThrow(RuntimeException::new);
    }
}
