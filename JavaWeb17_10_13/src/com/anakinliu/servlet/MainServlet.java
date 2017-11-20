package com.anakinliu.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;

/**
 * Created by Anakinliu on 17.11.5.
 * If you only do what you can do,
 * you'll never be more than you are now.
 */
@WebServlet("/MainServlet")
public class MainServlet extends HttpServlet {

    private final static String LAST_LOGIN_DATE = "last_login_date";
    private final static String LOGIN_TIMES = "login_times";
    private final static String USER = "user";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {



        HttpSession session = req.getSession(true);

        session.setMaxInactiveInterval(3000); //seconds unit

        // 增加次数
        long loginTimesValue = 1L;

        boolean exists = false;
        Enumeration enumeration = session.getAttributeNames();
        while (enumeration.hasMoreElements()) {
            String attributeName = (String)enumeration.nextElement();
            if (attributeName.equals(LOGIN_TIMES)) {
                exists = true;
                break;
            }
        }
        if (!exists) {
            session.setAttribute(LOGIN_TIMES, 0L);
        } else {
            loginTimesValue = (Long)session.getAttribute(LOGIN_TIMES);
            loginTimesValue += 1;
            session.setAttribute(LOGIN_TIMES, loginTimesValue);
        }

        // to Main jsp
        String wUsername = req.getParameter("un");
        String lastLoginTime = (String)session.getAttribute(LAST_LOGIN_DATE);
        if (lastLoginTime == null) {
            String s = "这是第一次登录!";
            req.setAttribute("lastLoginDate", s);
        }else {
            lastLoginTime =  "上次登录时间: " + lastLoginTime ;
            System.out.println(lastLoginTime);
            req.setAttribute("lastLoginDate", lastLoginTime);
        }
        req.setAttribute("userName", wUsername);
        req.getRequestDispatcher("\\jsps\\Main.jsp").forward(req, resp);

        DateFormat dateFormat =
                new SimpleDateFormat("yyyy'年'MM'月'dd'日 'HH:mm:ss");
        String stringDate = dateFormat.format(new Date());
        session.setAttribute(LAST_LOGIN_DATE, stringDate);

        req.getCookies();
        resp.addCookie(new Cookie("anakinliu", session.getId()));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);

    }
}
