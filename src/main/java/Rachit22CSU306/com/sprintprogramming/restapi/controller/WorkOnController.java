    package Rachit22CSU306.com.sprintprogramming.restapi.controller;

    import java.util.List;

    import Rachit22CSU306.com.sprintprogramming.restapi.repository.TaskControlRepository;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.data.domain.Sort;
    import org.springframework.http.HttpStatus;
    import org.springframework.http.ResponseEntity;
    import org.springframework.web.bind.annotation.*;

    import java.util.List;
    import java.util.Optional;

    import Rachit22CSU306.com.sprintprogramming.restapi.entity.TaskEntity;
    import Rachit22CSU306.com.sprintprogramming.restapi.entity.TaskWorksOn;
    import Rachit22CSU306.com.sprintprogramming.restapi.repository.TaskWorkOnRepository;

    @RestController
    @RequestMapping("/api/workon")
    public class WorkOnController {

        @Autowired
        private TaskWorkOnRepository repo;
        @GetMapping
        public List<TaskWorksOn> getAllEntitiesSortedById() {
            // Retrieve all entities sorted by their IDs
            List<TaskWorksOn> entities = repo.findAll(Sort.by(Sort.Direction.ASC, "id"));
            return entities;
        }

        
        
        
        
        
    //    public List<TaskWorksOn> getAllEntitiesSortedById() {
    //        // Retrieve all entities sorted by their IDs
    //        List<TaskWorksOn> entities = repo.findAll(Sort.by(Sort.Direction.ASC, "id"));
    //        return entities;
    //    }

        
        
        
        
        //    @GetMapping
    //    private List<TaskWorksOn> getAllTasks() {
    //        List<TaskWorksOn> taskWorksOnList = repo.findAll();
    //        return taskWorksOnList;
    //    }

    
        @GetMapping("/employee/{employeesid}")
        private ResponseEntity<TaskWorksOn> getTaskByEmployeeSid(@PathVariable("employeesid") int employeeSid) {
            Optional<TaskWorksOn> taskOptional = repo.findById(employeeSid);
            return taskOptional.map(task -> new ResponseEntity<>(task, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
        }
        
    
        
        @GetMapping("/project/{project}")
        private ResponseEntity<TaskWorksOn> getTaskByProject(@PathVariable("project") int project) {
            TaskWorksOn task = repo.findByProject(project);
            if (task != null) {
                return new ResponseEntity<>(task, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }


        
        @PostMapping
        private ResponseEntity<TaskWorksOn> addTask(@RequestBody TaskWorksOn task) {
            TaskWorksOn savedTask = repo.save(task);
            return new ResponseEntity<>(savedTask, HttpStatus.CREATED);
        }

    
        @DeleteMapping("/{employee_sid}")
        private ResponseEntity<Void> deleteTask(@PathVariable("employee_sid") int employeeSid) {
            if (repo.existsById(employeeSid)) {
                repo.deleteById(employeeSid);
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }

    
        @PutMapping("/{employee_sid}")
        private ResponseEntity<TaskWorksOn> updateTask(@PathVariable("employee_sid") int employeeSid, @RequestBody TaskWorksOn task) {
            if (repo.existsById(employeeSid)) {
                task.setId(employeeSid);
                TaskWorksOn updatedTask = repo.save(task);
                return new ResponseEntity<>(updatedTask, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }
    }
