package com.example.springapi.springapi.api.exepction_handling;

public class NoSuchProductsException extends RuntimeException{
    public NoSuchProductsException(String message){
        super(message);
    }
}
