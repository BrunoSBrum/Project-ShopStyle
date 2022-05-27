package com.ms.customer.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ms.customer.model.validation.SexValidation;
import lombok.*;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
@Table(name = "customer")
public class User implements UserDetails {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min = 3, message = "minimum number of characters allowed are 3")
    @NotNull(message = "The Field cannot be null" )
    @Column(name="firstName")
    private String firstName;

    @Size(min = 3, message = "minimum number of characters allowed are 3")
    @NotNull(message = "The Field cannot be null" )
    @Column(name="lastName")
    private String lastName;

    @SexValidation
    @Column(name="Sex")
    private String sex;

    @NotNull(message = "The Field cannot be null")
    @CPF(message = "CPF invalid")
    @Column(name = "cpf")
    private String cpf;

    @Column(name="birthdate")
    @NotNull(message = "The Field cannot be null" )
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate birthDate;

    @Email
    @Column(name="email")
    private String email;

    @NotNull(message = "The Field cannot be null")
    @Column(name="password")
    @Size(min = 8, message = "minimum number of characters allowed are 8")
    private String password;

    @NotNull(message = "The Field cannot be null")
    @Column(name="active")
    private Boolean active;


    @ManyToMany(fetch = FetchType.EAGER)
    private List<Perfil> perfil = new ArrayList<>();

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.perfil;
    }

    @Override
    public String getPassword(){
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.firstName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
