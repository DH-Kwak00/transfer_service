package com.example.kakao.account.service;

import com.example.kakao.account.domain.Account;
import com.example.kakao.account.repositroy.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {
    private final AccountRepository accountRepository;

    @Autowired
    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }
    public void create(Account account){
        accountRepository.save(account);
    }
    public void getAccountById(long id) {
        accountRepository.findById(id);
    }
    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }
    public Account findByAccount(Long account){
        return accountRepository.findByAccount(account).orElseThrow(null);
    }
}
