package cn.anakinliu.test;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Anakinliu on 2017/3/31.
 * If you only do what you can do,
 * you'll never be more than you are now.
 */
@WebServlet(name = "Servlet1")
public class Servlet1 extends javax.servlet.http.HttpServlet {

    // TODO 这个成员变量有啥用?
    private static final long serialVersionUID = 1L;

    public Servlet1() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated constructor stub
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        /*
            1
         */
        //简单的response
        response.setCharacterEncoding("GBK");   //设置GBK以正常显示中文
        response.getWriter().write("汤姆离线记: www.anakinliu.cn");

        /*
            2
         */
        //设置响应内容类型  即 HTTP content-type
        response.setContentType("text/html;charset=UTF-8");

        PrintWriter out = response.getWriter();
        String title = "使用URL的Get方法来读取表单数据";

        // 处理中文
        String name = new String(request.getParameter("name").getBytes("ISO8859-1"), "UTF-8");

        String docType = "<!DOCTYPE html> \n";
        out.println(docType +
                "<html>\n" +
                "<head><title>" + title + "</title></head>\n" +
                "<body bgcolor=\"#f0f0f0\">\n" +
                "<h1 align=\"center\">" + title + "</h1>\n" +
                "<ul>\n" +
                "  <li><b>name</b>："
                + name + "\n" +
                "  <li><b>Tel</b>："
                + request.getParameter("tel") + "\n"
                );


        Boolean isName = false;
        if (request.getParameter("name").equals("liu")) {
            isName = true;
        } else {
            isName = false;
        }
        out.println(
            " <li><b>url中name是否是liu?</b>: " +
            isName.toString() +                            
            "</ul>\n" +
            "</body></html>"
        );

    }
}
