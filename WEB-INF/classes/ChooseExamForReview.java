import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import javax.servlet.http.*;
import javax.servlet.*;
import java.sql.*;



public class ChooseExamForReview extends HttpServlet {

		 String exam="";
		 int i=0;	
	     
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
	
		
		PrintWriter pw=response.getWriter();
		PrintWriter out=response.getWriter();
		pw.println("<!DOCTYPE html>");
		pw.println("<html xmlns=\"http://www.w3.org/1999/xhtml\">");
		pw.println("<head>");
		pw.println("<meta http-equiv=\"Content-Type\" content=\"text/html\"; charset=\"iso-8859-1\" />");
		pw.println("<title></title>");
		pw.println("<link rel='stylesheet' href='../css/bootstrap.css'><link rel='stylesheet' href='../css/animations.css'><link rel='stylesheet' href='../css/main.css'>");
		pw.println("<script src='../js/vendor/modernizr-2.6.2.min.js'></script>");
	    pw.println("</head>");
	    pw.println("<body ><div id='top'></div>");
		pw.println("<section id='header' class='bg-color0'><div class='container'><div class='row'><a class='navbar-brand' href='#top'><img src='../images/yourlogo.png' alt=''> CleverCourse</a>");
		pw.println("<div class='col-sm-12 mainmenu_wrap'><div class='main-menu-icon visible-xs'><span></span><span></span><span></span></div>");
	    pw.println("<ul id='mainmenu' class='nav menu sf-menu responsive-menu superfish'>");
	    pw.println("<li class=''><a href='#top'>Home</a></li>");
		pw.println("<li class=''><a href='Courses'>Courses</a></li>");
		pw.println("<li class=''> <a href='About'>About</a></li>");
	    pw.println("<li class=''><a href='Contact'>Contact</a></li>");
		pw.println(" </ul></div></div></div></section>");
		pw.println("<section id='features' class='question_section'>");
		out.println("<h3><center><b>Select Exam</b><center></h3><br>");
		out.println("<div align=\"center\">");
		Connection con=DBInfo1.getConnection();
		
		out.println("<table>");
		out.println("<form id=\"form1\" name=\"form1\"  action=ReviewQuestion method=\"post\">");
		out.println("<tr>");
		out.println("<td width=\"169\">Select Exam::</td>");
		out.println("<td width=\"214\">");
	    out.println("<select name=exam required=true>");
		String selectexam="select name from exam";
		try
		{
			PreparedStatement ps=con.prepareStatement(selectexam);
    		ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				pw.println("<option value=\""+rs.getString("name")+"\">"+rs.getString("name")+"</option>");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
			pw.println("</select></td>");
		pw.println("</tr>");
		out.println("<tr>");
		out.println("<td colspan=\"2\"><div align=\"center\">");
		out.println("<input type=\"submit\" name=\"chooseexamforreview\" value=\"Submit\" />");
		out.println("</div>");
		out.println("</form>");
		out.println("</div></td>");
		out.println("</tr>");
		out.println("</table>");
		pw.println("</section>");
		//footer section
     	pw.println("<section id='copyright' class='dark_section' style='margin-top:50px'><div class='container'><div class='row'><div class='col-sm-12'><p class='text-center'>&copy; Copyright 2015. CleverCourse Inc.</p></div></div></div></section>");
		out.println("</body></html>");	
	}
	
	
	
	//POST==================================================================================================================================================================================

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		
	}

}
