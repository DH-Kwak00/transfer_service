package com.example.kakao.transferList.domain;

import com.example.kakao.account.domain.Account;
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
public class Transfer {
    @Id
    @GeneratedValue

    private Long id;
    private String name; //송금인
    private BigDecimal amount;
    private String nation;
    private String currency; //화폐
    private String receiverName; //수신인
    private Long targetAccount; //수신인 계좌
//    private String receiverState;
//    private String receiverCity;
    private String receiverAddress;
    private BigDecimal exchangeRate; //환율 $ : 1100
    @Setter
    private  BigDecimal fee;
    @Setter
    private BigDecimal total;

    @ManyToOne
    @JoinColumn(nullable = false, name = "userId", referencedColumnName = "id")
    private User user;

    @ManyToOne
    @JoinColumn(nullable = false, name = "accountId", referencedColumnName = "id")
    private Account account;


//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(nullable = false, name = "sender_account_id")
//    private Account sender;
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(nullable = false, name = "receiver_account_id")
//    private Account receiver;


    @Builder
    public Transfer(User user, Account account, String name, BigDecimal amount, String nation,
                    String currency, String receiverName, Long targetAccount,
                    String receiverAddress, BigDecimal exchangeRate, BigDecimal fee, BigDecimal total){

        this.user = user;
        this.account = account;
        this.name = name;
        this.amount = amount;
        this.nation = nation;
        this.currency = currency;
        this.receiverName = receiverName;
        this.targetAccount = targetAccount;
        this.receiverAddress = receiverAddress;
        this.exchangeRate = exchangeRate;
        this.fee = fee;
        this.total = total;

    }
}
