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



public class UpdateQuestion extends HttpServlet {

	String id="";
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
		pw.println("<body><div id='top'></div>");
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
				
		HttpSession reviewsession=request.getSession();
		exam=(String)(reviewsession.getAttribute("ename"));
		
		HttpSession stuidsession=request.getSession();			
		id=(String)(stuidsession.getAttribute("id"));
		
		System.out.println("id="+id);
		pw.println("<form method=post>");
		Connection con=DBInfo1.getConnection();
		String query="select * from question where sub=?";
		pw.println("<center><br><h1>List of all Records</h1><br>");
		pw.println("<table border=1 align=center width=100%>");
		pw.println("<tr>");
		pw.println("<th>Q.NO.</th>");
		pw.println("<th>Question:</th>");
		pw.println("<th>Option 1</th>");
		pw.println("<th>Option 2</th>");
		pw.println("<th>Option 3</th>");
		pw.println("<th>Option 4</th>");
		pw.println("<th>Answer</th>");
		pw.println("<th>Explanation</th>");
		pw.println("<th>Update</th>");
		pw.println("</tr>");
		try
		{
			PreparedStatement ps=con.prepareStatement(query);
			ps.setString(1,exam);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				pw.println("<tr text-align=\"center\">");
				pw.println("<td><input type=text name=qno value='"+rs.getInt("qno")+"' readonly</td>");
				pw.println("<td><textarea name=question value='"+rs.getString("question")+"'>"+rs.getString("question")+"</textarea></td>");
				pw.println("<td><input type=text name=option1 value='"+rs.getString("option1")+"'></td>");
				pw.println("<td><input type=text name=option2 value='"+rs.getString("option2")+"'></td>");
				pw.println("<td><input type=text name=option3 value='"+rs.getString("option3")+"'></td>");
				pw.println("<td><input type=text name=option4 value='"+rs.getString("option4")+"'></td>");
				pw.println("<td><input type=text name=answer value='"+rs.getString("answer")+"'></td>");
				pw.println("<td><textarea name=question value='"+rs.getString("explanation")+"'>"+rs.getString("explanation")+"</textarea></td>");
				pw.println("<td><input type=submit name=submit value='UPDATE'></td>");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		pw.println("</table>");
		pw.println("</center>");
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
		pw.println("<center><body bgcolor=\"cyan\">");
		Connection con=DBInfo1.getConnection();
		String qno=request.getParameter("qno");
		String question=request.getParameter("question");
		String option1=request.getParameter("option1");
		String option2=request.getParameter("option2");
		String option3=request.getParameter("option3");
		String option4=request.getParameter("option4");
		String answer=request.getParameter("answer");
		String explanation=request.getParameter("explanation");
					
		String query="update question set question=?, option1=?, option2=?, option3=?, option4=?, answer=?, explanation=? where sub=? and qno=?";
		int i=0;
		try
		{
			PreparedStatement ps=con.prepareStatement(query);	
			ps.setString(1,question);
			ps.setString(2,option1);
			ps.setString(3,option2);
			ps.setString(4,option3);
			ps.setString(5,option4);
			ps.setString(6,answer);
			ps.setString(7,explanation);
			ps.setString(8,exam);
			ps.setInt(9,Integer.parseInt(qno));
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
