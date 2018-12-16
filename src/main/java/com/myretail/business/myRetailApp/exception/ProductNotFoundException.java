package com.myretail.business.myRetailApp.exception;

public class ProductNotFoundException extends RuntimeException {
    public ProductNotFoundException(String exception){
        super(exception);
    }
}
