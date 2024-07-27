package mypck;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Result
 */
@WebServlet("/Result")
public class Result extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Result() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    PrintWriter out = response.getWriter();
		String sname = request.getParameter("sname");
		String suid  = request.getParameter("suid");
	    Connection conn  = (Connection)this.getServletContext().getAttribute("myconn");
	    try {
			PreparedStatement ps = conn.prepareStatement("Select * from result where suid=? and sname=?");
		    ps.setString(1, suid);
		    ps.setString(2, sname);
		    ResultSet rs = ps.executeQuery();
		    if(rs.next())
		    {
		    	int s1 = rs.getInt(3);
		    	int s2 = rs.getInt(4);
		    	int s3 = rs.getInt(5);
		    	int s4 = rs.getInt(6);
		    	int s5 = rs.getInt(7);
		    	int total = (s1+s2+s3+s4+s5);
		    	out.write("<html><body><table border=4>");
		    	out.write("Result OF Student : "+rs.getString(2));
		    	out.write("<tr>");
		    	out.write("<th>Subject</th>");
		    	out.write("<th>Marks</th>");
		    	out.write("</tr>");
		    	
		    	out.write("<tr>");
		    	out.write("<th>hindi</th>");
		    	out.write("<td>"+s1+"</td>");
		    	out.write("</tr>");
		    	
		    	out.write("<tr>");
		    	out.write("<th>English</th>");
		    	out.write("<td>"+s2+"</td>");
		    	out.write("</tr>");
		    	
		    	out.write("<tr>");
		    	out.write("<th>Maths</th>");
		    	out.write("<td>"+s3+"</td>");
		    	out.write("</tr>");
		    	
		    	out.write("<tr>");
		    	out.write("<th>Physics</th>");
		    	out.write("<td>"+s4+"</td>");
		    	out.write("</tr>");
		    	
		    	out.write("<tr>");
		    	out.write("<th>Chemistry</th>");
		    	out.write("<td>"+s5+"</td>");
		    	out.write("</tr>");
		    	
		    	out.write("<tr>");
		    	out.write("<th>Total Marks</th>");
		    	out.write("<td>"+total+"</td>");
		    	out.write("</tr>");
		    	
		    }
		    else {
		    	out.write("<h3>Student id and name dose not match..!!");
		    }
	    
	    } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
