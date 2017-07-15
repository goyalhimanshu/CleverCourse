

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import javax.servlet.http.*;
import javax.servlet.*;




public class StuReport extends HttpServlet {

	String id="";
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
		PrintWriter pw=response.getWriter();
		
		HttpSession unamesession=request.getSession();
		String uname=(String)(unamesession.getAttribute("uname"));
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
			Connection con=DBInfo1.getConnection();
			try
			{
				System.out.println("StuReport uname="+uname);
				String selectid="select id from login where username=?";
				PreparedStatement ps=con.prepareStatement(selectid);
				ps.setString(1,uname);
				ResultSet rs=ps.executeQuery();
				while(rs.next())
				{
					id=""+rs.getInt(1);
				}
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			pw.println("<!DOCTYPE html>");
			pw.println("<html xmlns=\"http://www.w3.org/1999/xhtml\">");
			pw.println("<head>");
			pw.println("<meta http-equiv=\"Content-Type\" content=\"text/html\"; charset=\"iso-8859-1\" />");
			pw.println("<title></title>");
			pw.println("<link rel='stylesheet' href='../css/bootstrap.css'><link rel='stylesheet' href='../css/animations.css'><link rel='stylesheet' href='../css/main.css'>");
			pw.println("<script src='../js/vendor/modernizr-2.6.2.min.js'></script>");
			pw.println("</head>");
			pw.println("<body><div id='top'></div>");
			pw.println("<section id='header' class='bg-color0'><div class='container'><div class='row'><a class='navbar-brand' href=Student><img src='../images/yourlogo.png' alt=''> CleverCourse</a>");
			pw.println("<div class='col-sm-12 mainmenu_wrap'><div class='main-menu-icon visible-xs'><span></span><span></span><span></span></div>");
			pw.println("<ul id='mainmenu' class='nav menu sf-menu responsive-menu superfish'>");
			pw.println("<li class=''><a href='Student'>Home</a></li>");
			pw.println("<li class=''><a href='Courses'>Courses</a></li>");
			pw.println("<li class=''> <a href='About'>About</a></li>");
			pw.println("<li class=''><a href='Contact'>Contact</a></li>");
		    pw.println(" </ul></div></div></div></section>");
			pw.println("<section id='features' class='question_section'>"); 
			pw.println("<center><br><h1>Report Card of all Exams</h1><br>");
			pw.println("<p>&nbsp;</p>");
			pw.println("<p>&nbsp;</p>");
			
			pw.println("<table align=center border=1>");
			pw.println("<tr>");
			pw.println("<th><center>Date</center></th>");
			pw.println("<th><center>Subject</center></th>");
			pw.println("<th><center>Total Questions</center></th>");
			pw.println("<th><center>Correct Answers</center></th>");
			pw.println("<th><center>Wrong Answers</center></th>");
			pw.println("<th><center>Skipped</center></th>");
			pw.println("<th><center>Certificate</center></th>");
			pw.println("</tr>");
			
			
		
			
			
			String selectreport="SELECT date, subject, total, correct, wrong, skip, time FROM report where id=?";
			try
			{int count=0;
				PreparedStatement ps=con.prepareStatement(selectreport);
				ps.setString(1,id);
				ResultSet rs=ps.executeQuery();
				while(rs.next())
				{
					count++;
					pw.println("<form name='form"+count+"' action=Cert method=post>");
					pw.println("<tr>");
					pw.println("<td align=center><center><input type=text name=time value='"+rs.getTimestamp("time")+"'></center></td>");
					pw.println("<input type=hidden name=date value='"+rs.getString("date")+"'>");
					pw.println("<td align=center><center><input type=text name=exam value='"+rs.getString("subject")+"'></center></td>");
					pw.println("<td align=center><center><input type=text name=tq value='"+rs.getInt("total")+"'></center></td>");
					pw.println("<td align=center><center><input type=text name=correct value='"+rs.getInt("correct")+"'></center></td>");
					pw.println("<td align=center><center>"+rs.getInt("wrong")+"</center></td>");
					pw.println("<td align=center><center>"+rs.getInt("skip")+"</center></td>");
					pw.println("<td align=center><center><input name='submit"+count+"' type=submit value='Generate Certificate'></center></td>");
					pw.println("</form>");
				}
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
			pw.println("</table>");
			
			pw.println("</center>");
			pw.println("<p>&nbsp;</p>");
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		// TODO Auto-generated method stub
	}

}
