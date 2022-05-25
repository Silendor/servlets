package com.example.demo;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "RefreshCounter", value = "/refreshcounter")
public class RefreshCounter extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // session and count
        HttpSession session = request.getSession();

        Integer count = (Integer) session.getAttribute("count");

        if (count == null) {
            count = 1;
            session.setAttribute("count", count);
        }
        else
            session.setAttribute("count", ++count);

        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1> Your count is: " + count + "</h1>");
        out.println("<p> Home: <a href='index.jsp'> index.jsp </a> </p>");
        out.println("</body></html>");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
