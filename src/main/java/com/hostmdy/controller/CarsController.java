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
 * Servlet implementation class CarsController
 */
public class CarsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Resource(name = "jdbc/cars")
	private DataSource dataSource;
	private CarsDAO carsDAO;


	
	@Override
	public void init() throws ServletException {
		carsDAO = new CarsDAO(dataSource);
		
	}
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CarsController() {
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
		case "CREATE":
			createCar(request, response);
			break;
		case "LOAD":
			loadCarsList(request, response);
			break;
		case "UPDATE":
			updateCarsList(request, response);
			break;
		case "DELETE":
			deleteCars(request, response);
			break;
		case "PAGE":
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
	
	protected void createCar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		Integer id = Integer.parseInt(request.getParameter("id"));
		LocalDate date = LocalDate.parse( request.getParameter("date"));
		String car = request.getParameter("car");
		String engine = request.getParameter("engine");
		Integer model = Integer.parseInt(request.getParameter("model"));
		String trim = request.getParameter("trim");
		String color = request.getParameter("color");
		String price = request.getParameter("price");
		Boolean remark =Boolean.parseBoolean( request.getParameter("remark"));
		Cars cars = new Cars(id, date, car, engine, model, trim, color, price,remark);
		int rowUpdated = carsDAO.createCar(cars);
		
		if(rowUpdated > 0) {
			showCarsList(request, response);		
			}else {
				out.print("Fail To Add!");
			}
	}
	
	protected void loadCarsList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Integer id = Integer.parseInt(request.getParameter("id"));
		Cars cars = carsDAO.getCarById(id);
		request.setAttribute("cars",cars);
		
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		request.setAttribute("user", user);
		
		RequestDispatcher dispatch = request.getRequestDispatcher("cars-update.jsp");
		dispatch.forward(request, response);
	}
	
	protected void updateCarsList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		Integer id = Integer.parseInt(request.getParameter("id"));
		LocalDate date = LocalDate.parse( request.getParameter("date"));
		String car = request.getParameter("car");
		String engine = request.getParameter("engine");
		Integer model = Integer.parseInt(request.getParameter("model"));
		String trim = request.getParameter("trim");
		String color = request.getParameter("color");
		String price = request.getParameter("price");
		Boolean remark =Boolean.parseBoolean( request.getParameter("remark"));
		Cars cars = new Cars(id, date, car, engine, model, trim, color, price, remark);
		int rowUpdated = carsDAO.updatedCarsList(cars);
		
		if(rowUpdated > 0) {
			showCarsList(request, response);		
			}else {
				out.print("Fail To Update!");
			}
	}
	
	protected void deleteCars(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		Integer id = Integer.parseInt(request.getParameter("id"));
        int rowUpdated = carsDAO.deleteCar(id);
		
		if(rowUpdated > 0) {
			showCarsList(request, response);		
			}else {
				out.print("Fail To Delete!");
			}
	}	
	protected void loadPage(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		request.setAttribute("user", user);
		RequestDispatcher dispacture =request.getRequestDispatcher("cars-register.jsp");
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
