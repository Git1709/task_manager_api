package Rachit22CSU306.com.sprintprogramming.restapi.entity;
import java.sql.Date;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name="Control")
public class TaskControl {
	@Id
    private int enitytid;

    @Column
    private int d_id;
    

	public TaskControl() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TaskControl(int enityt_id, int d_id) {
		super();
		this.enitytid = enityt_id;
		this.d_id = d_id;
	}

	public int getEnityt_id() {
		return enitytid;
	}

	public void setEnityt_id(int enityt_id) {
		this.enitytid = enityt_id;
	}

	public int getD_id() {
		return d_id;
	}

	public void setD_id(int d_id) {
		this.d_id = d_id;
	}

	@Override
	public String toString() {
		return "TaskControl [enityt_id=" + enitytid + ", d_id=" + d_id + "]";
	}
    

}
