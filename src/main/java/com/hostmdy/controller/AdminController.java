package com.hostmdy.controller;

import jakarta.annotation.Resource;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import javax.sql.DataSource;

import com.hostmdy.model.User;
import com.hostmdy.model.UserDAO;

/**
 * Servlet implementation class AdminController
 */
public class AdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Resource(name = "jdbc/cars")
	private DataSource dataSource;
	private UserDAO userDAO;

	@Override
	public void init() throws ServletException {
		userDAO = new UserDAO(dataSource);
	}
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String mode = request.getParameter("mode");
		if(mode == null) {
			mode = "PAGE";
		}
		switch (mode) {
		case "PAGE":
			loadPage(request,response);
			break;
		case "CREATE":
			createUser(request,response);
			break;
		default:
			loadPage(request,response);
			break;
		}
	}
	private void createUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		
		String username = request.getParameter("username");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		Boolean rawRole = Boolean.parseBoolean(request.getParameter("role"));
		
		String role = rawRole?"admin" : "user";
		
		User user = new User(username, email, password, role);
		
		int rowUpdated = userDAO.createUser(user);
		if(rowUpdated >0)
			loadPage(request, response);
		else {
			out.print("Fail to create user!");
		}
		
	}
	private void loadPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher dispacture = request.getRequestDispatcher("admin-signup.jsp");
		dispacture.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
