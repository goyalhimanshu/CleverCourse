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

public class Courses extends HttpServlet {

	String usertype=null;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession usertypesession=request.getSession();		
		usertype=(String)(usertypesession.getAttribute("usertype"));
		
		PrintWriter pw=response.getWriter();
		PrintWriter out=response.getWriter();	
		
		//System.out.println("ExamList uname="+uname);
			
	pw.println("<!DOCTYPE html>");
	 pw.println("<html xmlns=\"http://www.w3.org/1999/xhtml\">");
	 pw.println("<head>");
	 pw.println("<meta http-equiv=\"Content-Type\" content=\"text/html\"; charset=\"iso-8859-1\" />");
	 pw.println("<title></title>");
   

//use single quotes instead of double quotes for simplicity

	 pw.println("<link rel='stylesheet' href='../css/bootstrap.css'><link rel='stylesheet' href='../css/animations.css'><link rel='stylesheet' href='../css/main.css'>");
	
     pw.println("<script src='../js/vendor/modernizr-2.6.2.min.js'></script>");

     pw.println("</head>");

	 pw.println("<body ><div id='top'></div>");
	 if(usertype.equalsIgnoreCase("admin"))
	{
		pw.println("<section id='header' class='bg-color0'><div class='container'><div class='row'><a class='navbar-brand' href=Admin><img src='../images/yourlogo.png' alt=''> CleverCourse</a>");
	}
	else if(usertype.equalsIgnoreCase("student"))
	{
		pw.println("<section id='header' class='bg-color0'><div class='container'><div class='row'><a class='navbar-brand' href=Student><img src='../images/yourlogo.png' alt=''> CleverCourse</a>");
	}
	else
	{
		pw.println("<section id='header' class='bg-color0'><div class='container'><div class='row'><a class='navbar-brand' href=../index.html><img src='../images/yourlogo.png' alt=''> CleverCourse</a>");
	}
	 pw.println("<div class='col-sm-12 mainmenu_wrap'><div class='main-menu-icon visible-xs'><span></span><span></span><span></span></div>");
     pw.println("<ul id='mainmenu' class='nav menu sf-menu responsive-menu superfish'>");
          
	 if(usertype.equalsIgnoreCase("admin"))
			{
				pw.println("<li class=''><a href='Admin'>Home</a></li>");
				pw.println("<li class=''><a href='#'>Courses</a></li>");
				pw.println("<li class=''> <a href='About'>About</a></li>");
				pw.println("<li class=''><a href='Contact'>Contact</a></li>");
			}
			else if(usertype.equalsIgnoreCase("student"))
			{
				pw.println("<li class=''><a href='Student'>Home</a></li>");
				pw.println("<li class=''><a href='#'>Courses</a></li>");
				pw.println("<li class=''> <a href='About'>About</a></li>");
				pw.println("<li class=''><a href='Contact'>Contact</a></li>");
			}
			else
			{
				pw.println("<li class=''><a href='../index.html'>Home</a></li>");
				pw.println("<li class=''><a href='#'>Courses</a></li>");
				pw.println("<li class=''> <a href='About'>About</a></li>");
				pw.println("<li class=''><a href='Contact'>Contact</a></li>");
			}
     
	// pw.println("<li class=''>Username : "+s1+"&nbsp;&nbsp;</li>");
	// pw.println("<li class=''>Password : "+s2+"</li>");
      
     pw.println(" </ul></div></div></div></section>");
	   
	 pw.println("<section id='features' class='question_section'>"); 
out.println("<center>");
				try 
				{
					Connection con=DBInfo1.getConnection();
					PreparedStatement ps = con.prepareStatement("select * from exam");
					ResultSet rs = ps.executeQuery();
					out.println("<h1>Exams</h1>");
					int count=0;
					while ( rs.next()) 
					{
						count++;
	                  //out.println("<h3>" + rs.getString("name") + "</h3>");
					 // examsession.setAttribute("sub",rs.getString("name"));
					 System.out.println("ExamList exam="+rs.getString("name"));
	                  out.println("<img width='215' height='171' src=DisplayPhoto?name=" +  rs.getString("name") + "></img>");
					  if(count%4==0)
					  {
						out.println("<br/>");
					  }
					}
					con.close();
				}
		        catch(Exception ex) 
				{
		            System.out.println(ex.getMessage());
					ex.printStackTrace();
				}
				out.println("</center>");
				pw.println("</section>");
		
		//footer section

	pw.println("<section id='copyright' class='dark_section' style='margin-top:90px'><div class='container'><div class='row'><div class='col-sm-12'><p class='text-center'>&copy; Copyright 2015. CleverCourse Inc.</p></div></div></div></section>");
				out.println("</body>");
				out.println("</html>");
			
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
