package Rachit22CSU306.com.sprintprogramming.restapi.entity;
import java.sql.Date;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name="Projects")
public class TaskProject {
@Id
@GeneratedValue(strategy= GenerationType.IDENTITY)

private int P_number;
@Column(name="Nameing")
private String Nameing;
@Column
private String Location;
public TaskProject() {
	super();
	// TODO Auto-generated constructor stub
}
public TaskProject(int p_number, String nameing, String location) {
	
	this.P_number = p_number;
	this.Nameing = nameing;
	this.Location = location;
}
public int getP_number() {
	return P_number;
}
public void setP_number(int p_number) {
	P_number = p_number;
}
public String getNameing() {
	return Nameing;
}
public void setNameing(String nameing) {
	Nameing = nameing;
}
public String getLocation() {
	return Location;
}
public void setLocation(String location) {
	Location = location;
}
@Override
public String toString() {
	return "TaskProject [P_number=" + P_number + ", Nameing=" + Nameing + ", Location=" + Location + "]";
}

}
