package com.bcmw.flash_card.account.impl;

import com.bcmw.flash_card.account.Account;
import com.bcmw.flash_card.account.AccountRepository;
import com.bcmw.flash_card.account.AccountService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AccountServiceImpl implements AccountService {

    private AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) { this.accountRepository = accountRepository; }

    @Override
    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    @Override
    public Account getAccountById(UUID id) {
        return accountRepository.findById(id).orElse(null);
    }

    @Override
    public void createAccount(Account account) {
        accountRepository.save(account);
    }

    @Override
    public boolean updateAccount(UUID id, Account updatedAccount) {
        Optional<Account> accountOptional = accountRepository.findById(id);
        if(accountOptional.isPresent()) {
            Account account = accountOptional.get();
            account.setFirstName(updatedAccount.getFirstName());
            account.setLastName(updatedAccount.getLastName());
            account.setLoginName(updatedAccount.getLoginName());
            account.setPasswordHash(updatedAccount.getPasswordHash());
            account.setCards(updatedAccount.getCards());
            accountRepository.save(account);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteAccount(UUID id) {
        if (accountRepository.existsById(id)) {
            accountRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
