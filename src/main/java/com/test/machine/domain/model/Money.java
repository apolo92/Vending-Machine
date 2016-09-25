package com.test.machine.domain.model;

/**
 * Created by alejandro on 24/09/2016.
 */
public interface Money {

    public void insertCoin(double coin);

    public double getMoney();

    public Money getChange(Money price);

    public double cancelMoney();
}
