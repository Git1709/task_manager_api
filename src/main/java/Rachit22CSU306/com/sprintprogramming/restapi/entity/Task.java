package Rachit22CSU306.com.sprintprogramming.restapi.entity;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name="employee")
public class Task {
@Id

@GeneratedValue(strategy= GenerationType.IDENTITY)
private int id;
@Column(name="named")
private String named;
@Column
private String Fnamed;
@Column
private String Lnamed;

@Column(name="address")
private String address;
@Column(name="Salary")
private double Salary;
@Column
private int Age;
@Column
private String Sex;
@Column
private Date Datedjoined;
@Column
private String Contact;

public Task() {
System.out.print("hello");
	// TODO Auto-generated constructor stub
}

public Task(int id, String named,String Fnamed, String Lnamed,double Salary, int Age,String Sex,Date Datedjoined,String Contact) {
	super();
	this.id = id;
	this.named = named;
	this.Salary = Salary;
	this.Age = Age;
	this.Sex=Sex;
	this.Datedjoined=Datedjoined;
	this.Contact=Contact;
	
	this.Fnamed=Fnamed;
	this.Lnamed=Lnamed;
}

public String getContact() {
	return Contact;
}

public void setContact(String contact) {
	Contact = contact;
}

public Date getDatedjoined() {
	return Datedjoined;
}

public void setDatedjoined(Date datedjoined) {
	Datedjoined = datedjoined;
}

public String getSex() {
	return Sex;
}

public void setSex(String sex) {
	Sex = sex;
}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getNamed() {
	return named;
}
public void setNamed(String named) {
	this.named = named;
}




public String getFnamed() {
	return Fnamed;
}

public void setFnamed(String fnamed) {
	Fnamed = fnamed;
}

public String getLnamed() {
	return Lnamed;
}

public void setLnamed(String lnamed) {
	Lnamed = lnamed;
}

public String getAddress() {
	return address;
}

public void setAddress(String title) {
	this.address = title;
}

public double getSalary() {
	return Salary;
}

public void setSalary( double Salary) {
	this.Salary = Salary;
}

public int getAge() {
	return Age;
}

public void setAge(int Age) {
	this.Age = Age;
}

@Override
public String toString() {
	return "Task [id=" + id + ", Name=" + named + ", Fisrt Name=" + Fnamed + ", Last Name=" + Lnamed+", title="+address+", Salary=" + Salary + ", Age=" + Age + "Sex="+Sex+"Dated joined="+Datedjoined+"Contact="+Contact+"]";
}



}
