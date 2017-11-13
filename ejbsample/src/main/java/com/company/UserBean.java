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
    @Resource
    EJBContext ejbContext;

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
            ejbContext.getUserTransaction().begin();
            testBean2.testTransaction();
            ejbContext.getUserTransaction().commit();
        } catch (AppException e) {
            e.printStackTrace();
        } catch (NotSupportedException e) {
            e.printStackTrace();
        } catch (SystemException e) {
            e.printStackTrace();
        } catch (HeuristicMixedException e) {
            e.printStackTrace();
        } catch (HeuristicRollbackException e) {
            e.printStackTrace();
        } catch (RollbackException e) {
            e.printStackTrace();
        }
/*
        if (ejbContext.getRollbackOnly()){
            System.out.print("Transaction Rollbacked");
        } else {
            System.out.print("Transaction COMMITED");
        }
*/

    }
}
