package com.ms.history.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import javax.persistence.Transient;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "payment")
public class Payment {

    @Transient
    public static final String SEQUENCE_NAME = "payments_sequence";

    @Id
    private Long payment_id;

    private String type;
    private Double discount;
    private Boolean status;

}
