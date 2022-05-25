package com.example.demo.logic;

import java.io.PrintWriter;
import java.sql.*;
import java.util.List;

public class BooksDAO implements DAO<Book> {
    private static Connection connection;

    {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/library",
                    "library", "x3FnQ3LqWmPQlS75KX");
        } catch (ClassNotFoundException classNotFoundException) {
            classNotFoundException.printStackTrace();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }

    @Override
    public List<Book> getAll() {
        // not implemented yet
        return null;
    }

    @Override
    public void save(Book book) {
        try ( Statement statement = connection.createStatement() ) {
            statement.executeQuery(String.format("INSERT INTO books (title, author, quantity) VALUES ('%s', '%s', %d)",
                    book.getName(), book.getAuthor(), book.getQuantity()));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void delete(Book book) {
        // not implemented yet
        
    }

    // weird implementation of getAll()
    public void getBookNamesAndAuthors(PrintWriter out) {
        try ( Statement statement = connection.createStatement() ) {
            getBookNames(out, statement, "title");
            getAuthorNames(out, statement, "author");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    private ResultSet getResultSet(Statement statement, String column) throws SQLException {
        return statement.executeQuery(String.format("SELECT %s FROM books", column));
    }

    private void getBookNames(PrintWriter out, Statement statement, String column) throws SQLException {
        out.println("<h2> Book names:</h2>");
        ResultSet booknamesSet = getResultSet(statement, column);

        while(booknamesSet.next())
            out.println("<p>" + booknamesSet.getString(column) + "</p>");
    }

    private void getAuthorNames(PrintWriter out, Statement statement, String column) throws SQLException {
        out.println("<h2>Book authors:</h2>");
        ResultSet authorsSet = getResultSet(statement, column);

        while(authorsSet.next())
            out.println("<p>" + authorsSet.getString(column) + "</p>");
    }
}
