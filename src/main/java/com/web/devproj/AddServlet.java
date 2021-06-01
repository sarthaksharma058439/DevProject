package com.web.devproj;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
public class AddServlet extends HttpServlet
{

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException
	  {
		PrintWriter out = res.getWriter();
		res.setContentType("text/html");
		  double result = 0;
		  String i = req.getParameter("source");
		  String j = req.getParameter("dest");
	      double val = Double.parseDouble(req.getParameter("amount"));
		 if(i.equals("Dollar"))
		 {
			 if(j.equals("Dollar"))
				 result = val;
			 if(j.equals("Rupee"))
				 result = 75 * val;
			 else if(j.equals("Euro"))
				 result = 0.82 * val;
			 else if(j.equals("Dinar"))
				 result = 0.30 * val;
		 }
		  else if(i.equals("Rupee"))
		 {
			 if(j.equals("Dollar"))
				 result = val/75;
			 if(j.equals("Rupee"))
				 result = val;
			 else if(j.equals("Euro"))
				 result = 0.011 * val;
			 else if(j.equals("Dinar"))
				 result = 0.0041 * val;		 
		 }
		 else if(i.equals("Dinar"))
		 {
			 if(j.equals("Dollar"))
				 result = 3.32*val;
			 if(j.equals("Rupee"))
				 result = 241.80*val;
			 else if(j.equals("Euro"))
				 result = 2.72 * val;
			 else if(j.equals("Dinar"))
				 result =  val;		 
		 }
		 else if(i.equals("Euro"))
		 {
			 if(j.equals("Dollar"))
				 result = 1.22*val;
			 if(j.equals("Rupee"))
				 result = 88.95*val;
			 else if(j.equals("Euro"))
				 result =  val;
			 else if(j.equals("Dinar"))
				 result = 0.37 * val;		 
		 }
		 
			 /*out.println("<!DOCTYPE html>\r\n"
			 		+ "<html>\r\n"
			 		+ "<head>\r\n"
			 		+ "<style>\r\n"
			 		+ "body {\r\n"
			 		+ "  background-color: #1b1b2c;\r\n"
			 		+ "}\r\n"
			 		+ "</style>\r\n"
			 		+ "</head>\r\n"
			 		+ "<body>\r\n"
			 		+ "\r\n"
			 		+ "<h1 style=\"text-align:center;color:#FFF;\">Prasad your Result in your currency is: </h1>"
			 		+ "<h1 style=\\\"text-align:center;color:#FFF;\\\">"
			 		+ result
			 		+ "</h1>"
			 		+ "\r\n"
			 		+ "</body>\r\n"
			 		+ "</html>\r\n");
	*/
		 
		  //Cookie cookie =new Cookie("k", k+"");
		 // res.addCookie(cookie);
		 RequestDispatcher dispatcher = req.getRequestDispatcher("output.jsp");
		 req.setAttribute("result", result); // set your String value in the attribute
		 dispatcher.forward( req, res );
		  
	  }
	}