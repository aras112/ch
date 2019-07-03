package com.comarch.comarch.dto;

import lombok.Data;

@Data
public class AccountDto {
    private Long id;
    private Long userId;
    private String accountNumber;
    private String currency;
    private Boolean active = false;
}


