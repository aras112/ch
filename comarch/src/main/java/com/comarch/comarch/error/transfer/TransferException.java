package com.comarch.comarch.error.transfer;

public class TransferException extends Exception {

    private static String BAD_USER_ID= "this user id is incorrect";

    public TransferException(String message) {
        super(message);
    }
}
