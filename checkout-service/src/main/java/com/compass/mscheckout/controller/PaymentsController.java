package com.compass.mscheckout.controller;

import com.compass.mscheckout.model.dto.PaymentsRequest;
import com.compass.mscheckout.model.dto.PaymentsResponse;
import com.compass.mscheckout.service.PaymentsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/payments")
@RequiredArgsConstructor
public class PaymentsController {

    private final PaymentsService paymentsService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createPayments(@RequestBody PaymentsRequest paymentsRequest){
        paymentsService.createPayments(paymentsRequest);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<PaymentsResponse> getAllPayments(){
        return paymentsService.getAllPayments();

    }

}
