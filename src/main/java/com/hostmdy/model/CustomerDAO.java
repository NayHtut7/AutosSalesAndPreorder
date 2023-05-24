package com.hostmdy.model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.sql.DataSource;

public class CustomerDAO {
	
	private DataSource dataSource;
	private Connection connection;
	private Statement stmt;
	private PreparedStatement pStmt;
	private ResultSet rs;
	
	public CustomerDAO(DataSource dataSource) {
		super();
		this.dataSource = dataSource;
	}
	
	private void close() {
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Cars getCarById(Integer id) {
		Cars cars = null;
		try {
			connection = dataSource.getConnection();
	stmt = connection.createStatement();
			
			rs = stmt.executeQuery("select * from cars where id = '"+id+"';");
			
			while(rs.next()) {
				cars = new Cars(
						rs.getInt("id"), 
						LocalDate.parse(rs.getDate("date").toString()),
						rs.getString("car"),
						rs.getString("engine"),
						rs.getInt("model"), 
						rs.getString("trim"),
						rs.getString("color"),
						rs.getString("price")
						);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}
		return cars;
	}
	public int addCar(Customer cars) {
		int rowUpdated = 0;
		
		try {
			connection = dataSource.getConnection();
			stmt = connection.createStatement();
			pStmt = connection.prepareStatement("INSERT INTO `record` "
					+ "(`id`,`name`,`phone`,`date`, `car`, `engine`, `model`, `trim`,`color`, `price`) "
					+ "VALUES (?, ?, ?, ?, ?, ?,?,?,?,?);"
					);
			
			pStmt.setInt(1, cars.getId());
			pStmt.setString(2, cars.getName());
			pStmt.setString(3, cars.getPhone());
			Date date = Date.valueOf(cars.getDate());
			pStmt.setDate(4, date);
			pStmt.setString(5, cars.getCar());
			pStmt.setString(6, cars.getEngine());
			pStmt.setInt(7, cars.getModel());
			pStmt.setString(8, cars.getTrim());
			pStmt.setString(9, cars.getColor() );
			pStmt.setString(10, cars.getPrice());
			
			rowUpdated = pStmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}
		return rowUpdated;
	}
	public List<Customer> showReservedCars(){
		List<Customer> reservedList = new ArrayList<>();
		try {
			connection = dataSource.getConnection();
			stmt = connection.createStatement();
			rs = stmt.executeQuery("select * from record;");
			
			while(rs.next()) {
				reservedList.add(new Customer(
						rs.getInt("id"),
						rs.getString("name"),
						rs.getString("phone"),
						LocalDate.parse(rs.getDate("date").toString()),
						rs.getString("car"), 
						rs.getString("engine"), 
						rs.getInt("model"), 
						rs.getString("trim"),
						rs.getString("color"),
						rs.getString("price")));
				
}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}
		return reservedList;
		
	}
	

	public Customer receiveCarById(Integer id) {
		Customer cars = null;
		try {
			connection = dataSource.getConnection();
	stmt = connection.createStatement();
			
			rs = stmt.executeQuery("select * from record where id = '"+id+"';");
			
			while(rs.next()) {
				cars = new Customer(
						rs.getInt("id"), 
						rs.getString("name"),
						rs.getString("phone"),
						LocalDate.parse(rs.getDate("date").toString()),
						rs.getString("car"),
						rs.getString("engine"),
						rs.getInt("model"), 
						rs.getString("trim"),
						rs.getString("color"),
						rs.getString("price")
						);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}
		return cars;
	}
	public int deleteCar(Integer id) {
		int rowUpdated = 0;
		try {
			connection = dataSource.getConnection();
			pStmt = connection.prepareStatement("delete from record where id=?;");
			pStmt.setInt(1,id);
			rowUpdated = pStmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}
		return rowUpdated;
	}

	
			
		
	
		
		
}

