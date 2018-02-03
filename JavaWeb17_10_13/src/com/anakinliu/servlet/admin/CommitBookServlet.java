package com.anakinliu.servlet.admin;

import com.anakinliu.tools.BookSQL;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintStream;
import java.sql.SQLException;

/**
 * Created by Anakinliu on 17.12.10.
 * If you only do what you can do,
 * you'll never be more than you are now.
 */
@WebServlet("/admin/CommitBookServlet")
public class CommitBookServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintStream out = new PrintStream(resp.getOutputStream());
        String title = req.getParameter("title");
        String price = req.getParameter("price");
        String isbn = req.getParameter("isbn");
        String pubID = req.getParameter("pubID");
        String count = req.getParameter("count");
        String intro = req.getParameter("intro");

        try {
            int row = BookSQL.add(title, isbn, Float.parseFloat(price),
                    Integer.parseInt(pubID), Integer.parseInt(count), intro);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
