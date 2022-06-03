package com.ms.history.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "user")
public class User {

    @Id
    private Long user_id;
    private Long history_id;
    private String firstName;
    private String lastName;
    private String sex;
    private String cpf;
    private String birthdate;
    private String email;


}
