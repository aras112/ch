package com.comarch.comarch.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.math.BigDecimal;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(targetEntity = User.class)
    private User user;

    @JsonIgnore
    @OneToMany(mappedBy = "fromAccount")
    private List<Transfer> transfersOut;

    @JsonIgnore
    @OneToMany(mappedBy = "toAccount")
    private List<Transfer> transfersIn;

    @Pattern(regexp = "\\d{26}",message = "account number doesnt have correct length")
    private String accountNumber;

    @Enumerated(EnumType.STRING)
    private Currency currency;

    @DecimalMin(value = "0.0",message = "less than 0")
    private BigDecimal amount;

    @NotNull(message = "cant be null")
    private Boolean active = false;
}