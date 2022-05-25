package com.example.demo;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "GetCookiesServlet", value = "/getcookiesservlet")
public class GetCookiesServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie[] cookies = request.getCookies();

        PrintWriter out = response.getWriter();

        out.println("<html>" +
                "<head>Cookies</head>" +
                "<body>");
        out.println("<h1>Cookies on site:</h1>");

        for (Cookie cookie : cookies) {
            out.println("<p>" + cookie.getName() + " : " + cookie.getValue() + "</p>");
        }

        out.println("<p><a href='setcookiesservlet'> Set Cookies </a> </p>");
        out.println("<p><a href='deletecookiesservlet'> Delete Cookies some_name </a> </p>");

        out.println("<p><a href='index.jsp'> Home page (index) </a> </p>");

        out.println("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
