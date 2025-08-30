package com.cluster;

import java.sql.Connection;

public class UserDetailServlet  extends HttpServlet{
	Connection con;

	public void init() throws ServletException {
		try {
			con = DBUtil.getOracleConnection();
		} catch (ClassNotFoundException cnfe) {
			System.out.println(cnfe);
		} catch (SQLException sqle) {
			System.out.println(sqle);
		}
	}

	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		PreparedStatement pst = null;
		ResultSet rs = null;
		String strNme = req.getParameter("nme");
		String strPwd = req.getParameter("pwd");
		
		try {
			pst = con.prepareStatement("SELECT NAME,PASSWORD,EMAIL,PHONE FROM CUSTOMER WHERE NAME = ? and PASSWORD = ?");
			pst.setString(1, strNme);
			pst.setString(2, strPwd);
			rs = pst.executeQuery();
			if (rs.next()) {
				String name = rs.getString("NAME");
				String pwd = rs.getString("PASSWORD");
				String email = rs.getString("EMAIL");
				String phone = rs.getString("PHONE");
				PersonTO personTO = new PersonTO();
				personTO.setName(name);;
				personTO.setPassword(pwd);;
				personTO.setEmail(email);
				personTO.setPhone(phone);;

				req.setAttribute("pto", personTO);
				RequestDispatcher rd = req.getRequestDispatcher("./jsp/userDetail.jsp");
				rd.forward(req, res);
			}
		} catch (SQLException sqle) {
			System.out.println(sqle);
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (pst != null) {
					pst.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}

	public void destroy() {
		try {
			con.close();
		} catch (SQLException sqle) {
			System.out.println(sqle);
		}
	}
}
