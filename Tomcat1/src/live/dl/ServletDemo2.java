package live.dl;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

/*
    AUTHOR: linux
    TIME: 2020/4/18
    GOOD LUCK AND NO BUG.
*/
@WebServlet(urlPatterns = {"/demo2", "/demo", "/demo1"})
public class ServletDemo2 implements Servlet {
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println(servletRequest);
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
