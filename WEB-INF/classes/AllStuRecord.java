

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.*;
import javax.servlet.*;
import java.sql.Timestamp;


public class AllStuRecord extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter pw=response.getWriter();
		
		HttpSession unamesession=request.getSession();
		String uname=(String)(unamesession.getAttribute("uname"));
		System.out.println("Result uname="+uname);
		if(uname==null)
		{
			pw.println("<!DOCTYPE HTML PUBLIC \"-//IETF//DTD HTML 2.0//EN\">");				
			pw.println("<html><head>");
			pw.println("<title>403 Forbidden</title>");
			pw.println("</head><body>");
			pw.println("<h1>Forbidden</h1>");
			pw.println("<p>You don't have permission to access status on this server.</p>");	
			pw.println("<hr>");
			pw.println("<address>Apache/8.0.23 Server at www.CleverCourse.com Port 80</address>");
			pw.println("</body></html>");
			}
			else
			{
				pw.println("<!DOCTYPE html>");
				//pw.println("<input type=hidden name=rstream value="+uname+">");
	 pw.println("<html xmlns=\"http://www.w3.org/1999/xhtml\">");
	 pw.println("<head>");
	 pw.println("<meta http-equiv=\"Content-Type\" content=\"text/html\"; charset=\"iso-8859-1\" />");
	 pw.println("<title></title>");
   

//use single quotes instead of double quotes for simplicity

	 pw.println("<link rel='stylesheet' href='../css/bootstrap.css'><link rel='stylesheet' href='../css/animations.css'><link rel='stylesheet' href='../css/main.css'>");
	
     pw.println("<script src='../js/vendor/modernizr-2.6.2.min.js'></script>");

     pw.println("</head>");

	 pw.println("<body ><div id='top'></div>");
	 pw.println("<section id='header' class='bg-color0'><div class='container'><div class='row'><a class='navbar-brand' href='Admin'><img src='../images/yourlogo.png' alt=''> CleverCourse</a>");
	 
	 pw.println("<div class='col-sm-12 mainmenu_wrap'><div class='main-menu-icon visible-xs'><span></span><span></span><span></span></div>");
     pw.println("<ul id='mainmenu' class='nav menu sf-menu responsive-menu superfish'>");
          
	 pw.println("<li class=''><a href='Admin'>Home</a></li>");
	 pw.println("<li class=''><a href='Courses'>Courses</a></li>");
	 pw.println("<li class=''> <a href='About'>About</a></li>");
     pw.println("<li class=''><a href='Contact'>Contact</a></li>");
	// pw.println("<li class=''>Username : "+s1+"&nbsp;&nbsp;</li>");
	// pw.println("<li class=''>Password : "+s2+"</li>");
      
     pw.println(" </ul></div></div></div></section>");
	   
	 pw.println("<section id='features' class='question_section'>");
				Connection con=DBInfo1.getConnection();
				String query="select * from login";
				pw.println("<center><br><h1>List of all Records</h1><br>");
				pw.println("<table border=1 align=center>");
				pw.println("<tr>");
				pw.println("<th>ID</th>");
				pw.println("<th>UserName</th>");
				pw.println("<th>Password</th>");
				pw.println("<th>UserType</th>");
				pw.println("<th>Update</th>");
				pw.println("<th>Delete</th>");
				pw.println("</tr>");
				
				
				try
				{
					PreparedStatement ps=con.prepareStatement(query);
					ResultSet rs=ps.executeQuery();
					while(rs.next())
					{
						pw.println("<tr text-align=\"center\">");
						pw.println("<td align=center>"+rs.getInt(1)+"</td>");
						pw.println("<td align=center>"+rs.getString(2)+"</td>");
						pw.println("<td align=center>"+rs.getString(3)+"</td>");
						pw.println("<td align=center>"+rs.getString(4)+"</td>");
						pw.println("<td align=center><a href=\"UpdateRecord?id="+rs.getInt(1)+"\"><input type=submit value=UPDATE></a></td>");
						pw.println("<td align=center><a href=\"DeleteRecord?id="+rs.getInt(1)+"\"><input type=submit value=DELETE></a></td>");
					}
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				pw.println("</table>");
				pw.println("</center>");
				pw.println("<p>&nbsp;</p>");
				pw.println("</section>");
		
		//footer section

	pw.println("<section id='copyright' class='dark_section' style='margin-top:90px'><div class='container'><div class='row'><div class='col-sm-12'><p class='text-center'>&copy; Copyright 2015. CleverCourse Inc.</p></div></div></div></section>");

				pw.println("</body>");
				pw.println("</html>");
			}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
