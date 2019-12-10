package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SessionHitCount_Servlet
 */
@WebServlet("/SessionHitCount_Servlet")
public class SessionHitCount_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public SessionHitCount_Servlet() {
        super();
    }

    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		HttpSession session = request.getSession(true);
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		Integer count = new Integer(0);
		String head;
		if(session.isNew())
		{
			head = "This is the New Session";
		}
		else
		{
			head = "This is the Old Session";
			Integer oldCount = (Integer) session.getAttribute("count");
			if(oldCount != null)
			{
				count = new Integer(oldCount.intValue() + 1);
			}
		}
		session.setAttribute("count", count);
		StringBuffer buffer = new StringBuffer();
		buffer.append("<!DOCTYPE html><html><head><title></title></head><body>");
		buffer.append("<h2> align = 'center'>"+head+"</h2>\n");
		buffer.append("<table border=1 align='center'>\n");
		buffer.append("<tr><th>Information Type</th><th>Session Count</th></tr>\n");
		buffer.append("<tr><td>Total Session Accesses</td><td>"+count+"</td><tr>\n");
		
		buffer.append("<tr><td>Session Id</td><td>"+session.getId()+"</td></tr>\n");
		buffer.append("<tr><td>Session Creation Time</td><td>"+new Date(session.getCreationTime())+"</td></tr>\n");
		buffer.append("<tr><td>Session Last Accessed Time</td><td>"+new Date(session.getLastAccessedTime())+"</td></tr>\n");
		
		buffer.append("</table></body></html>");
		out.println(buffer.toString());
		out.flush();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
