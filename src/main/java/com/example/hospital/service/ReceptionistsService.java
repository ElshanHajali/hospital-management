package com.example.hospital.service;

import com.example.hospital.dao.entity.PatientsEntity;
import com.example.hospital.dao.entity.ReceptionistsEntity;
import com.example.hospital.dao.repository.ReceptionistsRepository;
import com.example.hospital.mapper.ReceptionistMapper;
import com.example.hospital.mapper.factory.PatientFactory;
import com.example.hospital.model.request.PatientsRequest;
import com.example.hospital.model.request.ReceptionistsRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.example.hospital.mapper.ReceptionistMapper.MAP;

@Service
@Slf4j
@RequiredArgsConstructor
public class ReceptionistsService {
    private final ReceptionistsRepository receptionistsRepository;

    public void updateReceptionist(long id, ReceptionistsRequest request) {
        log.info("ActionLog.updateReceptionist.start");
        var receptionist = fetchReceptionistById(id);

        MAP.updateReceptionistFields(receptionist, request);

        receptionistsRepository.save(receptionist);
        log.info("ActionLog.updateReceptionist.success");
    }

    public void addPatientToReceptionist(Long receptionistId,
                                         PatientsRequest request){
        log.info("ActionLog.addPatientToReceptionist.start");
        var receptionist =
                fetchReceptionistById(receptionistId);
        var patients = receptionist.getPatients();

        patients.add(PatientFactory.buildPatientEntity(request, receptionist));

        receptionist.setPatients(patients);

        receptionistsRepository.save(receptionist);
        log.info("ActionLog.addPatientToReceptionist.success");
    }

    // checkRoomAvailability()
    // bookRoom()
    // generateBill()
    // maintainPatientDetails()
    // (receive) drawSalary()

    public ReceptionistsEntity fetchReceptionistById(long id) {
        return receptionistsRepository.findById(id)
                .orElseThrow(RuntimeException::new);
    }
}
