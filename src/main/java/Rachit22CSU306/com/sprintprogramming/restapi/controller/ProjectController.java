package Rachit22CSU306.com.sprintprogramming.restapi.controller;
import Rachit22CSU306.com.sprintprogramming.restapi.entity.Task;
import Rachit22CSU306.com.sprintprogramming.restapi.entity.TaskProject;
import Rachit22CSU306.com.sprintprogramming.restapi.repository.TaskProjectRepository;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/taskproject")
public class ProjectController {
@Autowired
TaskProjectRepository repo;
@GetMapping
private List<TaskProject> getAllProjects(){
	List<TaskProject> taskProjectRepository= repo.findAll();
	return taskProjectRepository;
	
}
@GetMapping("/{id}")
public  TaskProject getProjects(@PathVariable int id){
	TaskProject taskProjectRepository=  repo.findById(id).get();
	return taskProjectRepository ;
	
	
}

@PostMapping
@ResponseStatus(HttpStatus.CREATED)
public TaskProject createProject(@RequestBody TaskProject taskProject) {
    return repo.save(taskProject);
}

@PutMapping("/{id}")
public ResponseEntity<TaskProject> updateProject(@PathVariable int id, @RequestBody TaskProject updatedProject) {
    TaskProject existingProject = repo.findById(id).orElse(null);
    if (existingProject != null) {
        updatedProject.setP_number(id); // Ensure ID consistency
        TaskProject savedProject = repo.save(updatedProject);
        return ResponseEntity.ok(savedProject);
    } else {
        return ResponseEntity.notFound().build();
    }
}
@DeleteMapping("/{id}")
public void removeProject(@PathVariable int id) {

TaskProject task = repo.findById(id).get();
repo.delete(task);

}


}
