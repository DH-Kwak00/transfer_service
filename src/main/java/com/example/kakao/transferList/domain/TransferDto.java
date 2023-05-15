package com.example.kakao.transferList.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class TransferDto {
    private Long id;
    private String name;
    private String email;
    private Long account;
    private BigDecimal amount;
    private String nation;
    private String currency;
    private String receiverName;
    private Long targetAccount;
    private String receiverAddress;
    private BigDecimal exchangeRate;
    private BigDecimal fee;
    private BigDecimal total;
}
