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



public class Registration extends HttpServlet {

static int flag=0;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter pw=response.getWriter();
		String s="";
		for(int i=0;i<6;i++)
		{
			s+=(int)(Math.random()*8)+1;
		}
		int id=Integer.parseInt(s);
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
	 pw.println("<section id='header' class='bg-color0'><div class='container'><div class='row'><a class='navbar-brand' href='#top'><img src='../images/yourlogo.png' alt=''> CleverCourse</a>");
	 
	 pw.println("<div class='col-sm-12 mainmenu_wrap'><div class='main-menu-icon visible-xs'><span></span><span></span><span></span></div>");
     pw.println("<ul id='mainmenu' class='nav menu sf-menu responsive-menu superfish'>");
          
	 pw.println("<li class=''><a href='../index.html'>Home</a></li>");
	 pw.println("<li class=''><a href='../index.html'>Login</a></li>");
     pw.println("<li class=''><a href='#'>Courses</a></li>");
	 pw.println("<li class=''> <a href='#'>About</a></li>");
     pw.println("<li class=''><a href='#'>Contact</a></li>");
	// pw.println("<li class=''>Username : "+s1+"&nbsp;&nbsp;</li>");
	// pw.println("<li class=''>Password : "+s2+"</li>");
      
     pw.println(" </ul></div></div></div></section>");
	   
	 pw.println("<section id='features' class='question_section'>");
	 pw.println("<p>&nbsp;</P>");
	 pw.println("<table align=\"center\">");
		pw.println("<tr>");
		pw.println("<td>");
		pw.println("<fieldset><legend><strong>Registration</strong></legend>");		
		pw.println("<form method=\"post\">");
		pw.println("<table align=\"center\">");
		pw.println("<tr><td>ID</td><td><input type=\"text\" readonly=true name=\"id\" value="+id+" required autofocus=\"autofocus\"></td></tr>");
		pw.println("<tr><td>Name</td><td><input type=\"text\" name=\"name\" required autofocus=autofocus></td></tr><br>"); 
		pw.println("<tr><td>Father's Name</td><td><input type=\"text\" required name=\"fname\"></td></tr>");
		pw.println("<tr><td>Mobile No.</td><td><input type=\"text\" required name=\"mobile\"></td></tr>");
		pw.println("<tr><td>Email</td><td><input type=\"email\" required name=\"email\"></td></tr>");
		pw.println("<tr><td>Username</td><td><input type=\"text\" required name=\"uname\"></td></tr>");
		pw.println("<tr><td>Password</td><td><input type=\"text\" required name=\"pass\"></td></tr>");
		pw.println("<tr><td colspan=\"2\" align=\"center\"><input type=\"submit\" name=\"submit\" value=\"Register\"><input type=\"reset\" name=\"reset\" value=\"Reset\"></td></tr>");
		pw.println("</table></form>");
		pw.println("</fieldset>");
		pw.println("</td>");
		pw.println("</tr>");
		pw.println("</table>");
		pw.println("</section>");
		
		//footer section

	pw.println("<section id='copyright' class='dark_section' style='margin-top:90px'><div class='container'><div class='row'><div class='col-sm-12'><p class='text-center'>&copy; Copyright 2015. CleverCourse Inc.</p></div></div></div></section>");

		
		  pw.println("</body>");
		  pw.println("</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		PrintWriter pw=response.getWriter();
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

	 pw.println("<body align=center ><div id='top'></div>");
	 pw.println("<section id='header' class='bg-color0'><div class='container'><div class='row'><a class='navbar-brand' href='#top'><img src='../images/yourlogo.png' alt=''> CleverCourse</a>");
	 
	 pw.println("<div class='col-sm-12 mainmenu_wrap'><div class='main-menu-icon visible-xs'><span></span><span></span><span></span></div>");
     pw.println("<ul id='mainmenu' class='nav menu sf-menu responsive-menu superfish'>");
          
	 pw.println("<li class=''><a href='../index.html'>Home</a></li>");
	 pw.println("<li class=''><a href='../Login.html'>Login</a></li>");
     pw.println("<li class=''><a href='Courses'>Courses</a></li>");
	 pw.println("<li class=''> <a href='About'>About</a></li>");
     pw.println("<li class=''><a href='Contact'>Contact</a></li>");
	// pw.println("<li class=''>Username : "+s1+"&nbsp;&nbsp;</li>");
	// pw.println("<li class=''>Password : "+s2+"</li>");
      
     pw.println(" </ul></div></div></div></section>");
	   
	 pw.println("<section id='features' class='question_section'>");
		pw.println("<p>&nbsp;</p>");
		Connection con=DBInfo1.getConnection();
		String id=request.getParameter("id");
		String name=request.getParameter("name");
		String fname=request.getParameter("fname");
		String mobile=request.getParameter("mobile");
		String email=request.getParameter("email");
		String uname=request.getParameter("uname");
		String pass=request.getParameter("pass");
		
		String checkuname="select * from registration where uname=?";
		try
		{
			PreparedStatement ps=con.prepareStatement(checkuname);
			ps.setString(1, uname);
			//ps.setString(2, email);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				flag=1;
				break;
				
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			
		}
		if(flag==0)
		{
			String query="insert into login values(?,?,?,?)";
			String query1="insert into registration values(?,?,?,?,?,?,?)";
			int i=0,j=0;
			
			try
			{
				PreparedStatement ps=con.prepareStatement(query1);
				ps.setInt(1,Integer.parseInt(id));
				ps.setString(2,uname);
				ps.setString(3,name);
				ps.setString(4,fname);
				ps.setString(5,mobile);
				ps.setString(6,email);
				ps.setString(7,"Student");
				j=ps.executeUpdate();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			if(j==1&&flag==0)
			{
				try
				{
					PreparedStatement ps=con.prepareStatement(query);
					ps.setInt(1,Integer.parseInt(id));
					ps.setString(2,uname);
					ps.setString(3,pass);
					ps.setString(4,"Student");
					i=ps.executeUpdate();
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
			pw.println("<center>");
			if(i==1 && j==1 && flag==0)
			{
				pw.println("<b>Registration Successfully done<b>");
			}
			else
			{
				if(flag==1)
				{
					pw.println("<b>Username or Email already exist<b>");
				}
				else
				{
					pw.println("<b>No Record(s) added<b>");
				}
			}
		}
		else
		{
			pw.println("<b>Username or Email already exist<b><br>");
		}
		pw.println("</center>");
		pw.println("<a href='../index.html'><img src=\"../images/loginnow.png\" alt=\"Login Now\" width=\"225\" height=\"61\" border=\"0\"></a>");
		pw.println("<p align=\"center\">	<a href=\"Registration\"><img src=\"../images/registernow.png\" alt=\"Register Now\" width=\"225\" height=\"61\" border=\"0\"></a></p>");
		pw.println("<p>&nbsp;</p>");
		pw.println("</section>");
		
		//footer section

	pw.println("<section id='copyright' class='dark_section' style='margin-top:90px'><div class='container'><div class='row'><div class='col-sm-12'><p class='text-center'>&copy; Copyright 2015. CleverCourse Inc.</p></div></div></div></section>");
	
		pw.println("</body>");
		pw.println("</html>");
	}

}
