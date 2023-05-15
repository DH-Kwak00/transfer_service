package com.example.kakao.account.controller;

import com.example.kakao.account.domain.Account;
import com.example.kakao.account.domain.AccountDto;
import com.example.kakao.account.service.AccountService;
import com.example.kakao.user_Info.domain.User;
import com.example.kakao.user_Info.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AccountController {
    private final AccountService accountService;
    private final UserService userService;

    public AccountController(AccountService accountService, UserService userService) {
        this.accountService = accountService;
        this.userService = userService;
    }

    @PostMapping("/account/create")
    @ResponseBody
    public void create(@RequestBody AccountDto accountDto){
//        User user = userService.findByEmail(accountDto.getEmail());
        Account account = Account.builder()
                .name(accountDto.getName())
                .account(accountDto.getAccount())
                .balance(accountDto.getBalance())
                .user(userService.findByEmail(accountDto.getEmail()))
                .build();
        accountService.create(account);
    }
}
