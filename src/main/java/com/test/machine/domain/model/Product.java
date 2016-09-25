package com.test.machine.domain.model;

/**
 * Created by alejandro on 23/09/2016.
 */
public class Product {

    private String productName;
    private Money price;
    private int stock;

    public Product(String productName, double price,int stock) {
        this.productName = productName;
        this.price = new MoneyEUR(price);
        this.stock = stock;
    }

    public Money getPriceAndDownStock() {
        this.stock--;
        return price;
    }

    public boolean isBuy(){
        if(this.stock<=0)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Selling product: "+ productName +" price: "+price;
    }
}
