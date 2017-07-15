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
import java.util.Date;
import java.text.DateFormat;

public class Result extends HttpServlet 
{
	String exam="";
	
	
	public static java.sql.Timestamp getCurrentTimeStamp()
			{
				java.util.Date today = new java.util.Date();
				return new java.sql.Timestamp(today.getTime());
			}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
	
	
	
	
		HttpSession examnamesession=request.getSession();
		exam=(examnamesession.getAttribute("exam")).toString();
		
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
			int c = 0,w = 0,s=0;
			String id="";
			
			HttpSession correctsession=request.getSession();
			c=Integer.parseInt((correctsession.getAttribute("c")).toString());
			
			HttpSession wrongsession=request.getSession();
			w=Integer.parseInt((wrongsession.getAttribute("w")).toString());
			
			HttpSession totalsession=request.getSession();
			int tq=Integer.parseInt((totalsession.getAttribute("tq")).toString());
			
			HttpSession skipsession=request.getSession();
			s=Integer.parseInt((skipsession.getAttribute("s")).toString());
			
			
			HttpSession datesession=request.getSession();
		
			
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
			pw.println("<section id='header' class='bg-color0'><div class='container'><div class='row'><a class='navbar-brand' href=Student><img src='../images/yourlogo.png' alt=''> CleverCourse</a>");
			pw.println("<div class='col-sm-12 mainmenu_wrap'><div class='main-menu-icon visible-xs'><span></span><span></span><span></span></div>");
			pw.println("<ul id='mainmenu' class='nav menu sf-menu responsive-menu superfish'>");
			pw.println("<li class=''><a href='Student'>Home</a></li>");
			pw.println("<li class=''><a href='Courses'>Courses</a></li>");
			pw.println("<li class=''> <a href='About'>About</a></li>");
			pw.println("<li class=''><a href='Contact'>Contact</a></li>");
			pw.println(" </ul></div></div></div></section>");
			pw.println("<section id='features' class='question_section'>"); 
			out.println("<center><h3>Here's your Result</h3><br>");
			out.println("<table width=\"200\" border=\"0\" align=\"center\">");
			out.println("<tbody>");
			out.println("<tr>");
			out.println("<th scope=\"col\">Question Attempted</th>");
			out.println("<th scope=\"col\">&nbspCorrect Answers</th>");
			out.println("<th scope=\"col\">&nbspWrong Answers</th>");
			out.println("<th scope=\"col\">&nbspSkipped Questions</th>");
			out.println("</tr>");
			out.println("<tr>");
			out.println("<td scope=\"col\">"+tq+"</td>");
			out.println("<td scope=\"col\">"+c+"</td>");
			out.println("<td scope=\"col\">"+w+"</td>");
			out.println("<td scope=\"col\">"+s+"</td>");
			out.println("</tr>");
			out.println("</tbody>");
			out.println("</table>");
			out.println("<br><a href=\"Student\"><input type=submit value=HOME></a>");
			out.println("</center>");
			out.println("<p>&nbsp;</p>");
			out.println("<p>&nbsp;</p>");
			pw.println("</section>");
			//footer section
			pw.println("<section id='copyright' class='dark_section' style='margin-top:90px'><div class='container'><div class='row'><div class='col-sm-12'><p class='text-center'>&copy; Copyright 2015. CleverCourse Inc.</p></div></div></div></section>");
			out.println("</body>");
			out.println("</html>");	
			
			
			
			
			
			Connection con=DBInfo1.getConnection();
			try
			{
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
			try
			{
				 DateFormat defaultDf = DateFormat.getDateInstance();
				Date date = new Date();
				datesession.setAttribute("date",defaultDf.format(date));
				System.out.println("ResultPost for Subject Column Exam="+exam);
				String insert="insert into report values(?,?,?,?,?,?,?,?)";
				PreparedStatement ps=con.prepareStatement(insert);
				ps.setString(1,exam);
				ps.setInt(2,tq);
				ps.setInt(3,c);
				ps.setInt(4,w);
				ps.setInt(5,s);
				ps.setString(6,id);
				ps.setString(7,defaultDf.format(date));
				ps.setTimestamp(8,getCurrentTimeStamp());
				ps.executeUpdate();
				tq=1;
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
			correctsession.setAttribute("c",0);
			totalsession.setAttribute("tq",0);
			skipsession.setAttribute("s",0);
			wrongsession.setAttribute("w",0);
			
			
			
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
