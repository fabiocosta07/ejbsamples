package com.company;

import javax.naming.Context;
import javax.naming.InitialContext;
import java.util.Properties;

/**
 * Created by efabapo on 30/10/17.
 */
public class Main {

    private void connect() {
        try{
            Properties props = new Properties();
            props.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.enterprise.naming.SerialInitContextFactory");
            props.setProperty("org.omg.CORBA.ORBInitialHost", "localhost");
            props.setProperty("org.omg.CORBA.ORBInitialPort", "3700");

            InitialContext ctx = new InitialContext();
            CartRemote cartRemote = (CartRemote) ctx.lookup("java:global/earsample/ejbsample-1.0-SNAPSHOT/CartBean!com.company.CartRemote");
            cartRemote.createCart("Teste");
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Main tejbc = new Main();
        tejbc.connect();
    }
}
