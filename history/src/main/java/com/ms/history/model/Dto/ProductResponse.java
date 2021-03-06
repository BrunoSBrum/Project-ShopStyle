package com.ms.history.model.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponse {

    private String name;
    private String description;
    private String color;
    private String size;
    private Double price;
    private Integer quantity;
}
