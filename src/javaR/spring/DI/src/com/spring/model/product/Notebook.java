package com.spring.model.product;

public class Notebook extends Computer{
	String battery;
	
	public Notebook(String name){
		super(name);
	}

	public String getBattery() {
		return battery;
	}

	public void setBattery(String battery) {
		this.battery = battery;
	}
	
	public String getContents(){
		return super.getContents()+"\nbattery : "+battery;
	}
}
