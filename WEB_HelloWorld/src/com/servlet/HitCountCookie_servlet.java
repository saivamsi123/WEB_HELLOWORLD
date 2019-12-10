package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HitCountCookie_servlet
 */
@WebServlet("/HitCountCookie_servlet")
public class HitCountCookie_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static int i = 1;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HitCountCookie_servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		String k = String.valueOf(i);
		Cookie c = new Cookie("visit",k);
		response.addCookie(c);
		int j = Integer.parseInt(c.getValue());
		if(i==1)
		{
			pw.println("Welcome");
		}
		else
		{
			pw.println("You visited "+ i +" times ");
		}
		i++;
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
