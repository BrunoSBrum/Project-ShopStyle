package com.compass.mscheckout.service;

import com.compass.mscheckout.model.Payments;
import com.compass.mscheckout.model.dto.PaymentsRequest;
import com.compass.mscheckout.model.dto.PaymentsResponse;
import com.compass.mscheckout.repository.PaymentsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class PaymentsService {

    private final PaymentsRepository paymentsRepository;

    public void createPayments(PaymentsRequest paymentsRequest) {
        Payments payments = Payments.builder()
                .type(paymentsRequest.getType())
                .discount(paymentsRequest.getDiscount())
                .status(paymentsRequest.getStatus())
                .build();

        paymentsRepository.save(payments);
        //log.info("Payments {} is saved", payments.getId());

    }

    public List<PaymentsResponse> getAllPayments() {
        List<Payments> payments = paymentsRepository.findAll();

        return payments.stream().map(this::mapToPaymentsResponse).toList();
    }

    private PaymentsResponse mapToPaymentsResponse(Payments payments) {
        return PaymentsResponse.builder()
                .id(payments.getId())
                .type(payments.getType())
                .discount(payments.getDiscount())
                .status(payments.getStatus())
                .build();
    }

}
