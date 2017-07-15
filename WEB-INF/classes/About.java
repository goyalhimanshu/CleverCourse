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


public class About extends HttpServlet 
{
	String usertype="";
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
	
	
		HttpSession usertypesession=request.getSession();		
		usertype=(String)(usertypesession.getAttribute("usertype"));
		
		// TODO Auto-generated method stub
		PrintWriter pw=response.getWriter();
		HttpSession unamesession=request.getSession();
		String uname=(String)(unamesession.getAttribute("uname"));
		System.out.println("Result uname="+uname);
		pw.println("<!DOCTYPE html>");
		pw.println("<html xmlns=\"http://www.w3.org/1999/xhtml\">");
		pw.println("<head>");
		pw.println("<meta http-equiv=\"Content-Type\" content=\"text/html\"; charset=\"iso-8859-1\" />");
		pw.println("<title></title>");
		//use single quotes instead of double quotes for simplicity
		pw.println("<link rel='stylesheet' href='../css/bootstrap.css'><link rel='stylesheet' href='../css/animations.css'><link rel='stylesheet' href='../css/main.css'>");
		pw.println("<script src='../js/vendor/modernizr-2.6.2.min.js'></script>");
        pw.println("</head>");
		pw.println("<body><div id='top'></div>");
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
		}
		else if(usertype.equalsIgnoreCase("student"))
		{
			pw.println("<li class=''><a href='Student'>Home</a></li>");
		}
		else
		{
			pw.println("<li class=''><a href='../index.html'>Home</a></li>");
		}
		pw.println("<li class=''><a href='Courses'>Courses</a></li>");
		pw.println("<li class=''> <a href='About'>About</a></li>");
		pw.println("<li class=''><a href='Contact'>Contact</a></li>");
		pw.println(" </ul></div></div></div></section>");
		pw.println("<section id='features' class='question_section'>");	
		pw.println("<p>&nbsp;</p>");
		pw.println("<center><h3>THIS PAGE IS UNDER CONSTRUCTION</h3></center>");	
		pw.println("</section>");
		//footer section
		pw.println("<section id='copyright' class='dark_section' style='margin-top:90px'><div class='container'><div class='row'><div class='col-sm-12'><p class='text-center'>&copy; Copyright 2015. CleverCourse Inc.</p></div></div></div></section>");
		pw.println("</body></html>");	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
    }
}