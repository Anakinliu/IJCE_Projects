package live.dl;

import javax.servlet.*;
import java.io.IOException;

/*
    AUTHOR: linux
    TIME: 2020/4/18
    GOOD LUCK AND NO BUG.
*/
public class ServletDemo1 implements Servlet {

    /**
     * 在Servlet被创建时执行，只执行一次
     * @param servletConfig
     * @throws ServletException
     */
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("初始化");
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    /**
     * 每次访问该Servlet时都会执行
     * @param servletRequest
     * @param servletResponse
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("服务中");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    /**
     * 服务器正常关闭时执行，一次
     */
    @Override
    public void destroy() {

    }
}
