package demo_form;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

/**
 * Servlet implementation class JsonProduct
 */

public class JsonProduct extends HttpServlet {


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		
		PrintWriter out = response.getWriter();    

		try {
			  // Execute SQL query
			Class.forName("com.mysql.jdbc.Driver");  
			  // Execute SQL query
			con = DriverManager.getConnection(
	              "jdbc:mysql://localhost:3306/P1", "root", "root123");


					st = con.createStatement();
					//System.out.println("connection established"+ con);
					String qry ="select * from product";
		
			rs = st.executeQuery(qry);
		
			JSONObject jObj = new JSONObject();
			ArrayList<ProductPojo> list=new ArrayList<ProductPojo>();
			Map<String, String> map=new HashMap<String, String>();
			ProductPojo sPojo=null;
			while (rs.next()) {
				
				
				sPojo=new ProductPojo();
				sPojo.setImgid(rs.getInt("imgid"));
				sPojo.setName(rs.getString("name"));
				sPojo.setDesc(rs.getString("descr"));
				sPojo.setPrice(rs.getInt("price"));
				sPojo.setIncr(rs.getInt("incr"));
				sPojo.setHour(rs.getInt("hour"));
				
				
		
				list.add(sPojo);
		
			}
			
		
			jObj.put("ProductDetails",list);
			
			
			response.getWriter().write(jObj.toString());
			
		} 
		catch (Exception e) {
		e.printStackTrace();
		}

		
	}	
	
}

