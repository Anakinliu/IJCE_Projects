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
    <title>登录</title>
    <link href="../css/m.css" rel="stylesheet" type="text/css" />
    <script src="../js/m.js" type="text/javascript"></script>
    <script>
        // 刷新验证码
        function reloadCode(){
            var verify=document.getElementById('code');
            verify.setAttribute('src','/authImg');
//这里必须加入随机数不然地址相同我发重新加载
        }
    </script>
</head>

<body >
<%
    Cookie cookie = null;
    Cookie[] cookies = null;
    String un = "";
    // 获取cookies的数据,是一个数组
    cookies = request.getCookies();
    if( cookies != null ) {
        for (int i = 0; i < cookies.length; i++) {
            System.out.println(i);
            cookie = cookies[i];
            if (cookie.getName().equals("un")) {
                un = cookie.getValue();
            }
        }
    }
%>

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
    <form  method="POST" action="${pageContext.request.contextPath}/LoginServlet"
           onsubmit="return submitUP();" style=" text-align:center;">

        <input placeholder="输入用户名" id="un" name="un" type="text" align="center"
               value="<%out.print(un);%>"
               class="button-glow button-border button-caution "  />
        <br />
        <br />

        <input placeholder="输入密码" id="pw" name="pw" type="password"
               class="button-glow button-border button-caution "  />
        <br />
        <p  >
            <span  onclick="reloadCode()">
            <IMG id="code" src="/authImg" >
            </span>
        </p>
            <input placeholder="输入验证码" id="bot" name="bot" type="text"
                   class="button-glow button-border button-caution "  />

        <br />

        <br />

        <input  id="submit" name="submit" type="submit"
                value="登录"  onClick="submitUP()"
                class="button-primary button-giant button-longshadow"/>

    <input  id="clear" type="button" onClick="clearUP()" value="重置"
            class="button-primary button-giant button-longshadow"/>
    </form>
    <a href="/jsps/Logup.jsp">还未注册? 去注册!</a>
    <br />
    <br />
    <p style=" margin:0 auto; text-align:center;" id="msg" >(￣ー￣)</p>
</div>



</body>
</html>
