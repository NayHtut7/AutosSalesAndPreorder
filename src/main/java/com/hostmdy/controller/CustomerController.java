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
import java.util.Optional;

import javax.sql.DataSource;

import com.hostmdy.model.Cars;
import com.hostmdy.model.CarsDAO;
import com.hostmdy.model.Customer;
import com.hostmdy.model.CustomerDAO;
import com.hostmdy.model.Preorder;
import com.hostmdy.model.User;

/**
 * Servlet implementation class CustomerController
 */
public class CustomerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	@Resource(name = "jdbc/cars")
	private DataSource dataSource;
	private CarsDAO carsDAO;
	private CustomerDAO customerDAO;
	
	@Override
	public void init() throws ServletException {
		carsDAO = new CarsDAO(dataSource);
		customerDAO = new CustomerDAO(dataSource);
	}
		
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerController() {
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
		case "LOAD":
			loadCarsList(request, response);
			break;
		case "BUY":
			buyCars(request, response);
			break;
		case "SHOW":
			showReservedList(request, response);
			break;
		case "CLEAR":
			deleteCars(request, response);
			break;
		
		default:
			showCarsList(request, response);
			break;

		}
		
		}
		else {
			response.sendRedirect("cars");
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
	
     protected void loadCarsList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	 PrintWriter out = response.getWriter();
		Integer id = Integer.parseInt(request.getParameter("id"));
		Cars cars = carsDAO.getCarById(id);
		request.setAttribute("cars",cars);
		
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		request.setAttribute("user", user);
		
		RequestDispatcher dispatch = request.getRequestDispatcher("cars-record.jsp");
		dispatch.forward(request, response);
		
	}
     protected void buyCars(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 		PrintWriter out = response.getWriter();
 		
 		Integer id = Integer.parseInt(request.getParameter("id"));
 		String name = request.getParameter("name");
 		String phone = request.getParameter("phone");
 		
 		LocalDate date = LocalDate.parse( request.getParameter("date"));
 		String car = request.getParameter("car");
 		String engine = request.getParameter("engine");
 		Integer model = Integer.parseInt(request.getParameter("model"));
 		String trim = request.getParameter("trim");
 		String color = request.getParameter("color");
 		String price = request.getParameter("price");
 		
 		Customer cars = new Customer(id, name, phone, date, car, engine, model, trim, color, price);
 		int rowUpdated = customerDAO.addCar(cars);
 		
 		if(rowUpdated > 0) {
 			response.sendRedirect("cars");
 			}else {
 				out.print("Fail To Add!");
 			}
 	}
     
     protected void showReservedList(HttpServletRequest request, HttpServletResponse response)
 			throws ServletException, IOException {

 		List<Customer> reservedList = customerDAO.showReservedCars();

 		request.setAttribute("reservedList",reservedList);
 		
 		
 		HttpSession session = request.getSession();
 		User user = (User) session.getAttribute("user");
 		request.setAttribute("user", user);

 		RequestDispatcher dispatch = request.getRequestDispatcher("reserved.jsp");

 		dispatch.forward(request, response);
 	}
     protected void receivedCarsList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 		
 		Integer id = Integer.parseInt(request.getParameter("id"));
 		Customer cars = customerDAO.receiveCarById(id);
 		request.setAttribute("cars",cars);
 		
 		HttpSession session = request.getSession();
 		User user = (User) session.getAttribute("user");
 		request.setAttribute("user", user);
 		
 		RequestDispatcher dispatch = request.getRequestDispatcher("cars-record.jsp");
 		dispatch.forward(request, response);
 	}
     protected void deleteCars(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 		PrintWriter out = response.getWriter();
 		Integer id = Integer.parseInt(request.getParameter("id"));
         int rowUpdated = customerDAO.deleteCar(id);
 		
 		if(rowUpdated > 0) {
 			showReservedList(request, response);		
 			}else {
 				out.print("Fail To Delete!");
 			}
 	}	


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
