package com.test.machine.domain;

import com.test.machine.domain.model.Product;
import com.test.machine.infrastructure.StoreInMemory;
import com.test.machine.domain.model.Money;
import com.test.machine.domain.model.MoneyEUR;

/**
 * Created by alejandro on 23/09/2016.
 *
 * The first interface is for client of machine and the second is for supplier and add products in machine
 */
public class Machine implements VendingMachine,SupplierMachine{
 
    private Money money;
    private Store store;

    public Machine(){
        money= new MoneyEUR();
        store = new StoreInMemory();
    }

    public double buy(int product) {
        Money price = store.substract(product);
        Money change = money.getChange(price);
        money = new MoneyEUR();

        System.out.println("Change "+change.toString());
        return change.getMoney();
    }

    public void insertCoin(double coin) {
        money.insertCoin(coin);
        System.out.println("Actual "+ money.toString());
    }

    public double cancelBuy() {
        return money.cancelMoney();
    }

    public void addProduct(int idProduct, Product product) {
        store.putProduct(idProduct,product);
    }

    public void resetProducts() {
        store.resetDefaultProducts();
    }
}
