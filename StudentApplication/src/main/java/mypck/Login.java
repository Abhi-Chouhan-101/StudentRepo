package mypck;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.protocol.Resultset;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Login() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String pass = request.getParameter("pass");
		PrintWriter out = response.getWriter();
		Connection conn = (Connection)this.getServletContext().getAttribute("myconn");
//		System.out.println(conn);
	     try {
			PreparedStatement ps = conn.prepareStatement("select * from Users where email=? and password = ?");
			ps.setString(1, email);
			ps.setString(2, pass);
			ResultSet rs =  ps.executeQuery();
			boolean found = rs.next();
			if(found) {
	
			         response.sendRedirect("studenthome.html");
			        }
			else {
				String adminid = this.getInitParameter("adminid");
				String password = this.getInitParameter("adminpass");
//				System.out.println(adminid+"=="+password);
				if(email.equals(adminid)&& pass.equals(password))
					{
						response.sendRedirect("adminhome.html");
					}
				else {
				out.write("<h1>Somthing Want's Wrong Please Check Email ID and Password<h1>");
				}
				}  
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
