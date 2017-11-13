package com.company;

import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.jms.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by efabapo on 1/16/17.
 */
public class HelloServlet extends HttpServlet {


    @EJB(lookup = "java:app/ejbsample-1.0-SNAPSHOT/UserBean")
    private UserBean userBean;
    @EJB(lookup = "java:module/TestEjb")
    private TestEjb testEjb;
    @EJB(lookup = "java:module/TestEjbXml")
    private TestEjbXml testEjbXml;

    @EJB
    private TestLocal testLocal;

    @EJB
    private CartRemote cartRemote;

    @EJB
    private TestSessionSync testSessionSync;

    @Resource(mappedName = "jms/QueueConnectionFactory")
    private QueueConnectionFactory queueConnectionFactory;
    @Resource(mappedName = "jms/OrderQueue")
    private Queue queue;

/*
    public ProductBean getProductBean() {
        return productBean;
    }

    public void setProductBean(ProductBean productBean) {
        this.productBean = productBean;
    }

    @EJB(lookup = "java:global/ejbsample/ProductBean!com.company.ProductBean")
    private ProductBean productBean;
*/

    @Override
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        // Set response content type
        httpServletResponse.setContentType("text/html");
        userBean.createUser("Fabio");
        userBean.createTimer();
        userBean.testTransaction();
        httpServletResponse.getWriter().print("<h1>" + "USER CREATED"+ "</h1>");
        String cart = cartRemote.createCart("Cart 123");
        httpServletResponse.getWriter().print("<h1>" +cart+ "</h1>");
        httpServletResponse.getWriter().print("<h1>" +testEjb.test("Test same module")+ "</h1>");
        httpServletResponse.getWriter().print("<h1>" +testEjbXml.test("Test same module XML")+ "</h1>");
        httpServletResponse.getWriter().print("<h1>" +testLocal.test("Test Resource XML")+ "</h1>");


        String message = "new Order";
        try {
            Connection connection = queueConnectionFactory.createQueueConnection();
            Session session = connection.createSession(false,Session.AUTO_ACKNOWLEDGE);
            MessageProducer messageProducer = (MessageProducer)session.createProducer(queue);
            TextMessage textMessage = session.createTextMessage();
            textMessage.setText(message);
            messageProducer.send(textMessage);
            httpServletResponse.getWriter().print("<h1>" + "MESSAGE SENT"+ "</h1>");

        } catch (JMSException e) {
            e.printStackTrace();
        }

// TestSessionSyncronization
        testSessionSync.test();

        httpServletResponse.getWriter().print("<h1>" + "TestSessionSyncronization finished"+ "</h1>");

/*
        Context context = null;
        try {
            context = new InitialContext();
            CartLocal cartLocal = (CartLocal) context.lookup(
                    "java:global/ejbsample/CartBean!com.company.CartLocal");
        } catch (Exception e) {
            e.printStackTrace();
        }
*/
/*
        productBean.addProduct("Product 123");
        httpServletResponse.getWriter().print("<h1>" + "Product 123" + "</h1>");
*/
    }
}
