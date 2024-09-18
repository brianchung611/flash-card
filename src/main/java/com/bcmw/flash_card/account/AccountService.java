package com.bcmw.flash_card.account;

import java.util.List;
import java.util.UUID;

public interface AccountService {
    List<Account> getAllAccounts();

    Account getAccountById(UUID id);

    void createAccount(Account account);

    boolean updateAccount(UUID id, Account account);

    boolean deleteAccount(UUID id);
}
