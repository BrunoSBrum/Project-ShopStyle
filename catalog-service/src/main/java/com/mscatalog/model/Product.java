package com.mscatalog.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(value = "Product")
public class Product {

    @Id
    private String product_id;

    @NotNull(message = "the field cannot be null")
    @NotBlank(message = "the field cannot be empty")
    private String name;

    @NotNull(message = "the field cannot be null")
    @NotBlank(message = "the field cannot be empty")
    private String description;

    @NotNull(message = "the field cannot be null")
    @NotBlank(message = "the field cannot be empty")
    private Boolean active;

    @OneToMany
    @JoinColumn(name = "variation_id")
    private List<Variation> variation = new ArrayList<>();

    @ManyToMany
    private List<Category> category_ids;

}
