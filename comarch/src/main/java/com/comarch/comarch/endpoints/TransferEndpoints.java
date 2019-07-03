package com.comarch.comarch.endpoints;

import com.comarch.comarch.dto.TransferDto;
import com.comarch.comarch.services.TransferService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/transfer", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class TransferEndpoints {

    @Autowired
    private TransferService transferService;

    private static final Logger LOGGER = LoggerFactory.getLogger(TransferEndpoints.class);

    @PostMapping("/send")
    @ResponseStatus(HttpStatus.OK)
    public void transfer(@RequestBody TransferDto transferDto) {
        LOGGER.debug("transfer request : \n"+transferDto.toString());
        transferService.transferMoney(transferDto);
    }

}
