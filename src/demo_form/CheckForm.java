package demo_form;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.*;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CheckForm
 */

public class CheckForm extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
		      throws ServletException, IOException {
		      
		      // Set response content type
		      response.setContentType("text/html");

		      
		      
		      String uid=request.getParameter("userid");
		      String psw=request.getParameter("psw");
		      PrintWriter out = response.getWriter();

		  	try{  
				Class.forName("com.mysql.jdbc.Driver");  
				  // Execute SQL query
				Connection con = DriverManager.getConnection(
		                "jdbc:mysql://localhost:3306/P1", "root", "root123");
				   
				Statement stmt = con.createStatement();
			    
		        PreparedStatement ps = con.prepareStatement("select * from user where uname=? and PSW=?");

		        ps.setString(1, uid);
		        ps.setString(2, psw);
		    
		        ResultSet rs = ps.executeQuery();
		       if(rs.next()) {
		    	   //out.print("successfully logged in");
		    	   response.sendRedirect("home.html");  
		    	   
		       }
		       else {
		    	   response.sendRedirect("index.html"); 
		    	   
		       }
			    
				con.close();  
			}catch(Exception e){ System.out.println(e);}  
		   
		   }





}
