package com.ms.history.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import javax.persistence.Transient;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(collection = "products")
public class Product {

    @Transient
    public static final String SEQUENCE_NAME = "products_sequence";

    @Id
    private Long product_id;

    private Long purchase_id;

    private String name;
    private String description;
    private String color;
    private String size;
    private Double price;
    private Integer quantity;



}
