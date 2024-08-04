package com.springimplant.course.entity;

public class Order {
	private String name;
	private String category;
	private String duration;
	private long price;
	
	public Order(String name, String category, String duration, long price) {
		super();
		this.name = name;
		this.category = category;
		this.duration = duration;
		this.price = price;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public long getPrice() {
		return price;
	}
	public void setPrice(long price) {
		this.price = price;
	}
	
	
}
