package com.company;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 * Created by efabapo on 1/21/17.
 */
public class CartBean implements CartLocal , CartRemote {

    @Override
    public String createCart(String cart) {
        return cart;
    }
}
