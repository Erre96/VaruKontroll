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

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }
    public int getVarningValue(){
        return varningValue;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setVarningValue(int varningValue) {
        this.varningValue = varningValue;
    }

    public void addOne()
    {
        this.quantity++;
    }

    public void addX(int quantity)
    {
        this.quantity += quantity;
    }

    public void decreaseOne()
    {
        this.quantity--;
    }

    public void decreaseX(int x)
    {

        this.quantity-=x;
    }
}
