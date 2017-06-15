package com.company;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 * Created by efabapo on 1/21/17.
 */
public class CartBean implements CartLocal , CartRemote {



    private UserBean userBean;
    @Override
    public String createCart(String cart) {
        userBean.createUser("sdfasdfa");
        return cart;
    }

    public void setUserBean(UserBean userBean) {
        this.userBean = userBean;
    }

}
