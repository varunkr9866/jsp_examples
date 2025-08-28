<html>
<body bgcolor="pink">
	BEGIN OF JSP<br>
	<br> WELCOME
	<br>
	<%
	int a = 10;
	int b = 20;
	int sum;
	sum = a + b;
	out.println("Value of a is:" + a);
	out.println("Value of b is:" + b);
	out.println("sum of two values is:" + sum);
	%>
</body>
</html>