package com.example.kakao.transferList.service;

import com.example.kakao.account.domain.Account;
import com.example.kakao.account.repositroy.AccountRepository;
import com.example.kakao.transferList.domain.Transfer;
import com.example.kakao.transferList.domain.TransferDto;
import com.example.kakao.transferList.repository.TransferRepository;
import com.example.kakao.user_Info.domain.User;
import com.example.kakao.user_Info.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;

@Service
public class TransferService {
    private final UserService userService;
    private final AccountRepository accountRepository;
    private final TransferRepository transferRepository;

    @Autowired
    public TransferService(UserService userService, AccountRepository accountRepository,
                           TransferRepository transferRepository) {
        this.userService = userService;
        this.accountRepository = accountRepository;
        this.transferRepository = transferRepository;
    }

//    public void save(TransferDto transferDto){
//        transferRepository.save(TransferDto);
//    }
    @Transactional
    public void transfer(TransferDto transferDto){ //조회
        User user = userService.findByEmail(transferDto.getEmail());
        Account account = accountRepository.findById(transferDto.getId()).orElse(null);


        Transfer transfer = Transfer.builder()
                .user(user)
                .account(account)
                .name(transferDto.getName())
                .amount(transferDto.getAmount())
                .nation(transferDto.getNation())
                .currency(transferDto.getCurrency())
                .receiverName(transferDto.getReceiverName())
                .receiverAddress(transferDto.getReceiverAddress())
                .exchangeRate(transferDto.getExchangeRate())
                .fee(transferDto.getFee())
                .build();

        // 수수료
        if (transfer.getAmount().compareTo(BigDecimal.valueOf(5000)) < 0){
            transfer.setFee(BigDecimal.valueOf(5000));
        }else {
            transfer.setFee(BigDecimal.valueOf(10000));
        }

        // 예상 총 금액
        transfer.setTotal(transfer.getAmount()
                .multiply(transfer.getExchangeRate()).add(transfer.getFee()));

        // 이체금액이 잔금보다 적을때
        if (account.getBalance().compareTo(transfer.getAmount()
                .multiply(transfer.getExchangeRate())) <= 0){
            String txt = "계좌에 잔액이 없습니다.";
        }else {
            account.withdraw(transfer.getAmount()); //출금
        }

        accountRepository.save(account); // 레파짓토리에 저장
        transferRepository.save(transfer);


    }


}
