package com.company;

import javax.annotation.Resource;
import javax.ejb.EJB;
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


    @EJB
    private UserBean userBean;

    @EJB
    private CartRemote cartRemote;

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
        httpServletResponse.getWriter().print("<h1>" + "USER CREATED"+ "</h1>");
        String cart = cartRemote.createCart("Cart 123");
        httpServletResponse.getWriter().print("<h1>" +cart+ "</h1>");

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
