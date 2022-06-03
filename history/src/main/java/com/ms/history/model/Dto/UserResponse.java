package com.ms.history.model.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserResponse {

    private Long user_id;
    private String firstName;
    private String lastName;
    private String sex;
    private String cpf;
    private LocalDate birthDate;
    private String email;

}
