package com.test.machine.infrastructure;

import com.test.machine.domain.Store;
import com.test.machine.domain.issues.ProductFinish;
import com.test.machine.domain.model.Money;
import com.test.machine.domain.model.Product;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by alejandro on 23/09/2016.
 */
public class StoreInMemory implements Store {

    private Map<Integer,Product> productsInStrore = new HashMap();

    public StoreInMemory(){
        defaultProducts();
    }

    public Money substract(int idProduct) {
        Product productSelected = productsInStrore.get(idProduct);
        if (productSelected.isBuy()) {
            System.out.println(productSelected.toString());
            return productSelected.getPriceAndDownStock();
        }
        throw new ProductFinish();
    }

    public void putProduct(int idproduct, Product product) {
        productsInStrore.put(idproduct,product);
    }

    public void resetDefaultProducts() {
        defaultProducts();
    }

    private void defaultProducts() {
        Product coke = new Product("Coke",1.5,3);
        Product pepsi = new Product("Pepsi",1.45,3);
        Product water = new Product("Water",0.90,3);
        productsInStrore.put(1,coke);
        productsInStrore.put(2,pepsi);
        productsInStrore.put(3,water);
    }
}
