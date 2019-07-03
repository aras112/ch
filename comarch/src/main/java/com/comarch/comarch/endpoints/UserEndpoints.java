package com.comarch.comarch.endpoints;

import com.comarch.comarch.services.TransferService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/user", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class UserEndpoints {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserEndpoints.class);

}
