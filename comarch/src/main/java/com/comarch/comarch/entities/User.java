package com.comarch.comarch.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.List;

@Entity
@Data
@ToString(exclude = "accounts")
@NoArgsConstructor

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    @Size(min = 4, max = 20)
    @NotNull(message = "name is null")
    private String name;

    @Size(min = 4, max = 20)
    @NotNull(message = "surname   is null")
    private String surname;

    @Min(18)
    @Max(150)
    @NotNull
    private Integer age;

    @NotNull
    private Boolean active = false;

    @JsonIgnore
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, targetEntity = Account.class)
    private List<Account> accounts;

    @Email
    private String email;
}
