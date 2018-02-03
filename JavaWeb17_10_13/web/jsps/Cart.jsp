<%@ page import="com.anakinliu.model.Book" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: Anakinliu
  Date: 17.12.17
  Time: 16:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="top.jsp"%>
<jsp:useBean id="books" class="com.anakinliu.model.Books"
             scope="page"/>
<!--value 使用单引号!!!!-->
<jsp:setProperty name="books" property="bookArrayList"
                 value='<%= session.getAttribute("books_list")%>' />
<%
    System.out.println(books);
    ArrayList<Book> bookList = books.getBookArrayList();
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div>
    <table class="table table-inverse">
        <thead>
        <tr>
            <th>#</th>
            <th>Title</th>
            <th>Price</th>
            <th>Introduction</th>
        </tr>
        </thead>
        <tbody>
        <%
            int i = 1;
            while (!bookList.isEmpty()) {
                Book book = bookList.remove(0);
                out.print("<tr>");
                out.print("<th scope=\"col\">" + i + "</th>");
                out.print("<td>");
                out.print(book.getTitle());
                out.print("</td>");
                out.print("<td>");
                out.print(book.getPrice());
                out.print("</td>");
                out.print("<td>");
                out.print(book.getIntro());
                out.print("</td>");
                out.print("<td>");
                out.print(book.getIsbn());
                out.print("</td>");

                out.print("</tr>");
                i++;
            }
        %>
        </tbody>
    </table>
</div>
</body>
</html>
