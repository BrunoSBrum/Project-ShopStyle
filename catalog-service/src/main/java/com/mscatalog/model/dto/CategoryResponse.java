package com.mscatalog.model.dto;

import com.mscatalog.model.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CategoryResponse {

    private Object category_id;
    private String name;
    private Boolean active;
    private Product product;

}
