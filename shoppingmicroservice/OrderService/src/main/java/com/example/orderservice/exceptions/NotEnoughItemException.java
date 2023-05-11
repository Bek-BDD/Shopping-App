package com.example.orderservice.exceptions;

public class NotEnoughItemException extends Exception {
    public NotEnoughItemException(String message){
        super(message);
    }

}
