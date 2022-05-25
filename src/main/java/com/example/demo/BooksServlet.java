package com.example.demo;

import com.example.demo.logic.Book;
import com.example.demo.logic.BooksDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(name = "BooksServlet", value = "/booksservlet")
public class BooksServlet extends HttpServlet {
    private static BooksDAO booksDAO = new BooksDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");

        booksDAO.getBookNamesAndAuthors(out);

        out.println("<p><a href='addbook'>Put another book into DB</a></p>");
        out.println("<p><a href='index.jsp'> Home page (index) </a></p>");
        out.println("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String bookName = request.getParameter("bname").trim();
        String authorName = request.getParameter("author").trim();
        Integer quantity = Integer.parseInt(request.getParameter("quantity"));

        if (quantity < 0 )
            throw new ServletException("quantity shouldn't be less than zero");

        Book book = new Book(bookName, authorName, quantity);

        booksDAO.save(book);

        // after insert into db show status and index url
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");

        out.println("<p>The book was added successfully</p>");
        out.println("<p><a href='booksservlet'> Get book names from DB</a></p>");
        out.println("<p><a href='index.jsp'> Home page (index)</a></p>");
        out.println("</body></html>");
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // delete book from DB
    }
}
