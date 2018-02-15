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
import javax.servlet.annotation.MultipartConfig;
import java.lang.Integer;

/*
 * Servlet implementation class CheckForm
 */


@MultipartConfig
public class InsertDb extends HttpServlet {
//	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response)
		      throws ServletException, IOException {
		      
		      // Set response content type
		      response.setContentType("text/html");
		      PrintWriter out = response.getWriter();
		      
		      
		      String name=request.getParameter("firstname");
		      String desc=request.getParameter("message");
		      String base=request.getParameter("base");
		      String incr=request.getParameter("incr");
		      String hour=request.getParameter("hours");
		     // String img=request.getParameter("pictr");
		      Part fp = request.getPart("photo");
		 
		      if(fp==null) {
		    	  out.println("problem");
		    	  
		      }
		      
	
		      else {
		      

		      String title = "Database Result";
		      
	
		 
		      try{  
				Class.forName("com.mysql.jdbc.Driver");  
				  // Execute SQL query
				Connection con = DriverManager.getConnection(
		                "jdbc:mysql://localhost:3306/P1?autoReconnect=true&useSSL=false", "root", "root123");
				
		         String sql = "INSERT INTO product(name,descr,price,incr,hour,img) values(?, ?, ?, ?, ?, ?)";
		            
		         PreparedStatement statement = con.prepareStatement(sql);
		         //statement.setInt(1, 1);
		         statement.setString(1, name);
		         statement.setString(2, desc);
		         statement.setInt(3,Integer.parseInt(base));
		         statement.setInt(4,Integer.parseInt(incr));
		         statement.setInt(5,Integer.parseInt(hour));
		         
		         
		        // InputStream inputStream = new FileInputStream(new File(filePath));
		         InputStream inputStream = fp.getInputStream();
		         statement.setBlob(6, inputStream);
		 
		         int row = statement.executeUpdate();
		         
		         if(row!=0) {
		    	   out.print(row);
		    	   response.sendRedirect("home.html");  
		    	   
		       }
			    
				con.close();  
			}catch(Exception e){ System.out.println(e);}  	   
		  }	
	}

}
