package mypck;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;

public class MyConnection implements ServletContextListener{

	public static Connection conn;

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		
		try {
	        Class.forName("com.mysql.cj.jdbc.Driver");
			
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/stdmgmt?useSSL=false","root","7828");
			
		
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		sce.getServletContext().setAttribute("myconn",conn);
	   
	}
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
      try {
		conn.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}


}
