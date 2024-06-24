package Rachit22CSU306.com.sprintprogramming.restapi.entity;

import jakarta.persistence.Column;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Entity")
public class TaskEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_sid") // Specify the column name here
    private int id;

    @Column
    private String Post;
public TaskEntity() {
	super();
	// TODO Auto-generated constructor stub
}
public TaskEntity(int id, String post) {
	super();
	this.id = id;
	Post = post;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getPost() {
	return Post;
}
public void setPost(String post) {
	Post = post;
}
@Override
public String toString() {
	return "TaskEntity [id=" + id + ", Post=" + Post + "]";
} 


}
