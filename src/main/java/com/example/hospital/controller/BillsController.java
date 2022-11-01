package com.example.hospital.controller;

import com.example.hospital.model.request.BillsRequest;
import com.example.hospital.model.request.ReceptionistsRequest;
import com.example.hospital.model.response.BillsResponse;
import com.example.hospital.service.BillsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/bills")
@RequiredArgsConstructor
public class BillsController {
    private final BillsService billsService;

    @GetMapping
    public List<BillsResponse> getBills() {
        return billsService.getBills();
    }

    @GetMapping("{id}")
    public BillsResponse getBill(@PathVariable long id) {
        return billsService.getBill(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void saveBill(@RequestBody BillsRequest request) {
        billsService.saveBill(request);
    }

    @PostMapping("/{billNo}/receptionists")
    @ResponseStatus(HttpStatus.CREATED)
    public void addReceptionistToBill(@PathVariable Long billNo,
                                      @RequestBody ReceptionistsRequest request) {
        billsService.addReceptionistToBill(billNo, request);
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateBill(@PathVariable long id,
                           @RequestBody BillsRequest request) {
        billsService.updateBill(id, request);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBill(@PathVariable long id) {
        billsService.deleteBill(id);
    }
}
