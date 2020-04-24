package live.dl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

/*
    AUTHOR: linux
    TIME: 2020/4/19
    GOOD LUCK AND NO BUG.
*/
@WebServlet("/http2")
public class HttpServletDemo2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        System.out.println(req.getMethod());
//        System.out.println(req.getContextPath());
//        System.out.println(req.getServletPath());
//        System.out.println(req.getQueryString());
//        System.out.println(req.getProtocol());
//        System.out.println(req.getRequestURI());
//        System.out.println(req.getRequestURL());
//        System.out.println(req.getRemoteAddr());
        // 打印请求头
        Enumeration<String> names = req.getHeaderNames();
        while (names.hasMoreElements()) {
            String name = names.nextElement();
            System.out.println(name + " : " + req.getHeader(name));
        }

        System.out.println(req.getHeader("referer"));
    }
}
