<%
if((request.getParameter("nme").equalsIgnoreCase("ravi"))&&
	(request.getParameter("pwd").equalsIgnoreCase("cluster")))
{ %><jsp:forward page="success.jsp"/>
<% }else { %>
<%@include file="../html/login.html" %>
<% } %>