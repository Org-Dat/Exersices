package java.pojoFile;


import java.util.*;

 public class Employee{ 
private String  name;
private String  company;
private List<Object>  phone_number;
private Object  salary;
private boolean  experience;
private Integer  age;
private String  email;


public String  setname(String name){ 
	this.name = name;
}

public String  getname(){
	 return this.name; 
}

public String  setcompany(String company){ 
	this.company = company;
}

public String  getcompany(){
	 return this.company; 
}

public List<Object>  setphone_number(List<Object> phone_number){ 
	this.phone_number = phone_number;
}

public List<Object>  getphone_number(){
	 return this.phone_number; 
}

public Object  setsalary(Object salary){ 
	this.salary = salary;
}

public Object  getsalary(){
	 return this.salary; 
}

public boolean  setexperience(boolean experience){ 
	this.experience = experience;
}

public boolean  getexperience(){
	 return this.experience; 
}

public Integer  setage(Integer age){ 
	this.age = age;
}

public Integer  getage(){
	 return this.age; 
}

public String  setemail(String email){ 
	this.email = email;
}

public String  getemail(){
	 return this.email; 
}



}