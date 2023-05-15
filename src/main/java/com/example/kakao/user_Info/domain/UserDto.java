package com.example.kakao.user_Info.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import java.math.BigDecimal;

@Getter
@Setter
public class UserDto {
    private String name;
    private String email;
    private String password;
    private String fileUploadYn;
    private BigDecimal userRate;
}
