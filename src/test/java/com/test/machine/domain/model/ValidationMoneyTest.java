package com.test.machine.domain.model;

import com.test.machine.domain.model.Money;
import com.test.machine.domain.model.MoneyEUR;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by alejandro on 24/09/2016.
 */
public class ValidationMoneyTest {
    private static final double DELTA = 1e-15;

    @Test
    public void validationLittleCoin(){
         Money money = new MoneyEUR();
         money.insertCoin(0.05);

         Assert.assertEquals(money.getMoney(),0.05,DELTA);
     }
     @Test
     public void validationTwoLittleCoin(){
         Money money = new MoneyEUR();
         money.insertCoin(0.10);

         Assert.assertEquals(money.getMoney(),0.10,DELTA);
     }
     @Test
     public void validationThreeLittleCoin(){
         Money money = new MoneyEUR();
         money.insertCoin(0.20);

         Assert.assertEquals(money.getMoney(),0.20,DELTA);
     }
     @Test
     public void validationFourLittleCoin(){
         Money money = new MoneyEUR();
         money.insertCoin(0.50);

         Assert.assertEquals(money.getMoney(),0.50,DELTA);
     }
     @Test
     public void validationFiveLittleCoin(){
         Money money = new MoneyEUR();
         money.insertCoin(1);

         Assert.assertEquals(money.getMoney(),1,DELTA);
     }
     @Test
     public void validationBigCoin(){
         Money money = new MoneyEUR();
         money.insertCoin(2);

         Assert.assertEquals(money.getMoney(),2,DELTA);
     }

}
