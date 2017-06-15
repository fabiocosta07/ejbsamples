package com.company;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 * Created by efabapo on 1/23/17.
 */
@Path("helloRest")
public class HelloRest {
    @EJB
    private CartLocal cartLocal;
    @GET
    @Produces("text/html")
    public String hello(){
        return cartLocal.createCart("HELLO");
    }
}
