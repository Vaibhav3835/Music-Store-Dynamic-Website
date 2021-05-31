package webpackage1;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class servlet1
 */
@WebServlet("/servlet1")
public class servlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servlet1() {
        super();
        // TODO Auto-generated constructor stub
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.getWriter().append("Served at: ").append(request.getContextPath());
     
       
       String s1=request.getParameter("action");
       System.out.println(s1);
       
       try {	
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/shopdata?serverTimezone=UTC", "root", "");
	
		 if("Store".equals(s1))
		 { 
			  System.out.println(request.getParameter("cd id"));
		     System.out.println(request.getParameter("cd name"));
		     System.out.println(request.getParameter("cd quant"));
		     System.out.println(request.getParameter("cd price"));
		     System.out.println(request.getParameter("cd quant"));
		     int quantity=Integer.parseInt(request.getParameter("cd quant"));
		     int price=Integer.parseInt(request.getParameter("cd price"));
		    String cid=request.getParameter("cd id");
		    String cname=request.getParameter("cd name");
		    int cquant=quantity;
		    int cprice=price;
				PreparedStatement q = conn.prepareStatement("insert into cd_details values(?,?,?,?);");
				q.setString(1, cid);
				q.setString(2,cname);
				q.setInt(3,cquant);
				q.setInt(4, cprice);
				int x = q.executeUpdate();
				PrintWriter out=response.getWriter();
				if (x > 0) {	
					response.setContentType("text/html");
			        PrintWriter out1 = response.getWriter();

			        out1.println("<title>Page1</title>" +
			           "<body bgcolor=FFFFF>");

			        out1.println("<h2>Item stored</h2>");

				}
		 }
		 else if("ShowInventory".equals(s1))
		 {
				PreparedStatement qs = conn.prepareStatement("select * from cd_details");
				ResultSet rs = qs.executeQuery();
				System.out.println("ID\tName\tQuantity\tPrice" );
     	        response.setContentType("text/html");
			        PrintWriter out = response.getWriter();
			       
			        out.println("<title>Page1</title> <body bgcolor=FFFFF>");
			       out.println("<P ALIGN='center'><TABLE BORDER=1 >");
			       // table header
			       out.println("<TR>");
			      
			         out.println("<TH> CD ID</TH>"
			         		+ "<th>CD Name</th>"
			         		+ "<th>CD Quantity</th>"
			         		+ "<th>Cd Price</th>");
			       out.println("</TR>");
			       // the data
			       while (rs.next()) {
			        out.println("<TR>");
			          out.println("<TD>" +rs.getString("cd_id")+ "</TD>"
			          		+ "<td>"+ rs.getString("cd_name") +"</td>"
			          				+ "<td>"+rs.getString("cd_quantity")+"</td>"
			          						+ "<td>"+(rs.getInt("cd_price")+"</td>"));
			          
			        out.println("</TR>");
			        }
			       out.println("</TABLE></P>");
			      
			      }

		 else if("Purchase".equals(s1))
		 {
			       response.setContentType("text/html");
		             PrintWriter out = response.getWriter();
					PreparedStatement q1 = conn.prepareStatement("select cd_quantity,cd_name from cd_details where cd_id=?");
					q1.setString(1, request.getParameter("sid"));
					ResultSet r1 = q1.executeQuery();
					if(r1.next())
					{   String name =r1.getString("cd_name");
						int newvalue = r1.getInt("cd_quantity");
						newvalue=newvalue-1;
						PreparedStatement q2 = conn.prepareStatement("UPDATE cd_details  set cd_quantity=? where cd_id=?");
						q2.setInt(1, newvalue);
						q2.setString(2,request.getParameter("sid"));
						int x1=q2.executeUpdate();
						PreparedStatement q3 = conn.prepareStatement("select cd_price from cd_details where cd_id=?");
						q3.setString(1,request.getParameter("sid"));
						ResultSet r3 = q3.executeQuery();
						if(r3.next())
						{
							 out.println("<title>Page1</title>" +
							           "<body bgcolor=FFFFF>");
							out.println("<h1> CD Purchased: "+r1.getString("cd_name")+"</h1>");
						   out.println("<h1> Total Bill: "+r3.getInt("cd_price")+"</h1>");
						}
						else
						{
							System.out.println("no");
						}
					}	
					else
					{
						out.println("<h3>No Cd found</h3>");
					}
			
		 }
		 
		 else if("Exit Application".contentEquals(s1))
		 {
			 response.setContentType("text/html");
             PrintWriter out = response.getWriter();
             out.println("<title>Page1</title>" +
			           "<body bgcolor=FFFFF>");
             out.println("<h1> Application Closed Thanks for Visiting</h1>");
		 }
       }	 
       catch(Exception e)
       {
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
