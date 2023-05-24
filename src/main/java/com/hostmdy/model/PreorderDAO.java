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

import javax.sql.DataSource;

public class PreorderDAO {
	
	private DataSource dataSource;
	private Connection connection;
	private Statement stmt;
	private PreparedStatement pStmt;
	private ResultSet rs;
	
	public PreorderDAO(DataSource dataSource) {
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
	public int preorderCar(Preorder cars) {
		int rowUpdated = 0;
		
		try {
			connection = dataSource.getConnection();
			pStmt = connection.prepareStatement("INSERT INTO `preorder` "
					+ "(`name`,`phone`,`date`, `car`, `engine`, `model`, `trim`,`color`, `deposit`) "
					+ "VALUES ( ?, ?, ?, ?, ?,?,?,?,?);"
					);
			
			
			pStmt.setString(1, cars.getName());
			pStmt.setString(2, cars.getPhone());
			Date date = Date.valueOf(cars.getDate());
			pStmt.setDate(3, date);
			pStmt.setString(4, cars.getCar());
			pStmt.setString(5, cars.getEngine());
			pStmt.setInt(6, cars.getModel());
			pStmt.setString(7, cars.getTrim());
			pStmt.setString(8, cars.getColor() );
			pStmt.setString(9, cars.getDeposit());
			
			rowUpdated = pStmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}
		return rowUpdated;
	}

	public List<Preorder> showPreorderCars(){
		List<Preorder> preorderList = new ArrayList<>();
		try {
			connection = dataSource.getConnection();
			stmt = connection.createStatement();
			rs = stmt.executeQuery("select * from preorder;");
			
			while(rs.next()) {
				preorderList.add(new Preorder(
						rs.getInt("id"),
						rs.getString("name"),
						rs.getString("phone"),
						LocalDate.parse(rs.getDate("date").toString()),
						rs.getString("car"), 
						rs.getString("engine"), 
						rs.getInt("model"), 
						rs.getString("trim"),
						rs.getString("color"),
						rs.getString("deposit")));
				
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}
		return preorderList;
		
	}
	
}
