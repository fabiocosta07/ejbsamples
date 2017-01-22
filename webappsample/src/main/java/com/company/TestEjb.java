package com.company;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 * Created by efabapo on 1/22/17.
 */
@Stateless
@LocalBean
public class TestEjb {
    public String test(String test){
        return test;
    }
}
