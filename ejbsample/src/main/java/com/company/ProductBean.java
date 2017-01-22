package com.company;

import javax.ejb.Stateless;

/**
 * Created by efabapo on 1/21/17.
 */
@Stateless
public class ProductBean implements ProductLocal{

    public void addProduct(String product){
        System.out.print(product);
    }
}
