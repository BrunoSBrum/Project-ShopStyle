package com.mscatalog.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Transient;
import java.util.ArrayList;
import java.util.List;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(value = "category")
public class Category {

    @Transient
    public static final String SEQUENCE_NAME = "categories_sequence";

    @Id
    private Long category_id;
    private String name;
    private Boolean active;

    @ManyToMany
    private List<Long> product = new ArrayList<>();

}
