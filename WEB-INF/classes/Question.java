import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.*;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Question extends HttpServlet 
{
	int count=0;
    int qno=1;
	int correct=0,wrong=0,skip=0;
	String correctans="";
	static String exam="";
 	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		// TODO Auto-generated method stub
		PrintWriter pw=response.getWriter();
		pw.println("<!DOCTYPE html>");
		//pw.println("<input type=hidden name=rstream value="+uname+">");
		pw.println("<html xmlns=\"http://www.w3.org/1999/xhtml\">");
		pw.println("<head>");
		pw.println("<meta http-equiv=\"Content-Type\" content=\"text/html\"; charset=\"iso-8859-1\" />");
		pw.println("<title></title>");
		pw.println("<link rel='stylesheet' href='../css/bootstrap.css'><link rel='stylesheet' href='../css/animations.css'><link rel='stylesheet' href='../css/main.css'>");
	    pw.println("<script src='../js/vendor/modernizr-2.6.2.min.js'></script>");
		pw.println("</head>");
		pw.println("<body><div id='top'></div>");
		pw.println("<section id='header' class='bg-color0'><div class='container'><div class='row'><a class='navbar-brand' href='#top'><img src='../images/yourlogo.png' alt=''> CleverCourse</a>");
		pw.println("<div class='col-sm-12 mainmenu_wrap'><div class='main-menu-icon visible-xs'><span></span><span></span><span></span></div>");
		pw.println("<ul id='mainmenu' class='nav menu sf-menu responsive-menu superfish'>");
        pw.println("<li class=''><a href='#'>Home</a></li>");
		pw.println("<li class=''><a href='#'>Courses</a></li>");
		pw.println("<li class=''> <a href='#'>About</a></li>");
		pw.println("<li class=''><a href='#'>Contact</a></li>");
		pw.println(" </ul></div></div></div></section>");
	    pw.println("<section id='features' class='question_section'>");
		
		
		exam=request.getParameter("exam");
		
		HttpSession examnamesession=request.getSession();
		examnamesession.setAttribute("exam",exam);
		
		
		System.out.println("Question start exam="+exam);
	 	
		System.out.println("Hello");
		
		pw.println("<form method=post>");
	 	Connection con=DBInfo1.getConnection();
		pw.println("<table border=0>");
		pw.println("</tr>");
		String query2="select * from question where qno=? and sub=? ";
		try
		{
			PreparedStatement ps=con.prepareStatement(query2);
			ps.setInt(1,qno);
			ps.setString(2,exam);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
			   int q=rs.getInt("qno");
			   System.out.println("q="+q);
			   String question=rs.getString("question");
			   String o1=rs.getString("option1");
			   String o2=rs.getString("option2");
			   String o3=rs.getString("option3");
			   String o4=rs.getString("option4");
			   correctans=rs.getString("answer");
			   pw.println("<input type=hidden name=\"qno\" value="+qno+">");
			   pw.println("<tr>"+qno+":&nbsp;<td><p>"+question+"</p></td></tr>");
			   pw.println("<tr><td>A.<input type=radio name=option value=a>"+o1+"</td></tr>");
			   pw.println("<tr><td>B.<input type=radio name=option value=b>"+o2+"</td></tr>");
			   pw.println("<tr><td>C.<input type=radio name=option value=c>"+o3+"</td></tr>");
			   pw.println("<tr><td>D.<input type=radio name=option value=d>"+o4+"</td></tr>");
			   pw.println("<tr><td>E.<input type=radio name=option value=e>Skip</td></tr>");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		pw.println("<tr><td colspan=2>");
		pw.println("<input type=submit value=\"NEXT>>\"></td></tr>");
		pw.println("</table>");
		DBInfo1.close();	 
		pw.println("</form>");
		pw.println("</section>");
		//footer section
		pw.println("<section id='copyright' class='dark_section' style='margin-top:90px'><div class='container'><div class='row'><div class='col-sm-12'><p class='text-center'>&copy; Copyright 2015. CleverCourse Inc.</p></div></div></div></section>");
		pw.println("</body>");
		pw.println("</html>");
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		// TODO Auto-generated method stub
		System.out.println("ExamListPost exam="+exam);
		System.out.println(" before qno="+qno);
		try
		{
			qno=Integer.parseInt(request.getParameter("qno"));
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		System.out.println("after qno="+qno);
		String ans=request.getParameter("option");
		System.out.println("ans="+ans);
		if(ans==null)
		{
			skip++;
		}
		else
		{
			if(ans.equalsIgnoreCase("e"))
			{
				skip++;
			}
			else
			{
				if(correctans.equalsIgnoreCase(ans))
				{
					correct++;
				}
				else
				{
					wrong++;
				}	 
			} 
		}
		Connection con=DBInfo1.getConnection();
		String query="SELECT COUNT(*) AS COUNT FROM question where sub=?";
		try
		{
			PreparedStatement ps=con.prepareStatement(query);
			ps.setString(1,exam);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				count=rs.getInt("COUNT");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		HttpSession correctsession=request.getSession();
		HttpSession totalsession=request.getSession();
		HttpSession wrongsession=request.getSession();
		HttpSession skipsession=request.getSession();
		
		
		
		
		
		
		if(qno==count)
		{
			wrongsession.setAttribute("c",correct);
			correctsession.setAttribute("w",wrong);
			totalsession.setAttribute("tq",qno);
			skipsession.setAttribute("s",skip);
			response.sendRedirect("AfterTest");
		}
		else
		{
			qno++;
			doGet(request, response);
		}
		DBInfo1.close();
	}
}
