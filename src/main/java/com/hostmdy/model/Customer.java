package com.hostmdy.model;

import java.time.LocalDate;

public class Customer {
	private Integer id;
	private String name;
	private String phone;
	private LocalDate date;
	private String car;
	private String engine;
	private Integer model;
	private String trim;
	private String color;
	private String price;
	public Customer(String name, String phone, LocalDate date, String car, String engine, Integer model, String trim,
			String color, String price) {
		super();
		this.name = name;
		this.phone = phone;
		this.date = date;
		this.car = car;
		this.engine = engine;
		this.model = model;
		this.trim = trim;
		this.color = color;
		this.price = price;
	}
	public Customer(Integer id, String name, String phone, LocalDate date, String car, String engine, Integer model,
			String trim, String color, String price) {
		super();
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.date = date;
		this.car = car;
		this.engine = engine;
		this.model = model;
		this.trim = trim;
		this.color = color;
		this.price = price;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public String getCar() {
		return car;
	}
	public void setCar(String car) {
		this.car = car;
	}
	public String getEngine() {
		return engine;
	}
	public void setEngine(String engine) {
		this.engine = engine;
	}
	public Integer getModel() {
		return model;
	}
	public void setModel(Integer model) {
		this.model = model;
	}
	public String getTrim() {
		return trim;
	}
	public void setTrim(String trim) {
		this.trim = trim;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", phone=" + phone + ", date=" + date + ", car=" + car
				+ ", engine=" + engine + ", model=" + model + ", trim=" + trim + ", color=" + color + ", price=" + price
				+ "]";
	}

	
	
	
}
