package com.anakinliu.servlet;

import com.anakinliu.tools.MysqlConnector;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintStream;

/**
 * Created by Anakinliu on 17.10.18.
 * If you only do what you can do,
 * you'll never be more than you are now.
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    MysqlConnector connector = new MysqlConnector();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String un = req.getParameter("username");
        String pw = req.getParameter("password");
        PrintStream out = new PrintStream(resp.getOutputStream());
        out.println("hello~");
        out.println(un);
        if (connector.check(un, pw)) {
            out.println("yes");
        } else {
            out.println("no");
        }
    }
}
