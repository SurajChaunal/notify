package demo_form;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
//import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


// Extend HttpServlet class
public class HelloForm extends HttpServlet {
 
   public void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
      
      // Set response content type
      response.setContentType("text/html");

      
      
      String uid=request.getParameter("userid");
      String usrtel=request.getParameter("usrtel");
      String email=request.getParameter("email");
      String psw=request.getParameter("psw");
      PrintWriter out = response.getWriter();
      String title = "Database Result";
      
      String docType =
         "<!doctype html public \"-//w3c//dtd html 4.0 " + "transitional//en\">\n";
      
      out.println(docType +
         "<html>\n" +
         "<head><title>" + title + "</title></head>\n" +
         "<body bgcolor = \"#f0f0f0\">\n" +
         "<h1 align = \"center\">" + title + "</h1>\n");
   
  	try{  
		Class.forName("com.mysql.jdbc.Driver");  
		  // Execute SQL query
		Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/P1", "root", "root123");

		Statement stmt = con.createStatement();
	    
        PreparedStatement ps = con.prepareStatement("insert into  user(uname,utel,email,psw) values(?,?,?,?)");

        ps.setString(1, uid);
        ps.setString(2, usrtel);
        ps.setString(3, email);
        ps.setString(4, psw);
        int  i = ps.executeUpdate();
       if(i!=0) {
    	   //out.print("successfully logged in");
    	   response.sendRedirect("home.jsp");  
    	   
       }

		
     
		con.close();  
	}catch(Exception e){ System.out.println(e);}  
   
   }
}