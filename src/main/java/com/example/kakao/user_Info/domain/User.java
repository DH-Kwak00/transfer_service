package com.example.kakao.user_Info.domain;

import com.example.kakao.account.domain.Account;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    @Column(length = 20)
    private String name;
    @Column(length = 50, unique = true)
    private String email;
    private String password;
//    @Column()
//    private Boolean evidence; //인증 파일 업로드
    @Setter
    private String fileUploadYn;
    private BigDecimal userRate;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<Account> accounts = new ArrayList<>();


    @Builder
    public User(String name, String email, String password,
                String fileUploadYn, BigDecimal userRate){
        this.name = name;
        this.email = email;
        this.password = password;
        this.fileUploadYn = fileUploadYn;
        this.userRate = userRate;
    }

}
