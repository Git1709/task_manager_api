package Rachit22CSU306.com.sprintprogramming.restapi.entity;
import java.sql.Date;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name="Department")
public class TaskDepartment {

	    @Id
	    @GeneratedValue(strategy= GenerationType.IDENTITY)
	    private int d_id;
	    
	    @Column(name="Dname")
	    private String Dname;
	    
	    @Column(name="Location")
	    private String Location;

		public TaskDepartment() {
			super();
			// TODO Auto-generated constructor stub
		}

		public TaskDepartment(int d_id, String dname, String location) {
			super();
			this.d_id = d_id;
			Dname = dname;
			Location = location;
		}

		public int getD_id() {
			return d_id;
		}

		public void setD_id(int d_id) {
			this.d_id = d_id;
		}

		public String getDname() {
			return Dname;
		}

		public void setDname(String dname) {
			Dname = dname;
		}

		public String getLocation() {
			return Location;
		}

		public void setLocation(String location) {
			Location = location;
		}

		@Override
		public String toString() {
			return "TaskDepartment [d_id=" + d_id + ", Dname=" + Dname + ", Location=" + Location + "]";
		}

	  
	}