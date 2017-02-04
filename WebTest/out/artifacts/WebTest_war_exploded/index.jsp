<%--
  Created by IntelliJ IDEA.
  User: Anakinliu
  Date: 2017/1/13
  Time: 21:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <title>
    JAVA
  </title>
  <body>
  <p >
    <a href="index.jsp">sdsd</a>
  </p>
  <%
    out.println("Hello Tomcat!");

    String s = "初始化次数" + initVar;

    out.println(s);
  %>
  <%!
    private int initVar = 0;

    public void jspInit() {
        initVar++;
      System.out.println("jspInit(): JSP被初始化了" + initVar + "次");
    }

  %>

  <%!
    private int destroyVar = 0;

    public void jspDestroy() {
        destroyVar++;
      System.out.println("jspDestroy(): JSP被销毁了" + destroyVar + "次");
    }
  %>
  </p>
  </body>
</html>
