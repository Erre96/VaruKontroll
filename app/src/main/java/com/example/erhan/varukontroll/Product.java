package com.example.erhan.varukontroll;

/**
 * Created by Erhan on 2018-03-29.
 */

public class Product {
    private String name;
    private int quantity;
    private int varningValue;


    public Product(String name, int varningValue)
    {
        this.name = name;
        this.varningValue = varningValue;
    }
}
