package com.comarch.comarch.endpoints;

import com.comarch.comarch.dto.AccountDto;
import com.comarch.comarch.entities.Account;
import com.comarch.comarch.entities.Transfer;
import com.comarch.comarch.services.AccountService;
import com.comarch.comarch.services.TransferService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/account", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class AccountEndpoints {

    private static final Logger LOGGER = LoggerFactory.getLogger(AccountEndpoints.class);

    @Autowired
    private AccountService accountService;


    @PutMapping("/add")
    @ResponseStatus(HttpStatus.OK)
    public void addAccount(@RequestBody AccountDto account) {
        LOGGER.debug("account add request : \n"+account.toString());
        accountService.addAccount(account);
    }

    @GetMapping("/amount/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String getAccountAmountById(@PathVariable Long id) {
        LOGGER.debug("account amount request for id : \n"+id);
        String amount=accountService.getAccountAmount(id);
        return amount;
    }

    @GetMapping("/transfer/{id}")
    @ResponseStatus(HttpStatus.OK)
    public List<Transfer> getAccountTransfersById(@PathVariable Long id) {
        LOGGER.debug("show transfers request for id : \n" + id);
        List<Transfer> transfers = accountService.getAllTransfer(id);
        return transfers;
    }

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<Account> getAllAccounts() {
        LOGGER.debug("get all accounts request");
        List<Account> accounts = accountService.getAllAccount();
        return accounts;
    }

}
