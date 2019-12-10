package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HitCountSession_Servlet
 */
@WebServlet("/HitCountSession_Servlet")
public class HitCountSession_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private int counter;
    
    
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HitCountSession_Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    
    @Override
    public void init() throws ServletException {
    	counter = 0;
    	super.init();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int counterVar = 0;
		synchronized (this) {
			counterVar = ++counter;
		}
		System.out.println("HitCount_Servlet->doGet........");
		String html = "<html><head><title>HitCount_Servlet</title></head>";
		html += "<body><h1>HitCount_Servlet......</h1></body>";
		html += "Counter: "+counterVar+"<body><h1>Visited these many times......</h1></body>";
		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.getWriter().append(html);
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
