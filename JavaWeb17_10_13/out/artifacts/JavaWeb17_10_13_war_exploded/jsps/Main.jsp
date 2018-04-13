<%--
  Created by IntelliJ IDEA.
  User: Anakinliu
  Date: 17.11.5
  Time: 19:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="top.jsp"%>
<%@ include file="book.jsp"%>

<!DOCTYPE html>
<html>
<head>
    <title>Main</title>
    <link rel="stylesheet" href="../css/main.css" type="text/css">
    <%--<link rel="stylesheet" href="../css/bootstrap.css" type="text/css">--%>
    <link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
    <script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link href="../css/m.css" rel="stylesheet" type="text/css" />
    <script src="../js/m.js" type="text/javascript"></script>

</head>
<body>

<%--<p >${userName}</p>--%>
<%--<p >${lastLoginDate}</p>--%>
<script>
    function inBuyer() {
        var inBuyer = document.getElementById("buyer");
        inBuyer.style.color = "green";
    }

</script>
</body>
</html>
