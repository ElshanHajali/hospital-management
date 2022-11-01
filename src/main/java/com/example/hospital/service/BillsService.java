package com.example.hospital.service;

import com.example.hospital.dao.entity.BillsEntity;
import com.example.hospital.dao.repository.BillsRepository;
import com.example.hospital.mapper.factory.BillFactory;
import com.example.hospital.mapper.factory.ReceptionistFactory;
import com.example.hospital.model.request.BillsRequest;
import com.example.hospital.model.request.ReceptionistsRequest;
import com.example.hospital.model.response.BillsResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static com.example.hospital.mapper.BillMapper.MAP;

@Service
@Slf4j
@RequiredArgsConstructor
public class BillsService {
    private final BillsRepository billsRepository;

    public List<BillsResponse> getBills() {
        log.info("ActionLog.getBills.start");
        return billsRepository.findAll().stream()
                .map(MAP::entityToResponse)
                .collect(Collectors.toList());
    }

    public List<BillsEntity> getBills(Set<Long> billIds) {
        return billsRepository.findByNumIn(billIds);
    }

    public BillsResponse getBill(Long id) {
        log.info("ActionLog.getBill.start");
        return MAP.entityToResponse(fetchById(id));
    }

    public void saveBill(BillsRequest request) {
        log.info("ActionLog.saveBill.start");
        billsRepository.save(BillFactory.buildBillEntity(request));
        log.info("ActionLog.saveBill.success");
    }

    @Transactional
    public void addReceptionistToBill(Long billNo, ReceptionistsRequest request){
        log.info("ActionLog.addReceptionistToBill.start");
        var bill = fetchById(billNo);

        var receptionists = bill.getReceptionists();

        receptionists.add(
                ReceptionistFactory.buildReceptionistEntity(request, bill)
        );

        bill.setReceptionists(receptionists);
        log.info("Test-4");

        billsRepository.save(bill);
        log.info("ActionLog.addReceptionistToBill.success");
    }

    public void updateBill(Long id, BillsRequest request) {
        log.info("ActionLog.updateBill.start");
        var bill = fetchById(id);

        MAP.updateBillFields(bill, request);

        billsRepository.save(bill);
        log.info("ActionLog.updateBill.success");
    }

    public void deleteBill(Long id) {
        log.info("ActionLog.deleteBill.start");
        billsRepository.deleteById(id);
        log.info("ActionLog.deleteBill.success");
    }

    private BillsEntity fetchById(Long id) {
        return billsRepository.findById(id)
                .orElseThrow(RuntimeException::new);
    }
}
