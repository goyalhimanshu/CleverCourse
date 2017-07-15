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



public class AddQuestion extends HttpServlet {

		 String exam="";
		 int i=0;	
	     
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
		
		HttpSession examnamesession=request.getSession();		
		exam=(String)(examnamesession.getAttribute("exam"));	
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
		out.println("<h3><center><b>ADD QUESTION</b><center></h3><br>");
		out.println("<div align=\"center\">");
		Connection con=DBInfo1.getConnection();
		String query="Select qno from question where sub=?";
		int qno=1;
		try
		{
			PreparedStatement ps=con.prepareStatement(query);
			ps.setString(1,exam.toUpperCase());
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				qno=(rs.getInt("qno")+1);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		out.println("<table>");
		out.println("<form id=\"form1\" name=\"form1\"  action=AddQuestion method=\"post\">");
		out.println("<tr>");
		out.println("<td width=\"169\">Question No::</td>");
		out.println("<td width=\"214\">");
	    out.println("<input type=text name=\"qno\" readonly=true value="+qno+">");
		out.println(" </td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td width=\"169\">Question:</td>");
		out.println("<td width=\"214\">");
	    out.println("<textarea name=\"question\" required autofocus=\"autofocus\"></textarea>");
		out.println(" </td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td width=\"169\">Option A:</td>");
		out.println("<td width=\"214\">");
	    out.println("<input type=\"text\" name=\"option1\" required/>");
		out.println(" </td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td>Option B:</td>");
		out.println("<td><input type=\"text\" name=\"option2\" required/></td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td>Option C:</td>");
		out.println("<td><input type=\"text\" name=\"option3\" required/></td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td>Option D: </td>");
		out.println("<td><input type=\"text\" name=\"option4\"required /></td>");
		out.println("</tr>/");
		out.println("<tr>");
		out.println("<td>Answer Option </td>");
		out.println("<td><input type=\"text\" name=\"answer\" required /></td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td>Explantion</td>");
		out.println("<td>");
		out.println("<label>");
	    out.println("<textarea name=\"explanation\" ></textarea>");
	    out.println("</label>");
		out.println("</td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td colspan=\"2\"><div align=\"center\">");
		out.println("<input type=\"submit\" name=\"addquestion\" value=\"Add Question\" />");
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
		pw.println("<body><div id='top'></div>");
		pw.println("<section id='header' class='bg-color0'><div class='container'><div class='row'><a class='navbar-brand' href='Admin'><img src='../images/yourlogo.png' alt=''> CleverCourse</a>");
		pw.println("<div class='col-sm-12 mainmenu_wrap'><div class='main-menu-icon visible-xs'><span></span><span></span><span></span></div>");
		pw.println("<ul id='mainmenu' class='nav menu sf-menu responsive-menu superfish'>");
        pw.println("<li class=''><a href='Admin'>Home</a></li>");
		pw.println("<li class=''><a href='Courses'>Courses</a></li>");
		pw.println("<li class=''> <a href='About'>About</a></li>");
		pw.println("<li class=''><a href='Contact'>Contact</a></li>");
        pw.println(" </ul></div></div></div></section>");
	    pw.println("<section id='features' class='question_section'>");
		System.out.println("post0"+request.getParameter("qno"));
		Connection con=DBInfo1.getConnection();
		String addquestion="insert into question (question,option1,option2,option3,option4,answer,explanation,sub,qno) values(?,?,?,?,?,?,?,?,?)";
		try
		{
			System.out.println("post1");
			PreparedStatement ps=con.prepareStatement(addquestion);
			ps.setString(1,request.getParameter("question"));
			ps.setString(2,request.getParameter("option1"));
			ps.setString(3,request.getParameter("option2"));
			ps.setString(4,request.getParameter("option3"));
			ps.setString(5,request.getParameter("option4"));
			ps.setString(6,request.getParameter("answer"));
			ps.setString(7,request.getParameter("explanation"));
			ps.setString(8,exam.toUpperCase());
			ps.setInt(9,Integer.parseInt(request.getParameter("qno")));
			i=ps.executeUpdate();
		}
		catch(Exception e)
		{
			System.out.println("post2");
			e.printStackTrace();
		}
		if(i==1)
		{
			out.println("<center>");
			out.println("<h2>Question added.</h2>");
			out.println("<a href=\"AddQuestion\" ><input type=submit value=\"Add More Question\"></a>");
			out.println("<a href=\"Admin\"> <input type=submit value=\"HOME\"</a>");
			
		}
		else
		{
			
		}	
		out.println("</center>");
		pw.println("</section>");
		//footer section
		pw.println("<section id='copyright' class='dark_section' style='margin-top:90px'><div class='container'><div class='row'><div class='col-sm-12'><p class='text-center'>&copy; Copyright 2015. CleverCourse Inc.</p></div></div></div></section>");
		out.println("</body>");
		out.println("</html>");
	}

}
