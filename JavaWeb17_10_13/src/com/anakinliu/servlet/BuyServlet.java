package com.anakinliu.servlet;

import com.anakinliu.model.Book;
import com.anakinliu.tools.BookSQL;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Anakinliu on 17.12.17.
 * If you only do what you can do,
 * you'll never be more than you are now.
 */
@WebServlet("/buyer")
public class BuyServlet extends HttpServlet{
    private static int numbers=0;
    private ArrayList<Book> book;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(req.getRequestURI());
        String isbn = (String)req.getAttribute("isbn");
        System.out.println("isbn=" + isbn);
        book.add(BookSQL.searchByISBN(isbn).remove(0));
        req.getSession().setAttribute("inBuyer", book.size());
        req.getSession().setAttribute("buyer", book);
        req.getRequestDispatcher("/jsps/Cart.jsp").forward(req, resp);
    }

}
