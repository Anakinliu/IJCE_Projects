<%@ page import="java.util.ArrayList" %>
<%@ page import="com.anakinliu.model.Book" %>

<%--
  Created by IntelliJ IDEA.
  User: Anakinliu
  Date: 17.11.22
  Time: 8:48
  To change this template use File | Settings | File Templates.
--%>
<!--id属性用于指定JavaBean实例对象的引用名称 和其存储在域范围中的名称。-->

<jsp:useBean id="books" class="com.anakinliu.model.Books"
             scope="page"/>
<!--value 使用单引号!!!!-->
<jsp:setProperty name="books" property="bookArrayList"
        value='<%= session.getAttribute("books_list")%>' />
<%
    ArrayList<Book> bookList = books.getBookArrayList();
    ArrayList<String> titleList = new ArrayList<>();
    ArrayList<Float> priceList = new ArrayList<>();
    ArrayList<String> introList = new ArrayList<>();
    for (Book book : bookList) {
        titleList.add(book.getTitle());
        priceList.add(book.getPrice());
        introList.add(book.getIntro());
    }
%>

<div>
    <form  method="POST" action="${pageContext.request.contextPath}/MainServlet"
            style=" text-align:center;">
        <SPAN>All books &nbsp;</SPAN>
        <input placeholder="search by title" id="un" name="title" type="text" align="right"
               class="button-glow button-border button-caution "  />
        <SPAN>&nbsp;  |  &nbsp;</SPAN>
        <input placeholder="search by publisher" id="pw" name="pub" type="text" align="right"
               class="button-glow button-border button-caution "  />
        <SPAN>&nbsp;  |  &nbsp;</SPAN>
        <input  id="submit" name="submit" type="submit"
                value="commit" onClick="submitUP()"
                class="button-primary button-giant button-longshadow"
        height="40px"/>
    </form>

</div>

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
        while (!titleList.isEmpty()) {
            out.print("<tr>");
            out.print("<th scope=\"col\">" + i + "</th>");
            out.print("<td>");
            out.print(titleList.remove(0));
            out.print("</td>");
            out.print("<td>");
            out.print(priceList.remove(0));
            out.print("</td>");
            out.print("<td>");
            out.print(introList.remove(0));
            out.print("</td>");
            out.print("</tr>");
            i++;
        }
    %>
    <%--<tr>--%>
        <%--<th scope="col">1</th>--%>
        <%--<td>--%>
        <%--<%--%>
            <%--for (String title : titleList) {--%>
                <%--out.print("<td>" + title + "</td>");--%>
            <%--}--%>
        <%--%>--%>
        <%--</td>--%>
      <%----%>
    <%--</tr>--%>
    <%--<tr>--%>
        <%--<th scope="col">2</th>--%>
        <%--<td>--%>
        <%--<%--%>
            <%--for (Float price : priceList) {--%>
                <%--out.print("<td>" + price + "</td>");--%>
            <%--}--%>
        <%--%>--%>
        <%--</td>--%>
    <%--</tr>--%>
    </tbody>
</table>
</div>
