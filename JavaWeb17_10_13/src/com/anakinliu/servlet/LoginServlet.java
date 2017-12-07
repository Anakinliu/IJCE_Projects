package com.anakinliu.servlet;

import com.anakinliu.tools.MysqlConnector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;


/**
 * Created by Anakinliu on 17.10.18.
 * If you only do what you can do,
 * you'll never be more than you are now.
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private MysqlConnector mysqlConnector;



    @Override
    public void init() throws ServletException {
        mysqlConnector = MysqlConnector.initMySqlConnector(
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

        String un = req.getParameter("un");
        String pw = req.getParameter("pw");
        String code = req.getParameter("bot");
        String result;
        if (mysqlConnector.check(un, pw, "user")
                ) { // 测试, 去掉验证码验证
            result = "登录成功";
        } else if (!code.equals(AuthImage.code)) {
            result = "登录失败, 验证码出错!";
        } else {
            result = "登录失败, 用户名或密码出错!";
        }
        // cookie保存用户名, 自动在下次的loin.jsp的用户名框中填入
        Cookie unCookie = new Cookie("un", un);

        if (result.equals("登录成功")) {
            resp.addCookie(unCookie); // 成功才addCookie
            System.out.println("LoginServlet......");
            // 成功时跳转
            HttpSession session = req.getSession();
            session.setAttribute("un",un);
            // 跳转后request, response全部是新的。
            //resp.sendRedirect("\\jsps\\Main.jsp");

            //跳转到MainServlet, 处理Books
            resp.sendRedirect("/MainServlet");

            // 这种url地址不变，只能跳转到本web应用中的页面上。request, response全部传给页面。
            //req.getRequestDispatcher("\\jsps\\Main.jsp").forward(req, resp);
        } else {
            req.setAttribute("result", result);
            req.getRequestDispatcher("\\jsps\\LoginJump.jsp").forward(req, resp);
        }




    }
}
