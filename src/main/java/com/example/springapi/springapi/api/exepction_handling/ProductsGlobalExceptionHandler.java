package com.example.springapi.springapi.api.exepction_handling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
@ControllerAdvice
public class ProductsGlobalExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<ProductsIncorrectData> handleException(NoSuchProductsException exception){

        ProductsIncorrectData data = new ProductsIncorrectData();
        data.setInfo(exception.getMessage());

        return new ResponseEntity<>(data, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<ProductsIncorrectData> handleException(Exception exception){

        ProductsIncorrectData data = new ProductsIncorrectData();
        data.setInfo(exception.getMessage());

        return new ResponseEntity<>(data, HttpStatus.BAD_REQUEST);
    }
}
