package com.example.demo;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "DeleteCookiesServlet", value = "/deletecookiesservlet")
public class DeleteCookiesServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie cookie = new Cookie("some_id", "");

        cookie.setMaxAge(0);
        //whet client close browser:
//        cookie.setMaxAge(-1);
        response.addCookie(cookie);

        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<p><a href='setcookiesservlet'> Set Cookies </a> </p>");
        out.println("<p><a href='getcookiesservlet'> Get Cookies </a> </p>");
        out.println("<p><a href='index.jsp'> Home page (index) </a> </p>");
        out.println("</body></html>");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
