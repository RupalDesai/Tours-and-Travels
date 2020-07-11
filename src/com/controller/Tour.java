package com.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.beans.Country;
import com.model.Account;


public class Tour extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Account account;
	ArrayList<Country> list;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action=request.getParameter("action");
		if(action.equals("country")){
			String location = request.getParameter("location");
			//call Model class
			//pass location and get country in ArrayList
			//set list as attribute and pass on to jsp file
			//in jsp, iterate through dat list generate radio boxes to be displayed on index.jsp
			account = new Account();
			list = new ArrayList<Country>();
			try {
				list = account.getDestination(location);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.setAttribute("list",list);
			request.getRequestDispatcher("jsps/main/country.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
