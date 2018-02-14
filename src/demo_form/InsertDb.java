package demo_form;

import javax.servlet.http.Part;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
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

public class InsertDb extends HttpServlet {
//	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response)
		      throws ServletException, IOException {
		      
		      // Set response content type
		      response.setContentType("text/html");

		      
		      
		      String name=request.getParameter("firstname");
		      String desc=request.getParameter("message");
		      String base=request.getParameter("base");
		      String incr=request.getParameter("incr");
		      String hour=request.getParameter("hour");
		     // String img=request.getParameter("pictr");
		      Part filePart = request.getPart("pictr");
		      String filePath = "/home/suraj/Downloads/shopping1.jpg";
		      
				      
		      PrintWriter out = response.getWriter();

		      String title = "Database Result";
		      
		      String docType =
		         "<!doctype html public \"-//w3c//dtd html 4.0 " + "transitional//en\">\n";
		    
		      out.println(docType +
		         "<html>\n" +
		         "<head><title>" + title + "</title></head>\n" +
		         "<body bgcolor = \"#f0f0f0\">\n" +
		         "<h1 align = \"center\">" + title  + "</h1>\n");
		    //  out.println(img);
		 
		      try{  
				Class.forName("com.mysql.jdbc.Driver");  
				  // Execute SQL query
				Connection con = DriverManager.getConnection(
		                "jdbc:mysql://localhost:3306/P1", "root", "root123");
				
		         String sql = "INSERT INTO product values(?,?, ?, ?, ?, ?, ?)";
		            
		         PreparedStatement statement = con.prepareStatement(sql);
		         statement.setInt(1, 1);
		         statement.setString(2, "Samsung");
		         statement.setString(3, "very good mobile");
		         statement.setInt(4, 2500);
		         statement.setInt(5, 50);
		         statement.setInt(6, 48);
		         
		         
		        // InputStream inputStream = new FileInputStream(new File(filePath));
		         InputStream inputStream = filePart.getInputStream();
		         statement.setBlob(7, inputStream);
		 
		         int row = statement.executeUpdate();
		         
		         if(row!=0) {
		    	   out.print(row);
		    	   response.sendRedirect("home.html");  
		    	   
		       }
			    
				con.close();  
			}catch(Exception e){ System.out.println(e);}  	   
		   
	}

}
