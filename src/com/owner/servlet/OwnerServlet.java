package com.owner.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.owner.bean.MessDetails;
import com.owner.bean.OwnerLogin;
import com.owner.bean.OwnerRegister;
import com.owner.bean.ThaliDetail;
import com.owner.service.AppServices;
import com.owner.service.OwnerServices;
import com.owner.serviceObjectProvider.AppServiceObjectProvider;
import com.owner.serviceObjectProvider.OwnerServiceObjectProvider;

public class OwnerServlet extends HttpServlet {
	
	//instance variables
	AppServices appService;
	OwnerServices ownerService;
	Connection con;
	RequestDispatcher rd;
	HttpSession session;
	ArrayList ownerDetailList;
	ResultSet messDetailList=null;
	OwnerLogin loginOwner;
	OwnerRegister registerOwner;
	MessDetails messDetail;
	ThaliDetail thaliDetail;
	public void init(){
		con = (Connection) getServletConfig().getServletContext().getAttribute("dbcon");
		appService = AppServiceObjectProvider.getAppServiceObject();
		ownerService = OwnerServiceObjectProvider.getOwnerServiceObject();
		appService.setConnection(con);
		ownerService.setConnection(con);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		
		// owner login
		if(request.getRequestURI().equals("/Project_1/ownerlog")){      
			
			int ownerId = Integer.parseInt(request.getParameter("ownerId"));
			String ownerPassword = request.getParameter("ownerPassword");
			loginOwner = new OwnerLogin(ownerId,ownerPassword);
				try {
					if(appService.validateOwner(loginOwner)){ //Validating owner
						session = request.getSession(true);
						System.out.println(session.getId());
						
						messDetailList = appService.fetchOwnerMessDetail();  //result set
						ownerDetailList = appService.fetchOwnerDetail(ownerId); //array list
						
						session.setAttribute("messDetailList", messDetailList);
						session.setAttribute("ownerDetailList", ownerDetailList);
						session.setAttribute("ownerId", ownerId);
						
						session.getAttribute("messDetailList");
						
						rd = request.getRequestDispatcher("ownerHome.jsp");
						rd.forward(request, response);
						
					}
					else{
						rd = request.getRequestDispatcher("ownerLogin.html");
						rd.include(request, response);
						out.println("<h1 style='color:white' >Invalid Credentials!!!</h1>");
					}
				} catch (SQLException e) {e.printStackTrace();}
			
		}
		
		//owner register
		
		if(request.getRequestURI().equals("/Project_1/ownerreg")){
			String ownerName = request.getParameter("ownerName");
			String ownerPassword = request.getParameter("ownerPassword");
			String ownerPhoneNo = request.getParameter("ownerPhoneNo");
			
			registerOwner = new OwnerRegister(ownerName,ownerPassword,ownerPhoneNo);
			try {
				if(appService.validateOwnerReg(registerOwner)){
					rd = request.getRequestDispatcher("ownerLogin.html");
					rd.include(request, response);
					out.println("<h1 style='color:white' >Aready Have An Account</h1>");
				}
				else{
					int ownerId = ownerService.ownerRegister(registerOwner);
					
					rd = request.getRequestDispatcher("ownerLogin.html");
					rd.include(request, response);
					out.println("<h1 style='color:white' >Registeration Sucessfull!!!!</h1>");
					out.println("<h1 style='color:white' >Owner Id :</h1>" + "<h1 style='color:white'>"+ ownerId+"</h1>");
				}
			} catch (SQLException e) {e.printStackTrace();}
			
		}
		
		// Adding Mess Detail
		if(request.getRequestURI().equals("/Project_1/messdetail")){
			String messName = request.getParameter("messName");
			String messPhoneNo = request.getParameter("messPhoneNo");
			String messLocation = request.getParameter("messLocation");
			session = request.getSession(false);
			int ownerId = (int) session.getAttribute("ownerId");
			messDetail = new MessDetails(ownerId,messName,messPhoneNo,messLocation);
			int messId = ownerService.addMessDetail(messDetail);
			rd = request.getRequestDispatcher("ownerLogin.html");
			rd.include(request, response);
			out.println("<h1 style='color:white'> Successfully Added Plz Login</h1>");
		}
		
		//Getting Mess Detail
		if(request.getRequestURI().equals("/Project_1/getmessdetail")){
			session = request.getSession(false);
			int messId = Integer.parseInt(request.getParameter("mess"));
			session.setAttribute("messId", messId);
			ArrayList detailOfMess = appService.fetchDetailOfMess(messId);
			session.setAttribute("detailOfMess", detailOfMess);
			rd = request.getRequestDispatcher("Messhome.jsp");
			rd.forward(request, response);
			
		}
		
		//Adding Thali detail
		if(request.getRequestURI().equals("/Project_1/addthali")){
			session = request.getSession(false);
			int messId = (Integer)(session.getAttribute("messId"));
			String thaliName = request.getParameter("thaliName");
			String thaliDes = request.getParameter("thaliDes");
			int thaliPrice = Integer.parseInt(request.getParameter("thaliPrice"));
			thaliDetail = new ThaliDetail(messId,thaliName,thaliDes,thaliPrice);
			ownerService.addThali(thaliDetail);
			rd = request.getRequestDispatcher("Messhome.jsp");
			rd.include(request, response);
		}
		
		//Get All Mess
		if(request.getRequestURI().equals("/Project_1/getallmess")) {
			session = request.getSession(false);
			ResultSet allMess = appService.fetchAllMess();
			session.setAttribute("allMess", allMess);
			//out.println(allMess);
			rd = request.getRequestDispatcher("ClientHome.jsp");
			rd.forward(request, response);
		}
		//Get thali
		if(request.getRequestURI().equals("/Project_1/getallthali")) {
			session = request.getSession(false);
			int messId = Integer.parseInt(request.getParameter("mess"));
			//System.out.println(messId);
			ResultSet allthali = appService.extractAllThali(messId);
			session.setAttribute("allthali", allthali);
			//out.println(allMess);
			rd = request.getRequestDispatcher("thaliDetail.jsp");
			rd.forward(request, response);
		}
		
	}

}
