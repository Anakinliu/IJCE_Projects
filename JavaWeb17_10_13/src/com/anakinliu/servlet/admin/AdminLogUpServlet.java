package com.anakinliu.servlet.admin;

import com.anakinliu.model.AdminUser;
import com.anakinliu.tools.AdminUserSQL;
import com.anakinliu.tools.MysqlConnector;

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
@WebServlet("/admin/AdminLogUpServlet")
public class AdminLogUpServlet extends HttpServlet{

    @Override
    public void init() throws ServletException {
        MysqlConnector.initMySqlConnector(
                getServletContext().getInitParameter("JDBC_DRIVER_PATH"),
                getServletContext().getInitParameter("DB_URL"),
                getServletContext().getInitParameter("DB_USER"),
                getServletContext().getInitParameter("DB_USER_PASSWD")
        );
        System.out.println(getServletContext().getInitParameter("DB_URL"));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        req.setCharacterEncoding("UTF-8");
        PrintStream out = new PrintStream(resp.getOutputStream());

        String permission =  req.getParameter("per");
        String username = req.getParameter("un");
        String password = req.getParameter("pw");
        AdminUser user = new AdminUser();
        user.setPassword(password);
        user.setPermissions(permission);
        user.setUsername(username);

        try {
            int result = AdminUserSQL.insertAdminUser(user);
            if (result > 0) {
                out.println("success");
                out.println("<a href=\"/jsps/admin/AdminLoginServlet.jsp\"></a>");
                req.getSession().setAttribute("admin", user);
            } else {
                out.println("fail");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


//        String[] values = req.getParameterValues();
    }
}
