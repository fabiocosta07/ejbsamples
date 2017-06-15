package com.company;

import javax.ejb.*;

/**a
 * Created by efabapo on 2/4/17.
 */
@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class TestBean2 {
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void testTransaction() throws AppException {
        throw new AppException();
        //System.out.print("TTTTT");
    }
}
