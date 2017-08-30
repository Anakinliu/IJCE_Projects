package cn.anakinliu.test;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Anakinliu on 2017/4/14.
 * If you only do what you can do,
 * you'll never be more than you are now.
 */
@WebServlet(name = "Servlet2")
public class Servlet2 extends javax.servlet.http.HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //简单的response
        response.setCharacterEncoding("UTF-8");   //设置GBK以正常显示中文

        //response.getWriter().write("汤姆离线记: www.anakinliu.cn");

        response.setContentType("application/json");


        // 从response中得到printwriter对象以向输出流写入json对象
        PrintWriter out = response.getWriter();

        String objectToReturn = "{ key1: 'value1', key2: 'value2' }";

        String json = new Gson().toJson(objectToReturn);

        out.println(json);

    }
}
