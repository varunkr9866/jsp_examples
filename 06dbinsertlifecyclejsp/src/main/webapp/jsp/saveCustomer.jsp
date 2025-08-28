

<%@page import="java.sql.*" errorPage="dbError.jsp"%>

<%!Connection con;%>
<%!public void jspInit() {
		System.out.println("############Inside jspInit() method");
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/varunmysql", "root","Cluster");
		} catch (ClassNotFoundException cnfe) {
			System.out.println(cnfe);
		} catch (SQLException sqle) {
			System.out.println(sqle);
		}
	}%>

<%!public void jspDestroy() {
		System.out.println("############Inside jspDestroy() method");
		try {
			con.close();
		} catch (SQLException sqle) {
			System.out.println(sqle);
		}
	}%>
<html>
<body bgcolor="yellow">
	<%
		String strNme = request.getParameter("nme");
		String strPwd = request.getParameter("pwd");
		String strEmail = request.getParameter("email");
		String strPhone = request.getParameter("phone");
		PreparedStatement pst = null;
		try {
			pst = con.prepareStatement("INSERT INTO CUSTOMER(CUS_NAME,CUS_PASSWORD,CUS_EMAIL,CUS_PHONE) VALUES (?,?,?,?)");
			pst.setString(1, strNme);
			pst.setString(2, strPwd);
			pst.setString(3, strEmail);
			pst.setString(4, strPhone);

			int i = pst.executeUpdate();

			if (i == 1) {
	%>
	Hello Mr <%=strNme%> Thank you for becoming a member
	<%
		} else {
	%>
	Hello Mr
	<%=strNme%>
	Better Luck Next Time
	<%
		}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		} finally {
			try {
				pst.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	%>
</body>
</html>