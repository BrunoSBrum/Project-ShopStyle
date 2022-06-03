package com.ms.history.model.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HistoryResponse {

    private UserResponse user;
    private List<PurchaseResponse> purchases;


}
