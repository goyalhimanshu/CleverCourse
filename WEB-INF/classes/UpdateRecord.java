import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.*;
import javax.servlet.*;
import java.sql.*;
import java.util.*;



public class UpdateRecord extends HttpServlet {

	int id=0;
	String exam="";
	String usertype="";
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		// TODO Auto-generated method stub
		
		HttpSession usertypesession=request.getSession();		
		usertype=(String)(usertypesession.getAttribute("usertype"));

		System.out.println("id="+id);
		PrintWriter pw=response.getWriter();
		pw.println("<!DOCTYPE html>");
		pw.println("<html xmlns=\"http://www.w3.org/1999/xhtml\">");
		pw.println("<head>");
		pw.println("<meta http-equiv=\"Content-Type\" content=\"text/html\"; charset=\"iso-8859-1\" />");
		pw.println("<title></title>");
		pw.println("<link rel='stylesheet' href='../css/bootstrap.css'><link rel='stylesheet' href='../css/animations.css'><link rel='stylesheet' href='../css/main.css'>");
		pw.println("<script src='../js/vendor/modernizr-2.6.2.min.js'></script>");
		pw.println("</head>");
		pw.println("<body ><div id='top'></div>");
		if(usertype.equalsIgnoreCase("admin"))
		{
			pw.println("<section id='header' class='bg-color0'><div class='container'><div class='row'><a class='navbar-brand' href=Admin><img src='../images/yourlogo.png' alt=''> CleverCourse</a>");
		}
		else
		{
			pw.println("<section id='header' class='bg-color0'><div class='container'><div class='row'><a class='navbar-brand' href=Student><img src='../images/yourlogo.png' alt=''> CleverCourse</a>");
		}
		pw.println("<div class='col-sm-12 mainmenu_wrap'><div class='main-menu-icon visible-xs'><span></span><span></span><span></span></div>");
		pw.println("<ul id='mainmenu' class='nav menu sf-menu responsive-menu superfish'>");
		if(usertype.equalsIgnoreCase("admin"))
		{
			pw.println("<li class=''><a href='Admin'>Home</a></li>");
		}
		else
		{
			pw.println("<li class=''><a href='Student'>Home</a></li>");
		}
		pw.println("<li class=''><a href='Courses'>Courses</a></li>");
		pw.println("<li class=''> <a href='About'>About</a></li>");
		pw.println("<li class=''><a href='Contact'>Contact</a></li>");
	    pw.println(" </ul></div></div></div></section>");
		pw.println("<section id='features' class='question_section'>");
		Connection con=DBInfo1.getConnection();
		
		HttpSession examnamesession=request.getSession();		
		exam=(String)(examnamesession.getAttribute("exam"));
		
		id=Integer.parseInt(request.getParameter("id"));
		
		System.out.println("id="+id);
		
		String query="select * from login where id=?";
		pw.println("<p>&nbsp;</P>");
		pw.println("<table align=\"center\">");
		pw.println("<tr>");
		pw.println("<td>");
		pw.println("<fieldset><legend><strong>Update Info</strong></legend>");		
		pw.println("<center><form method=post>");		
		pw.println("<table align=\"center\">");
		ResultSet rs;
		try
		{
			PreparedStatement ps=con.prepareStatement(query);	
			ps.setInt(1,(id));
			rs=ps.executeQuery();
			while(rs.next())
			{
				pw.println("<tr><td>ID</td><td> <input type=text name=id value="+rs.getInt(1)+" readonly></td></tr>");
				pw.println("<tr><td>Username</td><td><input type=text name=uname value="+rs.getString(2)+" readonly></td></tr>");
				pw.println("<tr><td>New Password</td><td><input type=text name=pass value="+rs.getString(3)+"></td></tr>");
				pw.println("<tr><td>New Usertype</td><td><input type=text name=utype value="+rs.getString(4)+"></td></tr>");
				
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		pw.println("<tr><td colspan=2 align=center><input type=submit></form></center></td></tr>");
		pw.println("</table></form>");
		pw.println("</fieldset>");
		pw.println("</td>");
		pw.println("</tr>");
		pw.println("</table>");
		pw.println("</body>");
		pw.println("</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
		PrintWriter pw=response.getWriter();
		pw.println("<!DOCTYPE html>");
		pw.println("<html xmlns=\"http://www.w3.org/1999/xhtml\">");
		pw.println("<head>");
		pw.println("<meta http-equiv=\"Content-Type\" content=\"text/html\"; charset=\"iso-8859-1\" />");
		pw.println("<title></title>");
		pw.println("<link rel='stylesheet' href='../css/bootstrap.css'><link rel='stylesheet' href='../css/animations.css'><link rel='stylesheet' href='../css/main.css'>");
	    pw.println("<script src='../js/vendor/modernizr-2.6.2.min.js'></script>");
		pw.println("</head>");
		pw.println("<body background=\"../images/background.jpg\"><div id='top'></div>");
		if(usertype.equalsIgnoreCase("admin"))
		{
			pw.println("<section id='header' class='bg-color0'><div class='container'><div class='row'><a class='navbar-brand' href=Admin><img src='../images/yourlogo.png' alt=''> CleverCourse</a>");
		}
		else
		{
			pw.println("<section id='header' class='bg-color0'><div class='container'><div class='row'><a class='navbar-brand' href=Student><img src='../images/yourlogo.png' alt=''> CleverCourse</a>");
		}
		pw.println("<div class='col-sm-12 mainmenu_wrap'><div class='main-menu-icon visible-xs'><span></span><span></span><span></span></div>");
		pw.println("<ul id='mainmenu' class='nav menu sf-menu responsive-menu superfish'>");
		if(usertype.equalsIgnoreCase("admin"))
		{
			pw.println("<li class=''><a href='Admin'>Home</a></li>");
		}
		else
		{
			pw.println("<li class=''><a href='Student'>Home</a></li>");
		}
		pw.println("<li class=''><a href='Courses'>Courses</a></li>");
		pw.println("<li class=''> <a href='About'>About</a></li>");
		pw.println("<li class=''><a href='Contact'>Contact</a></li>");
	    pw.println(" </ul></div></div></div></section>");
	    pw.println("<section id='features' class='question_section'>");
		pw.println("<center><body bgcolor=\"cyan\">");
		Connection con=DBInfo1.getConnection();
		String pass=request.getParameter("pass");
		String utype=request.getParameter("utype");
		
				
		String query="update login set password=? where id=?";
		int i=0;
		try
		{
			PreparedStatement ps=con.prepareStatement(query);	
			ps.setString(1,pass);
		//	ps.setString(2,utype);
			ps.setInt(2,(id));
			i=ps.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		pw.println("<br>");
		pw.println("<br>");
		pw.println("<br>");
		pw.println("<br>");
		if(i==1)
		{
			pw.println("<b>Info updated<b>");
		}
		else
		{
			pw.println("<b>No Record(s) updated<b>");
		}
		
		if(usertype.equalsIgnoreCase("admin"))
		{
			pw.println("<br><br><a href=\"Admin\">BACK</a>");
		}
		else
		{
			pw.println("<br><br><a href=\"Student\">BACK</a>");
		}
		pw.println("</form></center>");
		pw.println("</section>");
		//footer section
		pw.println("<section id='copyright' class='dark_section' style='margin-top:90px'><div class='container'><div class='row'><div class='col-sm-12'><p class='text-center'>&copy; Copyright 2015. CleverCourse Inc.</p></div></div></div></section>");
		pw.println("</body>");
		pw.println("</html>");
	}
}
