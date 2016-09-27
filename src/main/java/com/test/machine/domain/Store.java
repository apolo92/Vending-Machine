package com.test.machine.domain;

import com.test.machine.domain.model.Money;
import com.test.machine.domain.model.Product;

/**
 * Created by alejandro on 23/09/2016.
 */
public interface Store {

    public Money substract(int idproduct);

    public void putProduct(int idproduct, Product product);

    public void resetDefaultProducts();
}
