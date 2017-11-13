package com.company;

import javax.ejb.*;
import java.rmi.RemoteException;

/**
 * Created by efabapo on 23/07/17.
 */
@Stateful
public class TestSessionSync implements SessionSynchronization{
    @Override
    public void afterBegin() throws EJBException, RemoteException {
      System.out.println("TestSessionSyn - afterBegin");
    }

    @Override
    public void beforeCompletion() throws EJBException, RemoteException {
        System.out.println("TestSessionSyn - beforeCompletion");
    }

    @Override
    public void afterCompletion(boolean b) throws EJBException, RemoteException {
        System.out.println("TestSessionSyn - afterCompletion");
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public String test(){
        System.out.println("TestSessionSyn - test method");
        return "test";
    }
}
