

<html>
<body bgcolor="yellow">

<%!public void jspInit() {
		System.out.println("Inside init() Method");
	}%>
<%!public void jspDestroy() {
		System.out.println("Inside jspDestroy() Method");
	}%>
<%
	System.out.println("Inside _jspService()");
	out.println("Inside _jspService()");
%>
</body>
</html>