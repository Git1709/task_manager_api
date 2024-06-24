package Rachit22CSU306.com.sprintprogramming.restapi.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Rachit22CSU306.com.sprintprogramming.restapi.entity.TaskControl;
import Rachit22CSU306.com.sprintprogramming.restapi.entity.TaskEntity;
import Rachit22CSU306.com.sprintprogramming.restapi.entity.TaskProject;
import Rachit22CSU306.com.sprintprogramming.restapi.repository.TaskEntityRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/taskentity")
public class EntityController {

    @Autowired
    private TaskEntityRepository repo;

    @GetMapping("/entities")
    public List<TaskEntity> getAllEntitiesSortedById() {
        // Retrieve all entities sorted by their IDs
        List<TaskEntity> entities = repo.findAll(Sort.by(Sort.Direction.ASC, "id"));
        return entities;
    }

    //
//    @GetMapping
//    private List<TaskEntity> getAllProjects() {
//        List<TaskEntity> taskEntityList = repo.findAll();
//        return taskEntityList;
//    }
    @GetMapping("/{id}")
    private TaskEntity getAllProjects(@PathVariable int id) {
    	TaskEntity taskEntityList = repo.findById(id).get();
        return taskEntityList;
    }


    @PostMapping
    private ResponseEntity<TaskEntity> createTaskEntity(@RequestBody TaskEntity taskEntity) {
        TaskEntity savedEntity = repo.save(taskEntity);
        return new ResponseEntity<>(savedEntity, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<Void> deleteTaskEntity(@PathVariable int id) {
        Optional<TaskEntity> taskEntityOptional = repo.findById(id);
        if (taskEntityOptional.isPresent()) {
            repo.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    private ResponseEntity<TaskEntity> updateTaskEntity(@PathVariable int id, @RequestBody TaskEntity taskEntity) {
        Optional<TaskEntity> existingEntityOptional = repo.findById(id);
        if (existingEntityOptional.isPresent()) {
            TaskEntity existingEntity = existingEntityOptional.get();
            existingEntity.setPost(taskEntity.getPost()); // Update other fields as needed
            TaskEntity updatedEntity = repo.save(existingEntity);
            return new ResponseEntity<>(updatedEntity, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
