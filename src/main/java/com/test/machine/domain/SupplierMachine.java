package com.test.machine.domain;

import com.test.machine.domain.model.Product;

/**
 * Created by alejandro on 24/09/2016.
 */
public interface SupplierMachine {

    public void addProduct(int idProduct, Product product);

    public void resetProducts();
}
