package com.company;

import javax.annotation.Resource;
import javax.ejb.EJB;
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

    @Override
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        // Set response content type
        httpServletResponse.setContentType("text/html");
        userBean.createUser("Fabio");
        httpServletResponse.getWriter().print("<h1>" + "USER CREATED"+ "</h1>");
    }
}
