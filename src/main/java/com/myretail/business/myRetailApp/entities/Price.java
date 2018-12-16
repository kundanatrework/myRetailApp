package com.myretail.business.myRetailApp.entities;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Price")
public class Price {
    double value;

    String currency_code;

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String getCurrency_code() {
        return currency_code;
    }

    public void setCurrency_code(String currency_code) {
        this.currency_code = currency_code;
    }

}
