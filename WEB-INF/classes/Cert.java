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
import java.text.DateFormat;
import java.util.Date;




public class Cert extends HttpServlet {

	String exam="",uname="",date="";	
		int c=0,tq=0;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub			
	}
	
	
	
	//POST==================================================================================================================================================================================

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		// TODO Auto-generated method stub		
		
		
		HttpSession examnamesession=request.getSession();		
		uname=(String)(examnamesession.getAttribute("uname"));
		/*HttpSession examnamesession=request.getSession();		
		exam=(String)(examnamesession.getAttribute("exam"));	
		
		HttpSession correctsession=request.getSession();
		c=Integer.parseInt((examnamesession.getAttribute("c")).toString());
	
		HttpSession totalsession=request.getSession();
     	int tq=Integer.parseInt((totalsession.getAttribute("tq")).toString());
	
		HttpSession datesession=request.getSession();		
		date=(String)(datesession.getAttribute("date"));
		
			*/	
		
		PrintWriter out=response.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("<center><div style=\"width:800px; height:560px; padding:20px; text-align:center; border: 10px solid #787878\">");
		out.println("<div style=\"width:750px; height:510px; padding:20px; text-align:center; border: 5px solid #787878\">");
		out.println("<p><img src=\"../images/yourlogo.png\" width=\"200\" height=\"23\"></p>");
		out.println("<p><span style=\"font-size:50px; font-weight:bold\">Certificate of Completion</span>");
		
		System.out.println("c= "+Double.parseDouble(request.getParameter("correct")));
		System.out.println("tq= "+Double.parseDouble(request.getParameter("tq")));
        out.println("<br>");
        out.println("<br>");
        out.println("<span style=\"font-size:25px\"><i>This is to certify that</i></span>");
        out.println("<br>");
        out.println("<br>");
        out.println("<span style=\"font-size:30px\"><b>"+uname.toUpperCase()+"</b></span><br/>");
        out.println("<br/>");
        out.println("<span style=\"font-size:25px\"><i>has completed the exam</i></span> <br/>");
        out.println("<br/>");
        out.println("<span style=\"font-size:30px\">"+(request.getParameter("exam")).toUpperCase()+"</span> <br/>");
        out.println("<br/>");
        out.println("<span style=\"font-size:20px\">with score of <b>"+((Double.parseDouble(request.getParameter("correct")))/(Double.parseDouble(request.getParameter("tq"))))*100+"%</b></span> <br/>");
        out.println("<br/>");
        out.println("<br/>");
        out.println("<br/>");
        out.println("<span style=\"font-size:25px\"><i>dated</i></span><br>");
        out.println("<span style=\"font-size:30px\">"+(request.getParameter("date"))+" </span></p>");
    //    out.println("<p><img src=\"../images/certified-stamp.gif\" width=\"182\" height=\"134\"></p>");
		out.println("</div>");
		out.println("</div>");
		out.println("</center>");
		out.println("</body>");
		out.println("</html>");
		
	}

}
