package com.hostmdy.model;

import java.time.LocalDate;

public class Cars {
	private Integer id;
	private LocalDate date;
	private String car;
	private String engine;
	private Integer model;
	private String trim;
	private String color;
	private String price;
	private Boolean remark;
	public Cars(LocalDate date, String car, String engine, Integer model, String trim, String color, String price,
			Boolean remark) {
		super();
		this.date = date;
		this.car = car;
		this.engine = engine;
		this.model = model;
		this.trim = trim;
		this.color = color;
		this.price = price;
		this.remark = remark;
	}
	public Cars(Integer id, LocalDate date, String car, String engine, Integer model, String trim, String color,
			String price, Boolean remark) {
		super();
		this.id = id;
		this.date = date;
		this.car = car;
		this.engine = engine;
		this.model = model;
		this.trim = trim;
		this.color = color;
		this.price = price;
		this.remark = remark;
	}
	
	
	public Cars(Integer id, LocalDate date, String car, String engine, Integer model, String trim, String color,
			String price) {
		super();
		this.id = id;
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
	public Boolean getRemark() {
		return remark;
	}
	public void setRemark(Boolean remark) {
		this.remark = remark;
	}
	@Override
	public String toString() {
		return "Cars [id=" + id + ", date=" + date + ", car=" + car + ", engine=" + engine + ", model=" + model
				+ ", trim=" + trim + ", color=" + color + ", price=" + price + ", remark=" + remark + "]";
	}

	
	
	
	
	
	
}
