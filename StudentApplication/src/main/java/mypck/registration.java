package mypck;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.ServletException;

import jakarta.servlet.http.HttpServlet;


public class registration extends HttpServlet{
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public registration() {
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Connection conn = (Connection) this.getServletContext().getAttribute("myconn");
		try {
			PreparedStatement ps=conn.prepareStatement("insert into users values(?,?,?,?,?)");
			ps.setString(1,request.getParameter("uid"));
			ps.setString(2,request.getParameter("unm"));
			ps.setString(3,request.getParameter("email"));
			ps.setString(4,request.getParameter("pass"));
			ps.setString(5,"Student");
			ps.execute();
			PrintWriter out = response.getWriter();
			out.write("<h1>User Registration Successfuly..</h1>");
			
		
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
