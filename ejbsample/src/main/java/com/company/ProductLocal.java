package com.company;

import javax.ejb.Local;

/**
 * Created by efabapo on 1/21/17.
 */
@Local
public interface ProductLocal {
    void addProduct(String product);
}
