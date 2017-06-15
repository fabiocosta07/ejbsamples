package com.company.aop;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

/**
 * Created by efabapo on 1/28/17.
 */
public class TestInterceptor {
    @AroundInvoke
    public Object test(InvocationContext context){
        Object object = null;
        try {
            System.out.print("Calling testInterceptor");
            object = context.proceed();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return object;
    }
}
