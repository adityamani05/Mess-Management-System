package com.client.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.client.bean.Client;
import com.client.bean.ClientLogin;
import com.client.daoService.DaoInterface;
import com.client.exception.RegistrationFailExceptions;
import com.client.service.AppService;
import com.client.service.ClientService;
import com.client.serviceObjectProvider.AppServiceObjProvider;
import com.client.serviceObjectProvider.ServiceObjProvider;
import com.daoServiceObjectProviderClient.DaoObjectProvider;


public class ClientServlet extends HttpServlet 
{
	Connection con;
	Client c1;
	DaoInterface d1;
	ClientLogin cl1;
	ClientService cs1;
	AppService as1;
	HttpSession session;
	
    public ClientServlet()
    {
    
    }

	public void init() 
	{
		con = (Connection) getServletConfig().getServletContext().getAttribute("dbcon");
		cs1  =  ServiceObjProvider.getServiceObj();
		as1 = AppServiceObjProvider.getServiceobj();
		cs1.setConnection(con);
		as1.setConnection(con);
	}

	
	public void destroy() 
	{
		
	}
	public static void RegistrationFailExceptions(String msg) throws RegistrationFailExceptions
	{
		throw new RegistrationFailExceptions(msg);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  
	{
		PrintWriter out = response.getWriter();
		c1 = (Client) request.getAttribute("RegisterObj");
		String recpage = request.getRequestURI();
		if(recpage.equals("/Project_1/Register"))
		{
			String radioinput = request.getParameter("radioinput");
			if(radioinput.equals("subscribe")) //on subscribe select
			{	
				try {
				int clientid = cs1.addClient(c1);
				out.println("<h1 style='color=white'>Your Client id is : "+clientid+"</h1>");	
				}
				catch(Exception e) 
				{
					try {
						RegistrationFailExceptions("Redistration Failed");
					} catch (com.client.exception.RegistrationFailExceptions e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					//System.out.println("Registration Failed");
				}
				RequestDispatcher rd = request.getRequestDispatcher("messSub.html");
				rd.forward(request, response);
			}
			if(radioinput.equals("tooOrder")) // on tooOrder select
			{
				int clientid = cs1.addClient(c1);
				out.println("<h1 style='color=white'>Your Client id is : "+clientid+"</h1>");
				RequestDispatcher rd = request.getRequestDispatcher("messSub.html");
				rd.forward(request, response);
			}
		}
		if(recpage.equals("/Project_1/Login")) //Login verification
		{
			String userid = request.getParameter("userid");
			String password = request.getParameter("password");
			cl1 = new ClientLogin(userid, password);
			if(cs1.loginClient(cl1))
			{
				session  = request.getSession(true);
				//out.println("<h1 style='color=white'>valid user!</h1>");
				Client clientdetail = as1.getClientdetails(userid);
				session.setAttribute("userid", clientdetail);
				RequestDispatcher rd = request.getRequestDispatcher("/getallmess");
				rd.forward(request, response);
				Client c = (Client) session.getAttribute("userid");
				out.println("Welcome "+c.getUserName());
			}
			else
			{
				RequestDispatcher rd = request.getRequestDispatcher("ClientLogIn.html");
				rd.include(request, response);
				out.println("<h1 style='color=white'>invalid user</h1>");
			}
		}
		
		if(recpage.equals("/Project_1/logout")) {
			session = request.getSession(false);
			session.invalidate();
			RequestDispatcher rd = request.getRequestDispatcher("ClientLogIn.html");
			rd.forward(request, response);
		}
			
	}
	

}
