package com.comarch.comarch.dto;

import lombok.Data;

@Data
public class TransferDto {

    private Long id;
    private String currency;
    private String amount;
    private Long fromAccount;
    private Long toAccount;
}


