<%--
  Created by IntelliJ IDEA.
  User: Anakinliu
  Date: 17.11.22
  Time: 8:48
  To change this template use File | Settings | File Templates.
--%>
<% String userName = (String)session.getAttribute("un");%>
<div class="navbar navbar-inverse">
    <a>
        HI!
        <%
            if (userName != null) {
                out.print(userName);
            } else {
                out.print("<a href=\"\\jsps\\LoginJump.jsp\">" +
                        "Please Login" +
                        "</a>");
            }
        %>
    </a>
    <a href="#home">Home</a>
    <a href="#news">News</a>
    <a id="buyer" href="/jsp/cart.jsp">Buyer: <%=session.getAttribute("inBuyer")%> things</a>
    <a href="/LogoutServlet">Logout</a>
</div>

