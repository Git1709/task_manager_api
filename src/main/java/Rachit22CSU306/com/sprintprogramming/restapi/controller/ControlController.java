package Rachit22CSU306.com.sprintprogramming.restapi.controller;

import Rachit22CSU306.com.sprintprogramming.restapi.entity.TaskControl;
import Rachit22CSU306.com.sprintprogramming.restapi.entity.TaskWorksOn;
import Rachit22CSU306.com.sprintprogramming.restapi.repository.TaskControlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/taskcontrol")
public class ControlController {

    @Autowired
    private TaskControlRepository taskControlRepository;

    
    @GetMapping
    
    public List<TaskControl> getAllEntitiesSortedById() {
        // Retrieve all entities sorted by their IDs
        List<TaskControl> entities = taskControlRepository.findAll(Sort.by(Sort.Direction.ASC, "enitytid"));
        return entities;
    }

    
    //
//    @GetMapping
//    public ResponseEntity<List<TaskControl>> getAllTaskControls() {
//        List<TaskControl> taskControls = taskControlRepository.findAll();
//        return ResponseEntity.ok(taskControls);
//    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskControl> getTaskControlById(@PathVariable int id) {
        Optional<TaskControl> taskControlOptional = taskControlRepository.findById(id);
        return taskControlOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<TaskControl> createTaskControl(@RequestBody TaskControl taskControl) {
        TaskControl savedTaskControl = taskControlRepository.save(taskControl);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedTaskControl);
    }
    @PutMapping("/{id}")
    public ResponseEntity<TaskControl> updateTaskControl(@PathVariable int id, @RequestBody TaskControl updatedTaskControl) {
        Optional<TaskControl> optionalTaskControl = taskControlRepository.findById(id);
        if (optionalTaskControl.isPresent()) {
            TaskControl existingTaskControl = optionalTaskControl.get();
            existingTaskControl.setD_id(updatedTaskControl.getD_id());
            // Update other fields if needed
            TaskControl savedTaskControl = taskControlRepository.save(existingTaskControl);
            return ResponseEntity.ok(savedTaskControl);
        } else {
            return ResponseEntity.notFound().build();
        }	
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTaskControl(@PathVariable int id) {
        Optional<TaskControl> optionalTaskControl = taskControlRepository.findById(id);
        if (optionalTaskControl.isPresent()) {
            taskControlRepository.delete(optionalTaskControl.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
