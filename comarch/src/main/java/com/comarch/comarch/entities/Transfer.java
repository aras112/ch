package com.comarch.comarch.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Pattern;
import java.math.BigDecimal;

@Entity
@Data
@NoArgsConstructor
public class Transfer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Enumerated(EnumType.STRING)
    private Currency currency;

    @DecimalMin("0.0")
    private BigDecimal amount;

    @ManyToOne(targetEntity = Account.class)
    private Account fromAccount;

    @ManyToOne(targetEntity = Account.class)
    private Account toAccount;
}
