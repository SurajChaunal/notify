package demo_form;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AjaxPrice
 */
//@WebServlet("/AjaxPrice")
public class AjaxPrice extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 
		String pid =request.getParameter("name");
		PrintWriter out = response.getWriter();
		int val=Integer.parseInt(pid);
		
		try{  
			Class.forName("com.mysql.jdbc.Driver");  
			  // Execute SQL query
			Connection con = DriverManager.getConnection(
	                "jdbc:mysql://localhost:3306/P1", "root", "root123");

			Statement stmt = con.createStatement();
		    
	        PreparedStatement ps = con.prepareStatement("update product set price=incr+price where imgid=?");

	        ps.setInt(1,val);
	        int rs =ps.executeUpdate();
	 
	        if(rs!=0) {
	        	
	        	PreparedStatement ps1 = con.prepareStatement("select * from product where imgid=?");
	       
	        	ps1.setInt(1, val);
	        	ResultSet rs1 =ps1.executeQuery();
	        	
	        	if(rs1.next()) {
	        		String s1=Integer.toString(rs1.getInt("price"));
	        		
	        		out.write(s1);
	        	}
	        }

			
	     
			con.close();  
		}catch(Exception e){ System.out.println(e);}
		
	
	
	
	}

}
