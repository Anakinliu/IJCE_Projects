<%--
  Created by IntelliJ IDEA.
  User: Anakinliu
  Date: 2017/9/6
  Time: 9:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>无标题文档</title>
    <link href="../WEB-INF/static/m.css" rel="stylesheet" type="text/css" />
    <script src="../js/m.js" type="text/javascript"></script>
</head>

<body background="1920x1080_tied-alpaca-on-the-field.jpg">
<div style="height:220px" >

    <p  align="center">&nbsp;
    </p>
    <p  align="center">&nbsp;</p>
    <h1 class="button-caution" style="text-align:center;">
        实验室登录系统 </h1>

</div>
<p  align="center">&nbsp;
</p>


<div style=" text-align:center;">
    <form  method="GET" action="${pageContext.request.contextPath}/FormTest/HelloForm" onsubmit="return submitUP();">

    <input placeholder="输入用户名" id="un" name="un" type="text" align="center"
           class="button-glow button-border button-caution "  />
    <br />
    <br />

    <input placeholder="输入密码" id="pw" name="pw" type="password"
           class="button-glow button-border button-caution "  />
    <br />

    <br />

    <input  id="submit" name="submit" type="submit"
            value="登录"  onClick="submitUP();"
            class="button-primary button-giant button-longshadow"/>
    </form>
    <input  id="clear" type="button" onClick="clearUP()" value="重置"
            class="button-primary button-giant button-longshadow"/>
    <br />
    <br />
    <p style=" margin:0 auto; text-align:center;" id="msg" >(￣ー￣)</p>
</div>



</body>
</html>
