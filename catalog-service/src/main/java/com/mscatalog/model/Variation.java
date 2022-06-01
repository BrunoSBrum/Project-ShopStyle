package com.mscatalog.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(value = "variation")
public class Variation {

    @Transient
    public static final String SEQUENCE_NAME = "variant_id";

    @Id
    private Long variation_id;

    @NotNull(message = "the field cannot be null")
    @NotBlank(message = "the field cannot be empty")
    private String color;

    @NotNull(message = "the field cannot be null")
    @NotBlank(message = "the field cannot be empty")
    private String size;

    @NotNull(message = "the field cannot be null")
    @NotBlank(message = "the field cannot be empty")
    private BigDecimal price;

    @NotNull(message = "the field cannot be null")
    @NotBlank(message = "the field cannot be empty")
    private Integer quantity;

    @ManyToOne
    private Product product_id;

}
