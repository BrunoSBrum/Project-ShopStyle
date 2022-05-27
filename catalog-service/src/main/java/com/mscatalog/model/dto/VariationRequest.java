package com.mscatalog.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VariationRequest {

    private String color;
    private String size;
    private BigDecimal price;
    private Integer quantity;
    private List product_id;

}
