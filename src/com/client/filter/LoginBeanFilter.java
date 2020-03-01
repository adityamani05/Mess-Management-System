package com.client.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import com.client.bean.Client;


@WebFilter("/Project_1/Register")
public class LoginBeanFilter implements Filter {

    Client cl1;
    public LoginBeanFilter() 
    {
        
    }

	
	public void destroy() 
	{
		
	}

	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException
	{
		String username = request.getParameter("username");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String mobileno = request.getParameter("mobileno");
		String address = request.getParameter("address");
		String landmark = request.getParameter("landmark");
		String city = request.getParameter("city");
		
		cl1 = new Client(username, email, password, mobileno, address, landmark, city);
		
		request.setAttribute("RegisterObj", cl1);
		
		chain.doFilter(request, response);
	}

	
	public void init(FilterConfig fConfig) throws ServletException 
	{
		
	}

}
