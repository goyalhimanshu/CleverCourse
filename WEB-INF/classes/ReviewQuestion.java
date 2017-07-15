

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


public class ReviewQuestion extends HttpServlet {
	
	String exam="";
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter pw=response.getWriter();
		
		HttpSession unamesession=request.getSession();
		String uname=(String)(unamesession.getAttribute("uname"));
		
		HttpSession reviewsession=request.getSession();
		
		
		exam=request.getParameter("exam");
		
		reviewsession.setAttribute("ename",exam);
		
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
				String query="select * from question where sub=?";
				pw.println("<center><br><h1>"+exam.toUpperCase()+" Questions</h1><br>");
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
				pw.println("<th>Delete</th>");
				pw.println("</tr>");
				try
				{
					PreparedStatement ps=con.prepareStatement(query);
					ps.setString(1,exam);
					ResultSet rs=ps.executeQuery();
					while(rs.next())
					{
						pw.println("<tr text-align=\"center\">");
						pw.println("<td>"+rs.getInt("qno")+"</td>");
						pw.println("<td>"+rs.getString("question")+"</td>");
						pw.println("<td>"+rs.getString("option1")+"</td>");
						pw.println("<td>"+rs.getString("option2")+"</td>");
						pw.println("<td>"+rs.getString("option3")+"</td>");
						pw.println("<td>"+rs.getString("option4")+"</td>");
						pw.println("<td>"+rs.getString("answer")+"</td>");
						pw.println("<td>"+rs.getString("explanation")+"</td>");
						pw.println("<td><a href=\"UpdateQuestion?id="+rs.getInt("qno")+"\">UPDATE</a></td>");
						pw.println("<td><a href=\"DeleteQuestion?id="+rs.getInt("qno")+"\">DELETE</a></td>");
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
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
