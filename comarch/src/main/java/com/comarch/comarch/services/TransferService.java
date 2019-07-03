package com.comarch.comarch.services;

import com.comarch.comarch.dao.TransferDao;
import com.comarch.comarch.dto.TransferDto;
import com.comarch.comarch.entities.Account;
import com.comarch.comarch.entities.Transfer;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;


@Service
@Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.SERIALIZABLE)
public class TransferService {

    private TransferDao transferDao;
    private UserService userService;
    private AccountService accountService;
    private ModelMapper modelMapper;

    @Autowired
    public TransferService(TransferDao transferDao, UserService userService, AccountService accountService) {
        this.transferDao = transferDao;
        this.userService = userService;
        this.accountService = accountService;
        modelMapper = new ModelMapper();
    }

    public void transferMoney(TransferDto transferDto) {
        Transfer transfer = mapToEntity(transferDto);
        Account from=transfer.getFromAccount();
        Account to=transfer.getToAccount();

        // TODO: 03.07.2019 sprawdzic czy wystarczajacy ilosc gotowki
        // TODO: 03.07.2019 czy user id sie nie jest taki sam
        swapMoney(transfer, from, to);

        transferDao.save(transfer);
    }

    private void swapMoney(Transfer transfer, Account from, Account to) {
        BigDecimal transferAmount = transfer.getAmount();
        from.setAmount(from.getAmount().subtract(transferAmount));
        to.setAmount(to.getAmount().add(transferAmount));
    }

    private Transfer mapToEntity(TransferDto transfer) {
        Transfer transferEntity = modelMapper.map(transfer, Transfer.class);
        // TODO: 03.07.2019 blad jezeli nie ma o tym id
        Account from=accountService.getAccountById(transfer.getFromAccount());
        Account to=accountService.getAccountById(transfer.getToAccount());

        transferEntity.setFromAccount(from);
        transferEntity.setToAccount(to);

        return transferEntity;
    }
    private TransferDto mapToDto(Transfer transfer){
        TransferDto dto = modelMapper.map(transfer,TransferDto.class);
        dto.setFromAccount(transfer.getFromAccount().getId());
        dto.setToAccount(transfer.getToAccount().getId());
        return dto;
    }
}
