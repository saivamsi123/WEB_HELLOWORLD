package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HitCount_Servlet
 */
@WebServlet("/HitCount_Servlet")
public class HitCount_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    int counter; 
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HitCount_Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    @Override
    public void init() throws ServletException {
    	super.init();
    	counter = 0;
    	System.out.println("HitCount_Servlet->init...");
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		counter++;
		System.out.println("HitCount_Servlet->doGet........");
		String html = "<html><head><title>HitCount_Servlet</title></head>";
		html += "<body><h1>HitCount_Servlet......</h1></body>";
		html += "Counter: "+counter+"<body><h1>Visited these many times......</h1></body>";
		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.getWriter().append(html);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("HitCount_Servlet->doPost........");
		doGet(request, response);
	}

}
