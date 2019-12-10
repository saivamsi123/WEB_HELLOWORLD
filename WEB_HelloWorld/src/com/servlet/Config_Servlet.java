package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Config_Servlet
 */
@WebServlet(
		urlPatterns = { "/Config_Servlet" }, 
		initParams = { 
				@WebInitParam(name = "db.driver", value = "com.mysql.cj.jdbc.Driver"), 
				@WebInitParam(name = "db.url", value = "jdbc:mysql://localhost:3306/Allianz"), 
				@WebInitParam(name = "db.username", value = "root"), 
				@WebInitParam(name = "db.password", value = "")
		})
public class Config_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private String driver, url, username, password = null;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Config_Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    @Override
    public void init(ServletConfig config) throws ServletException {
    	super.init(config);
    	System.out.println("Config_servlet->init......");
    	driver = config.getInitParameter("db.driver");
    	url = config.getInitParameter("db.url");
    	username = config.getInitParameter("db.username");
    	password = config.getInitParameter("db.password");
    	System.out.println(driver+"\t"+url+"\t"+username+"\t"+password);
    	
    	Properties properties = new Properties();
    	properties.put("db.driver",driver);
    	properties.put("db.url",url);
    	properties.put("db.username",username);
    	properties.put("db.password",password);
    	properties.list(System.out);
    	
    	ServletContext context = getServletContext();
    	context.setAttribute("dbProperties", properties);
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println("Config_servlet->doGet....");
		RequestDispatcher dispatcher = request.getRequestDispatcher("Context_Servlet");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
