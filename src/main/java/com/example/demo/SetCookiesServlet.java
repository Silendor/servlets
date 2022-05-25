package com.example.demo;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "SetCookiesServlet", value = "/setcookiesservlet")
public class SetCookiesServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie cookie1 = new Cookie("some_id", "123");
        Cookie cookie2 = new Cookie("some_name", "Tom");
        cookie1.setMaxAge(60 * 60);
        cookie2.setMaxAge(60 * 60);

        response.addCookie(cookie1);
        response.addCookie(cookie2);

        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<p><a href='getcookiesservlet'> Get Cookies </a> </p>");
        out.println("<p><a href='deletecookiesservlet'> Delete Cookies some_name </a> </p>");
        out.println("<p><a href='index.jsp'> Home page (index) </a> </p>");
        out.println("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
