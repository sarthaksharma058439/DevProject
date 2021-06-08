package com.web.devproj.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;
import java.io.*;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.*;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import com.web.devproj.AddServlet;

public class AddServletTest {
	
	@SuppressWarnings("deprecation")
	@Test
	public void testServlet() throws Exception {
		HttpServletRequest request = mock(HttpServletRequest.class);
		HttpServletResponse response=mock(HttpServletResponse.class);
		RequestDispatcher rd= mock(RequestDispatcher.class);
		Comparable c= mock(Comparable.class);
		
	    when(request.getParameter("amount")).thenReturn("90");
		when(request.getParameter("source")).thenReturn("Dollar");
		when(request.getParameter("dest")).thenReturn("Rupee");
		
		when(request.getRequestDispatcher("output.jsp")).thenReturn(rd);
		
		
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);

		when(response.getWriter()).thenReturn(pw);

		new AddServlet().doGet(request,response);
		
		String res = sw.getBuffer().toString().trim();
		verify(rd).forward(request, response);
		
		assertTrue(6750.0==Double.parseDouble(res));
	}

}
