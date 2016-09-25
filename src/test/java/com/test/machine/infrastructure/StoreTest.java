package com.test.machine.infrastructure;

import com.test.machine.domain.Store;
import com.test.machine.domain.issues.ProductFinish;
import com.test.machine.domain.model.Money;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by alejandro on 23/09/2016.
 */
public class StoreTest {
    private static final double DELTA = 1e-15;

    @Test
    public void substractProductStore(){
        Store store = new StoreInMemory();
        Money price = store.substract(1);
        Assert.assertEquals(price.getMoney(),1.5,DELTA);
    }

    @Test(expected = ProductFinish.class)
    public void endProductStore(){
        Store store = new StoreInMemory();
        store.substract(1);
        store.substract(1);
        store.substract(1);
        store.substract(1);
    }
}
