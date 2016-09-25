package com.test.machine.domain;

/**
 * Created by alejandro on 23/09/2016.
 */
public interface VendingMachine {

    public void insertCoin(double coins);

    public double buy(int product);

    public double cancelBuy();
}
