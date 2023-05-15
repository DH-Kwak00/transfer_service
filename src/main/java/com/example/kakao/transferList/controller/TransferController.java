package com.example.kakao.transferList.controller;

import com.example.kakao.transferList.domain.Transfer;
import com.example.kakao.transferList.domain.TransferDto;
import com.example.kakao.account.service.AccountService;
import com.example.kakao.transferList.service.TransferService;
import com.example.kakao.user_Info.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
//송금 테이블

@Controller
public class TransferController {

    private final UserService userService;
    private final AccountService accountService;
    private final TransferService transferService;

    @Autowired
    public TransferController(UserService userService, AccountService accountService, TransferService transferService) {
        this.userService = userService;
        this.accountService = accountService;
        this.transferService = transferService;
    }

    @PostMapping("/transfer")
    @ResponseBody
    public String send(@RequestBody TransferDto transferDto) throws Exception{
//        Transfer transferTmp = Transfer.builder()
//                .name(transferDto.getName())
//                .amount(transferDto.getAmount())
//                .nation(transferDto.getNation())
//                .currency(transferDto.getCurrency())
//                .receiverName(transferDto.getReceiverName())
//                .targetAccount(transferDto.getTargetAccount())
//                .receiverAddress(transferDto.getReceiverAddress())
//                .exchangeRate(transferDto.getExchangeRate())
//                .build();

        transferService.transfer(transferDto);
        return "ok";
    }

}
