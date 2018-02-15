package demo_form;
	
	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.ResultSet;
	import java.sql.Statement;
	import java.util.ArrayList;
	import java.util.HashMap;
	import java.util.Iterator;
	import java.util.List;
	import java.util.Map;
	import org.json.JSONObject;
	import javax.servlet.ServletException;
	import java.io.IOException;
	import java.io.PrintWriter;
	import javax.servlet.http.HttpServlet;
	import javax.servlet.http.HttpServletRequest;
	import javax.servlet.http.HttpServletResponse;


	
	public class JsonSample extends HttpServlet {
		   @Override
		   public void doGet(HttpServletRequest request, HttpServletResponse response)
		               throws IOException, ServletException {
	// static StudentPojo sPojo;
	/**
	* @param args
	*/
	//public static void main(String[] args) {
	Connection con = null;
	Statement st = null;
	ResultSet rs = null;
	String title = "Database Result";
	PrintWriter out = response.getWriter();    

	try {
		  // Execute SQL query
		Class.forName("com.mysql.jdbc.Driver");  
		  // Execute SQL query
		con = DriverManager.getConnection(
              "jdbc:mysql://localhost:3306/P1", "root", "root123");


				st = con.createStatement();
				//System.out.println("connection established"+ con);
				String qry ="select * from user";
	
		rs = st.executeQuery(qry);
	
		JSONObject jObj = new JSONObject();
		ArrayList<StudentPojo> list=new ArrayList<StudentPojo>();
		Map<String, String> map=new HashMap<String, String>();
		StudentPojo sPojo=null;
	
		
		while (rs.next()) {
			
			
			sPojo=new StudentPojo();
			sPojo.setUname(rs.getString("uname"));
			sPojo.setEmail(rs.getString("email"));
	
			list.add(sPojo);
	
		}
		
	
		jObj.put("UserDetails",list);
		     
		//out.println(jObj.toString());
		
		
		response.getWriter().write(jObj.toString());
		
	} 
	catch (Exception e) {
	e.printStackTrace();
	}

	}

}

	

