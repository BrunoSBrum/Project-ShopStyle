package com.ms.history.model.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PurchaseResponse {

    private Long purchase_id;
    private Long user_id;
    private Double Total;
    private List<ProductResponse> products;
}
