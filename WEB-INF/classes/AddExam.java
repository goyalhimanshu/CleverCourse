import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import javax.servlet.http.*;
import javax.servlet.*;
import java.sql.*;
import java.util.*;


@MultipartConfig
public class AddExam extends HttpServlet 
{
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
		PrintWriter pw=response.getWriter();
		PrintWriter out=response.getWriter();
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

	 pw.println("<body><div id='top'></div>");
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
	 pw.println("<br/>");
			out.println("<h3><center><strong>Add Exam</strong></h3></center><br>");
			out.println("<form enctype=\"multipart/form-data\"  id=addexam method=\"post\" >");
			out.println("<table width=\"400\" border=\"0\" align=\"center\">");
			out.println("<tbody>");
			out.println("<tr>");
			out.println("<td width=200><div align=\"center\">Exam Name </div></td>");
			out.println("<td width=200 align=center><input type=text name=\"name\" required autofocus=\"autofocus\" value=\"\"></td>");
			out.println("</tr>");
			out.println("<tr>");
			out.println("<td width=200><div align=\"center\">Select image </div></td>");
			out.println("<td width=300 align=center><input type=file name=\"image\" required autofocus=\"autofocus\" value=\"\">(max size 1MB)</td>");
			out.println("</tr>");
			out.println("<tr>");
			out.println("<td colspan=2><div align=center>");
	        out.println("<input type=submit name=addexam value=\"Add Exam\" />");
			out.println("</form></td></tr></table>");
			pw.println("</section>");
		
		//footer section

	pw.println("<section id='copyright' class='dark_section' style='margin-top:90px'><div class='container'><div class='row'><div class='col-sm-12'><p class='text-center'>&copy; Copyright 2015. CleverCourse Inc.</p></div></div></div></section>");

			out.println("</body></html>");	
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		// TODO Auto-generated method stub
		int flag=1;
		PrintWriter out = response.getWriter();
		PrintWriter pw = response.getWriter();
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
      
     pw.println(" </ul></div></div></div></section>");
	   
	 pw.println("<section id='features' class='question_section'><center>");
	 pw.println("<br/>");
        try
		{
            Part p =  request.getPart("name");
            Scanner scanner  = new Scanner( p.getInputStream());
            String name = scanner.nextLine(); 
            Part photo =  request.getPart("image");
            // Connect to Oracle
	        Connection con=DBInfo1.getConnection();
	        con.setAutoCommit(false);
			PreparedStatement ps1 = con.prepareStatement("select name from exam where name=?");
			ps1.setString(1,name.toUpperCase());
			ResultSet rs=ps1.executeQuery();
			
			HttpSession examnamesession=request.getSession();
			examnamesession.setAttribute("exam",name);
			
			while(rs.next())
			{
				flag=0;
				break;
			}
			if(flag==1 && ((int)  photo.getSize())<1048756)
			{
			
				System.out.println("Size="+(int)  photo.getSize());
				PreparedStatement ps2 = con.prepareStatement("insert into exam values(?,?)");
	            ps2.setString(1, name);
	            // size must be converted to int otherwise it results in error
	            ps2.setBinaryStream(2, photo.getInputStream(), (int)  photo.getSize());
	            ps2.executeUpdate();
				out.println("Exam Successfully Added. <p> <a href=AddQuestion><input type=submit value=\"Add Question\"></a>");
			}
			else
			{
				if(((int)  photo.getSize())>1048756)
				{
					out.println("<h2>Image Size exceede 1MB. Please try again</h2>");
					out.println("<a href=\"AddExam\" ><input type=submit value=\"Add Question\"></a>");
				}
				else
				{
					System.out.println("exam="+name+" not added");
					out.println("<h2>Exam Already Exist. You can add questions to this exam or you can create new exam</h2>");
					out.println("<a href=\"AddQuestion\" ><input type=submit value=\"Add Question\"></a>");
					out.println("<a href=\"AddExam\"> <input type=submit value=\"Add New Exam\"</a>");
				}
				
			}            
            con.commit();
            con.close();
        } 
        catch(Exception ex) 
		{
            System.out.println(ex.getMessage());
			ex.printStackTrace();
        }
		pw.println("</center></section>");
		pw.println("<br/>");
		pw.println("<br/>");
		pw.println("<br/>");
		
		//footer section

	pw.println("<section id='copyright' class='dark_section' style='margin-top:90px'><div class='container'><div class='row'><div class='col-sm-12'><p class='text-center'>&copy; Copyright 2015. CleverCourse Inc.</p></div></div></div></section>");

		out.println("</body>");
		out.println("</html>");
    }
}