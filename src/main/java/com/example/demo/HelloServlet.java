package com.example.demo;

import java.io.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        if (name == null)
            name = "Name";
        if (surname == null)
            surname = "Surname";

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("<p> Hello, " + name + " " + surname + "</p>");
        out.println("<p><a href='index.jsp'> Home page (index) </a> </p>");
        out.println("</body></html>");
    }

    public void destroy() {
    }
}