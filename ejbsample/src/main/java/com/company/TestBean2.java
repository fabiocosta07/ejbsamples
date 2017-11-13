package com.company;

import javax.annotation.Resource;
import javax.ejb.*;

/**a
 * Created by efabapo on 2/4/17.
 */
@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class TestBean2 {
    @Resource
    EJBContext ejbContext;

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void testTransaction() throws AppException {
        //throw new AppException();
        ejbContext.setRollbackOnly();
    }
}
