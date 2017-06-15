package com.company;

import javax.annotation.Resource;
import javax.ejb.*;
import javax.transaction.*;

/**
 * Created by efabapo on 1/15/17.
 */
@Stateless
@LocalBean
@TransactionManagement(TransactionManagementType.CONTAINER)
public class UserBean {

    @Resource
    private TimerService timerService;
    @EJB
    private TestBean2 testBean2;

    public void createUser(String user) {
        System.out.print("User created:" + user);
    }

    @Schedule(second = "0,10,20,30,40,50", minute = "*" ,hour = "*")
    public void testSchedule() {
        System.out.print("XXXXXXXXXXX");
    }

    public void createTimer(){
        timerService.createSingleActionTimer(1000, new TimerConfig());
    }
    @Timeout
    public void testSingleAction(){
        System.out.print("XXXXXXXXXXX-----------------------");
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void testTransaction(){
        try {
            testBean2.testTransaction();
        } catch (AppException e) {
            e.printStackTrace();
        }
        System.out.print("CCCCCCOOOOOOOMMMMMMIIIIITED");

    }
}
