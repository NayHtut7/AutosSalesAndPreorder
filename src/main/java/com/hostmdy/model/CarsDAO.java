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

public class CarsDAO {
	private DataSource dataSource;
	private Connection connection;
	private Statement stmt;
	private PreparedStatement pStmt;
	private ResultSet rs;
	
	public CarsDAO(DataSource dataSource) {
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
	
	public int createCar(Cars cars) {
		int rowUpdated = 0;
		
		try {
			connection = dataSource.getConnection();
			pStmt = connection.prepareStatement("INSERT INTO `cars` "
					+ "(`id`,`date`, `car`, `engine`, `model`, `trim`,`color`, `price`,`remark`) "
					+ "VALUES (?, ?, ?, ?, ?, ?,?,?,?);"
					);
			
			pStmt.setInt(1, cars.getId());
			Date date = Date.valueOf(cars.getDate());
			pStmt.setDate(2, date);
			pStmt.setString(3, cars.getCar());
			pStmt.setString(4, cars.getEngine());
			pStmt.setInt(5, cars.getModel());
			pStmt.setString(6, cars.getTrim());
			pStmt.setString(7, cars.getColor() );
			pStmt.setString(8, cars.getPrice());
			pStmt.setBoolean(9, cars.getRemark());
			rowUpdated = pStmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}
		return rowUpdated;
	}
	
	public List<Cars> showAllCars(){
		List<Cars> carsList = new ArrayList<>();
		try {
			connection = dataSource.getConnection();
			stmt = connection.createStatement();
			rs = stmt.executeQuery("select * from cars;");
			
			while(rs.next()) {
				carsList.add(new Cars(
						rs.getInt("id"),
						LocalDate.parse(rs.getDate("date").toString()),
						rs.getString("car"), 
						rs.getString("engine"), 
						rs.getInt("model"), 
						rs.getString("trim"),
						rs.getString("color"),
						rs.getString("price"),
						rs.getBoolean("remark")));
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}
		return carsList;
		
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
						rs.getString("price"),
						rs.getBoolean("remark"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}
		return cars;
	}
	
	public int updatedCarsList(Cars cars) {
		int rowUpdated = 0;
		
		try {
			connection = dataSource.getConnection();
			pStmt = connection.prepareStatement("UPDATE `cars` SET" 
					
					+"`date` = ?,"
					+"`car` = ?,"
					+"`engine` = ?," 
					+"`model` = ?," 
					+"`trim` = ?, "
					+"`color` = ?, "
					+"`price` = ?,"
					+"`remark` = ? WHERE (`id` = ?);"

					);
			
			
			Date date = Date.valueOf(cars.getDate());
			pStmt.setDate(1, date);
			pStmt.setString(2, cars.getCar());
			pStmt.setString(3, cars.getEngine());
			pStmt.setInt(4, cars.getModel());
			pStmt.setString(5, cars.getTrim());
			pStmt.setString(6, cars.getColor());
			pStmt.setString(7, cars.getPrice());
			pStmt.setBoolean(8, cars.getRemark());
			pStmt.setInt(9, cars.getId());
			rowUpdated = pStmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}
		return rowUpdated;
	}
	
	public int deleteCar(Integer id) {
		int rowUpdated = 0;
		try {
			connection = dataSource.getConnection();
			pStmt = connection.prepareStatement("delete from cars where id=?;");
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
