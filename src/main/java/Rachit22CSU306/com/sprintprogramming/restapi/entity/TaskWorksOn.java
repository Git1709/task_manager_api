package Rachit22CSU306.com.sprintprogramming.restapi.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity 
@Table(name="workon")
public class TaskWorksOn {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_sid") // Matches the column name in the database
    private int id; 
    
    @Column(name = "P_number") // Matches the column name in the database
    private int project;

    public TaskWorksOn() {
        super();
    }

    public TaskWorksOn(int id, int project) {
        super();
        this.id = id;
        this.project = project;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProject() {
        return project;
    }

    public void setProject(int project) {
        this.project = project;
    }

    @Override
    public String toString() {
        return "TaskWorksOn [id=" + id + ", project=" + project + "]";
    }  
}
