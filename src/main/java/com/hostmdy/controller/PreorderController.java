package com.hostmdy.controller;

import jakarta.annotation.Resource;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.List;

import javax.sql.DataSource;

import com.hostmdy.model.Cars;
import com.hostmdy.model.CarsDAO;
import com.hostmdy.model.Preorder;
import com.hostmdy.model.PreorderDAO;
import com.hostmdy.model.User;

/**
 * Servlet implementation class PreorderController
 */
public class PreorderController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Resource(name = "jdbc/cars")
	private DataSource dataSource;
	private PreorderDAO preorderDAO;
	private CarsDAO carsDAO;
	@Override
	public void init() throws ServletException {
		preorderDAO = new PreorderDAO(dataSource);
		
	}
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PreorderController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sesssion = request.getSession();
		User user = (User) sesssion.getAttribute("user");
		
		if(user != null ) {
		
		
		String mode = request.getParameter("mode");

		if (mode == null) {
			mode = "LIST";
		}
		switch (mode) {
		case "LIST":
			showCarsList(request, response);
			break;
		
		case "PAGE":
			showPreorderList(request, response);
			break;
		
		case "PREORDER":
			createPreorder(request, response);
			break;
		case "LOAD":
			loadPage(request, response);
			break;
		default:
			showCarsList(request, response);
			break;

		}
		
		}
		else {
			response.sendRedirect("login");
		}
	

	}
	protected void showCarsList(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<Cars> carsList = carsDAO.showAllCars();

		request.setAttribute("carsList", carsList);
		
		
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		request.setAttribute("user", user);

		RequestDispatcher dispatch = request.getRequestDispatcher("index.jsp");

		dispatch.forward(request, response);
	}
	
	protected void showPreorderList(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<Preorder> preorderList = preorderDAO.showPreorderCars();

		request.setAttribute("preorderList", preorderList);
		
		
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		request.setAttribute("user", user);

		RequestDispatcher dispatch = request.getRequestDispatcher("preorder.jsp");

		dispatch.forward(request, response);
	}
	
	protected void createPreorder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		String name = request.getParameter("name");
 		String phone = request.getParameter("phone");
 		LocalDate date = LocalDate.parse( request.getParameter("date"));

 		String car = request.getParameter("car");
		String engine = request.getParameter("engine");
		Integer model = Integer.parseInt(request.getParameter("model"));
		String trim = request.getParameter("trim");
		String color = request.getParameter("color");
		String deposit = request.getParameter("deposit");
		
		Preorder cars = new Preorder(name, phone, date, car, engine, model, trim, color, deposit);
		int rowUpdated = preorderDAO.preorderCar(cars);
		
		if(rowUpdated > 0) {
			response.sendRedirect("cars");		
			}else {
				out.print("Fail To Preorder!");
			}
	}
	protected void loadPage(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		request.setAttribute("user", user);
		RequestDispatcher dispacture =request.getRequestDispatcher("preorder-register.jsp");
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
