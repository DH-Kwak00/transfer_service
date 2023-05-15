package com.example.kakao.account.domain;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class AccountDto {
    private String name;
    private String email;
    private Long account;
    private BigDecimal balance;

}
