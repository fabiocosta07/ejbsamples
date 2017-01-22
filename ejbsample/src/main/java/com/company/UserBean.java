package com.company;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 * Created by efabapo on 1/15/17.
 */
@Stateless
@LocalBean
public class UserBean {

    public void createUser(String user) {
        System.out.print("User created:" + user);
    }
}
