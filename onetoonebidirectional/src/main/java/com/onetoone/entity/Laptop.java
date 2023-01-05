package com.onetoone.entity;






import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;



@Entity
@Table(name = "laptops")
public class Laptop  {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int laptopId;
 private String laptopName;
 private String modelNo;

public int getLaptopId() {
	return laptopId;
  }
public void setLaptopId(int laptopId) {
	this.laptopId = laptopId;
}
public String getLaptopName() {
	return laptopName;
}
public void setLaptopName(String laptopName) {
	this.laptopName = laptopName;
}
public String getModelNo() {
	return modelNo;
}
public void setModelNo(String modelNo) {
	this.modelNo = modelNo;
}

public Laptop(int laptopId, String laptopName, String modelNo ) {
	super();
	this.laptopId = laptopId;
	this.laptopName = laptopName;
	this.modelNo = modelNo;
	
}
public Laptop() {
	super();
	// TODO Auto-generated constructor stub
}




}