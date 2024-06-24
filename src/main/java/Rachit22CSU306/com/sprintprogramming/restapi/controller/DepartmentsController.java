package Rachit22CSU306.com.sprintprogramming.restapi.controller;

import Rachit22CSU306.com.sprintprogramming.restapi.entity.TaskDepartment;
import Rachit22CSU306.com.sprintprogramming.restapi.repository.TaskDepartmentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/department")
public class DepartmentsController {
    @Autowired
    TaskDepartmentRepository repo;

    @GetMapping
    private List<TaskDepartment> getAllDepartments() {
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public TaskDepartment getDepartment(@PathVariable int id) {
        return repo.findById(id).orElse(null);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> removeDepartment(@PathVariable int id) {
        TaskDepartment department = repo.findById(id).orElse(null);
        if (department != null) {
            repo.delete(department);
            return new ResponseEntity<>("Department deleted successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Department not found", HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/add")
    @ResponseStatus(code = HttpStatus.CREATED)
    public ResponseEntity<TaskDepartment> addDepartment(@RequestBody TaskDepartment department) {
        TaskDepartment savedDepartment = repo.save(department);
        return  ResponseEntity.status( HttpStatus.CREATED).body(savedDepartment);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<TaskDepartment> updateDepartment(@PathVariable int id, @RequestBody TaskDepartment updatedDepartment) {
        TaskDepartment existingDepartment = repo.findById(id).orElse(null);
        if (existingDepartment != null) {
            updatedDepartment.setD_id(id); // Ensure the ID remains the same
            TaskDepartment savedDepartment = repo.save(updatedDepartment);
            return new ResponseEntity<>(savedDepartment, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
