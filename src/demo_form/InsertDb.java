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


import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.*;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.http.Part;

/*
 * Servlet implementation class CheckForm
 */


@MultipartConfig
public class InsertDb extends HttpServlet {
//	private static final long serialVersionUID = 1L;
	
	private boolean isMultipart;
	   private String filePath;
	   private int maxFileSize = 5000 * 1024;
	   private int maxMemSize = 4 * 1024;
	   private File file ;

	 

	public void doPost(HttpServletRequest request, HttpServletResponse response)
		      throws ServletException, IOException {
		      
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);

		if (isMultipart) {
		      // Set response content type
		      response.setContentType("text/html");
		      PrintWriter out = response.getWriter();
		      
		    	  
		    	  DiskFileItemFactory factory = new DiskFileItemFactory();
			      
			      
			      // maximum size that will be stored in memory
			      factory.setSizeThreshold(1024000);
		     
			      // Location to save data that is larger than maxMemSize.
			      factory.setRepository(new File("/home/suraj/temp"));

			      // Create a new file upload handler
			      ServletFileUpload up = new ServletFileUpload(factory);
			      
			  
			    try{
			    	
			    
			    	Map<String , String> input=new HashMap<>();
			    	List fileItems = up.parseRequest(request);
					

			    	Iterator iterator = fileItems.iterator();
			    	String name=request.getParameter("firstname");
			  		String desc=request.getParameter("message");
			  		String incr=request.getParameter("incr");
			        String hour=request.getParameter("hours");
			        String base=request.getParameter("base");
			        String Path="";
			        
			        
				Class.forName("com.mysql.jdbc.Driver");  
				  // Execute SQL query
				Connection con = DriverManager.getConnection(
		                "jdbc:mysql://localhost:3306/P1?autoReconnect=true&useSSL=false", "root", "root123");
				
		         String sql = "INSERT INTO product(name,descr,price,incr,hour,path) values(?, ?, ?, ?, ?, ?)";
		            
		         while (iterator.hasNext()) {
		             FileItem item = (FileItem) iterator.next();
		             if (!item.isFormField()) {
		                 String fileName = item.getName();

		                 String root = getServletContext().getInitParameter("file-path");
		                 File path = new File(root);
		                 if (!path.exists()) {
		                     boolean status = path.mkdirs();
		                 }

		                 File uploadedFile = new File(path + "/" + fileName);
		                 item.write(uploadedFile);
		                 Path=fileName;
		             }
		             else {
		            	 input.put(item.getFieldName(),item.getString("UTF-8"));
		            	 
		             }
		         
		         }
		          
		         out.println(input); 
		         PreparedStatement statement = con.prepareStatement(sql);
		         
		         statement.setString(1, input.get("firstname"));
		         statement.setString(2, input.get("message"));
		         statement.setInt(3,Integer.parseInt(input.get("base")));
		         statement.setInt(4,Integer.parseInt(input.get("hours")));
		         
		         
		         statement.setInt(5,Integer.parseInt(input.get("incr")));
		         statement.setString(6,Path);
		        
		        // InputStream inputStream = new FileInputStream(new File(filePath));
		         
		 
		
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
