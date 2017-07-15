import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class AfterTest extends HttpServlet {
	
	int c = 0,w = 0,tq=0,s=0;
	int id;
	String exam="";
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		PrintWriter out=response.getWriter();
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
		pw.println("<section id='header' class='bg-color0'><div class='container'><div class='row'><a class='navbar-brand' href='#top'><img src='../images/yourlogo.png' alt=''> CleverCourse</a>");
		pw.println("<div class='col-sm-12 mainmenu_wrap'><div class='main-menu-icon visible-xs'><span></span><span></span><span></span></div>");
		pw.println("<ul id='mainmenu' class='nav menu sf-menu responsive-menu superfish'>");
        pw.println("<li class=''><a href='#top'>Home</a></li>");
		pw.println("<li class=''><a href='#'>Courses</a></li>");
		pw.println("<li class=''> <a href='#'>About</a></li>");
		pw.println("<li class=''><a href='#'>Contact</a></li>");
		pw.println(" </ul></div></div></div></section>");
	    pw.println("<section id='features' class='question_section'>");out.println("<p>&nbsp;</p>");
		out.println("<center><h3>Your Test is completed</h3><br>");
		out.println("<form method=post>");
		out.println("<input type=submit name=result value=Result>");
		out.println("</form></center>");
		out.println("<p>&nbsp;</p>");
		pw.println("</section>");
		//footer section
		pw.println("<section id='copyright' class='dark_section' style='margin-top:90px'><div class='container'><div class='row'><div class='col-sm-12'><p class='text-center'>&copy; Copyright 2015. CleverCourse Inc.</p></div></div></div></section>");
		out.println("</body>");
		out.println("</html>");	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		// TODO Auto-generated method stub
		System.out.println("AfterTestPost Exam="+exam);
		response.sendRedirect("Result");
	}

}
