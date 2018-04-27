package com.example.erhan.varukontroll;

/**
 * Created by Erhan on 2018-03-29.
 */

public class Product {
    private String name;
    private int quantity;
    private int totalSales;
    private int varningValue;
    private String category;


    public Product(String name, int varningValue, String category)
    {
        this.name = name;
        this.varningValue = varningValue;
        this.category = category;
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

    public String getCategory()
    {
        return category;
    }

    public void decreaseX(int x)
    {

        this.quantity-=x;
    }

    public void increaseX(int x)
    {

        this.quantity+=x;
    }
}
