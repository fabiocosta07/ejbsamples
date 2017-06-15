package com.company.mdb;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * Created by efabapo on 1/22/17.
 */
@MessageDriven( mappedName = "jms/OrderQueue",
        activationConfig = {
            @ActivationConfigProperty(propertyName = "acknowledgeMode",propertyValue = "Auto-acknowledge"),
            @ActivationConfigProperty(propertyName = "destinationType",propertyValue = "javax.jms.Queue")
        }

)
public class OrderMessageBean  implements MessageListener {
    @Override
    public void onMessage(Message message) {
        try {
            System.out.print(((TextMessage)message).getText());
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
