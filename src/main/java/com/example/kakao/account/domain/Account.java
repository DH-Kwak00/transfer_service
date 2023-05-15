package com.example.kakao.account.domain;

import com.example.kakao.user_Info.domain.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Getter
@NoArgsConstructor
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private Long account;
    @Setter
    private BigDecimal balance; //잔액

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id", referencedColumnName = "id")
    private User user;

    public BigDecimal withdraw(BigDecimal amount) { //출금
        balance = balance.subtract(amount);
        return amount;
    }

    public BigDecimal deposit(BigDecimal amount) { //입금
        balance = balance.add(amount);
        return amount;
    }

    @Builder
    public Account(String name, String email, Long account, BigDecimal balance, User user){
        this.name = name;
        this.email = email;
        this.account = account;
        this.balance = balance;
        this.user = user;
    }

}
