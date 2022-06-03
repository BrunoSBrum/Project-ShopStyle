package com.ms.history.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import javax.persistence.Id;
import javax.persistence.Transient;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "purchases")
public class Purchase {

    @Transient
    public static final String SEQUENCE_NAME = "purchases_sequence";

    @Id
    private Long purchase_id;
    private Long user_id;
    private Payment payment;
    @DocumentReference
    private List<Product> products;
    private Double total;
    private String date;
}
