package com.test.machine.domain.model;

import com.test.machine.domain.issues.NoAcceptMoney;
import com.test.machine.domain.issues.NoMoney;

/**
 * Created by alejandro on 24/09/2016.
 */
public class MoneyEUR implements Money {

    private double money;
    private String value;

    public MoneyEUR(){
        this.money=0;
        this.value="€";
    }

    public MoneyEUR(double money){
        this.money=money;
        this.value="€";
    }

    private boolean validateCoin(double coin){
        if(coin==0.05||coin==0.10||coin==0.20||coin==0.50||coin==1.0||coin==2.0)
            return true;
        return false;
    }
    public void insertCoin(double coin){
        if (validateCoin(coin)) {
            this.money += coin;
        }
        else {
            throw new NoAcceptMoney();
        }
    }

    public double getMoney(){
        return this.money;
    }

    public double cancelMoney(){
        double result = this.money;
        this.money = 0;
        return result;
    }

    public Money getChange(Money price) {
        if(price.getMoney()>this.money)
            throw new NoMoney();
        this.money-=price.getMoney();
        return this;
    }

    @Override
    public String toString() {
        return "Money = "+money+value;
    }
}
