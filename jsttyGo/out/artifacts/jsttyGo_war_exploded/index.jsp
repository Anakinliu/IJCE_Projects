<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %><%--
  Created by IntelliJ IDEA.
  User: Anakinliu
  Date: 2017/3/31
  Time: 18:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>滚你妹的</title>
</head>
<p>
  Hi, I'm a HTML content
</p>
<body>
<%----%>
<%! //声明语句

  private int initVar = 0;
  private int serviceVar = 0;
  private int destroyVar = 0;
%>
<%! //声明语句
  /* JSP初始化
  容器载入JSP文件后，它会在为请求提供任何服务前调用jspInit()方法。如果您需要执行自定义的JSP初始化任务，复写jspInit()方法就行了，就像下面这样：
   */
  public void jspInit() {
    initVar++;
    System.out.println(String.format("jspInit(): JSP" +
            "第%d次初始化", initVar));
  }

  public void jspDestroy() {
    destroyVar++;
    System.out.println(String.format("jspDestroy(): JSP" +
            "第%d次销毁", destroyVar));

  }


%>
<p>
  <%
    serviceVar++;

    //out是JSP隐含对象, PrintWriter类的实例，用于把结果输出至网页上
    out.println(String.format("jspService(): JSP" +
            "第%d次响应请求", serviceVar));
  %>
</p>
<p>
  我是HTML段落~
</p>
<p>
  <%
    String content1 = "初始化次数: " + initVar;
    String content2 = "响应客户请求次数: " + serviceVar;
    String content3 = "销毁次数: " + destroyVar;
    String varHe1 = "Shit!";

    //out是JSP隐含对象, PrintWriter类的实例，用于把结果输出至网页上
    out.print(varHe1);
    out.print("你的IP是:" + request.getRemoteAddr());
  %>
</p>
<h1>
  JSP测试...
</h1>
<!-- 在HTML中访问JSP -->
<p>
  <%= content1 %>
</p>
<p>
  <%= content2 %>
</p>
<p>
  <%= content3 %>
</p>

<%!
   private String isWeekend() {
    int datOfWeek = Integer.parseInt(new SimpleDateFormat("u").format(new Date()));
    if (datOfWeek >= 1 && datOfWeek <= 5) {
        return "不是周末";
    } else {
        return "是周末啦";
    }
  }

  private String showRealTime() {
    return new SimpleDateFormat("HH:mm:ss").format(new Date());
  }
%>

<p>
  现在: <%= isWeekend() %>   !
</p>

<%!
  int fontSize = 0;
%>
<%
  for ( fontSize = 1; fontSize <= 30; fontSize++){
%>
<font color="green" size="<%= fontSize %>">
  菜鸟教程
</font>
<br />
<%
  out.print(fontSize);
%>
<%
  }
%>
</body>
</html>
