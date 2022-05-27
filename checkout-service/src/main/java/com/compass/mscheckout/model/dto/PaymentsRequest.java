package com.compass.mscheckout.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PaymentsRequest {
    private String type;
    private Double discount;
    private Boolean status;
}
