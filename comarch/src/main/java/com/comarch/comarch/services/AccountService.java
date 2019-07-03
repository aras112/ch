package com.comarch.comarch.services;

import com.comarch.comarch.dao.AccountDao;
import com.comarch.comarch.dto.AccountDto;
import com.comarch.comarch.entities.Account;
import com.comarch.comarch.entities.Transfer;
import com.comarch.comarch.entities.User;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class AccountService {

    private AccountDao accountDao;
    private ModelMapper modelMapper;
    private UserService userService;

    @Autowired
    public AccountService(AccountDao accountDao, UserService userService) {
        this.accountDao = accountDao;
        this.userService = userService;
        modelMapper = new ModelMapper();
    }

    public void addAccount(AccountDto account) {
        accountDao.save(mapToEntity(account));
    }

    public List<Account> getAllAccount() {
        return accountDao.findAll();
    }

    public Account getAccountById(Long id) {
        // TODO: 03.07.2019 wyjatek jak brak o tym id
        return accountDao.getOne(id);
    }

    public String getAccountAmount(Long id) {
        Account account = getAccountById(id);
        String amount = account.getAmount().toString();
        amount = addCurrencyToAmountString(account, amount);
        return amount;
    }

    public List<Transfer> getAllTransfer(Long id) {
        Account account = getAccountById(id);
        return account.getTransfersOut();
    }

    private Account mapToEntity(AccountDto account) {
        Account entity = modelMapper.map(account, Account.class);
        entity.setAmount(BigDecimal.ZERO);
        // TODO: 03.07.2019 wyjatek jesli nie ma usera o tym id
        // TODO: 03.07.2019 czy ma 26 znakow numer ?
        User user = userService.findUserById(account.getUserId()).get();
        entity.setUser(user);
        return entity;
    }

    private AccountDto mapToDto(Account account) {
        AccountDto dto = modelMapper.map(account, AccountDto.class);
        dto.setUserId(account.getUser().getId());
        return dto;
    }

    private String addCurrencyToAmountString(Account account, String amount) {
        amount = amount + " " + account.getCurrency().toString();
        return amount;
    }
}
