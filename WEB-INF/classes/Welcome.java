

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.http.*;
import javax.servlet.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Welcome extends HttpServlet 
{
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter pw=response.getWriter();
		pw.println("<html>");
		pw.println("<head>");
		pw.println("<link href=\"../css/styles.css\" type=\"text/css\" rel=\"stylesheet\" />");
		pw.println("</head>");
		pw.println("<body bgcolor=\"cyan\">");
		pw.println("<div id=\"header\">");
		pw.println("<div class=\"wrap\">");
		pw.println("<div class=\"logo\">");
		pw.println("<a href=\"#\"><img src=\"../images/yourlogo.png\"></a>");
		pw.println("</div>");
		pw.println("<p>Other content for your header</p>");
		pw.println("</div>");
		pw.println("</div>");
		String uname="";
		uname=request.getParameter("uname");
		String pass="";
		pass=request.getParameter("pass");
		
		HttpSession unamesession=request.getSession();
		unamesession.setAttribute("uname",uname);		// HttpSession  to send username as uname 
		
		HttpSession usertypesession=request.getSession();
		
		
		//String utype=request.getParameter("utype");
		Connection con=DBInfo1.getConnection();
		String query="select * from login where username=? and password=?";
		try
		{
			PreparedStatement ps=con.prepareStatement(query);
			ps.setString(1,uname);
			ps.setString(2,pass);
			ResultSet rs=ps.executeQuery();
			
			
			while(rs.next())
			{
				usertypesession.setAttribute("usertype",rs.getString(4));
				if(rs.getString(4).equalsIgnoreCase("admin"))
				{
					pw.println("<h3> Welcome Admin </h3>");
					response.sendRedirect("Admin");
				}
				if(rs.getString(4).equalsIgnoreCase("student"))
				{
					pw.println("<h3> Welcome Student </h3>");
					response.sendRedirect("Student");//rs.getString(2));
				}
				
				
				
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		pw.println("<center><font color=red>Wrong Username or Passwords</font>");
		pw.println("<br><a href=\"../index.html\" >BACK</a></center>");
		pw.println("<div id=\"footer\">");
pw.println("<div class=\"wrap\">");
pw.println("<p>Other content for your header</p>");
pw.println("</div>");
pw.println("</div>");
		pw.println("</body>");
		pw.println("</html>");
	}

}
