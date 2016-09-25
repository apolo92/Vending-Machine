package com.test.machine.domain;

import static org.junit.Assert.*;

import com.test.machine.domain.Machine;
import com.test.machine.domain.SupplierMachine;
import com.test.machine.domain.VendingMachine;
import com.test.machine.domain.issues.NoMoney;
import com.test.machine.domain.issues.ProductFinish;
import com.test.machine.domain.model.Product;
import org.junit.Test;

/**
 * Created by alejandro on 23/09/2016.
 */
public class DefinitionTest {
    private static final double DELTA = 1e-15;

    @Test
    public void cancelRequest(){
        VendingMachine machine = new Machine();

        machine.insertCoin(2);
        double money = machine.cancelBuy();

        assertEquals(money,2,DELTA);

    }
    @Test
    public void requestCompleted(){
        VendingMachine machine = new Machine();

        double coin = 2;
        machine.insertCoin(coin);
        double change = machine.buy(1);

        assertNotNull(change);
        assertEquals(change,0.5,DELTA);
    }

    @Test(expected = ProductFinish.class)
    public void endProductReturnMoney(){
        VendingMachine machine = new Machine();

        double money = 2;
        machine.insertCoin(money);
        machine.buy(2);
        machine.insertCoin(money);
        machine.buy(2);
        machine.insertCoin(money);
        machine.buy(2);
        machine.insertCoin(money);
        machine.buy(2);

        assertEquals(money,2,DELTA);
    }

    @Test
    public void resetDefaultVending(){
        Machine machine = new Machine();

        double money = 2;
        machine.insertCoin(money);
        machine.buy(2);
        machine.insertCoin(money);
        machine.buy(2);
        machine.insertCoin(money);
        machine.buy(2);
        machine.resetProducts();
        machine.insertCoin(money);
        machine.buy(2);


    }

    @Test(expected = NoMoney.class)
    public void noMoneyBuyProductSelected(){
        VendingMachine machine = new Machine();

        machine.insertCoin(1);
        machine.buy(1);
    }
}
