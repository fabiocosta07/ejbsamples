package com.company;

import javax.ejb.EJB;
import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 * Created by efabapo on 1/23/17.
 */
@WebService
public class HelloWebSvc {

    @EJB
    private CartLocal cartLocal;
    @WebMethod(operationName = "hello")
    public String hello(){
        return cartLocal.createCart("HELLO");
    }
}
