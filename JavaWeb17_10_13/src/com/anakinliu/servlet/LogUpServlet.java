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
 * Created by Anakinliu on 17.10.25.
 * If you only do what you can do,
 * you'll never be more than you are now.
 */
@WebServlet("/LogUpServlet")
public class LogUpServlet extends HttpServlet {

    private MysqlConnector sqlConnector;

    @Override
    public void init() throws ServletException {
        sqlConnector = MysqlConnector.initMySqlConnector(
                getServletContext().getInitParameter("JDBC_DRIVER_PATH"),
                getServletContext().getInitParameter("DB_URL"),
                getServletContext().getInitParameter("DB_USER"),
                getServletContext().getInitParameter("DB_USER_PASSWD")

        );

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String wUsername = req.getParameter("un");
        String wPassword = req.getParameter("pw");


        String result ;
        if (sqlConnector.insert(wUsername, wPassword)) {
            result = "注册成功, 将跳转至登录页面.";

        } else {
           result = "注册失败, 用户已存在, 返回重新注册...";

        }


        // 告诉JSP
        req.setAttribute("result", result);
        req.getRequestDispatcher("\\jsps\\LogupJump.jsp").forward(req, resp);
    }
}
