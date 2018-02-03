package com.anakinliu.servlet.admin;

import com.anakinliu.tools.AdminUserSQL;
import com.anakinliu.tools.MysqlConnector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintStream;

/**
 * Created by Anakinliu on 17.11.5.
 * If you only do what you can do,
 * you'll never be more than you are now.
 */
@WebServlet("/admin/AdminLoginServlet")
public class AdminLoginServlet extends HttpServlet {
    private MysqlConnector mysqlConnector;

    @Override
    public void init() throws ServletException {
        mysqlConnector = new AdminUserSQL(
                getServletContext().getInitParameter("JDBC_DRIVER_PATH"),
                getServletContext().getInitParameter("DB_URL"),
                getServletContext().getInitParameter("DB_USER"),
                getServletContext().getInitParameter("DB_USER_PASSWD")
        );
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String un = req.getParameter("un");
        String pw = req.getParameter("pw");
        String result;
        if (mysqlConnector.check(un, pw, "admin")) {
            HttpSession session = req.getSession();
            session.setAttribute("un",un);
            resp.sendRedirect("/jsps/admin/BookManage.jsp");
        }else {
            result = "failed!";
        }

        // 成功时跳转
//        ServletContext app = this.getServletContext();
//        app.setAttribute("result", result);
//        RequestDispatcher rd =
//                app.getRequestDispatcher("/jsps/admin//AdminPanel.jsp");
//        rd.forward(req, resp);

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
