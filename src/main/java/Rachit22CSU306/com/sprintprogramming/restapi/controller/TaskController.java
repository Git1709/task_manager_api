package Rachit22CSU306.com.sprintprogramming.restapi.controller;




import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import Rachit22CSU306.com.sprintprogramming.restapi.entity.Task;
import Rachit22CSU306.com.sprintprogramming.restapi.repository.TaskRepository;

@RestController
public class TaskController {
@Autowired
TaskRepository repo;
@GetMapping("/employee")
public List<Task> getAllTasks() {
List<Task> tasks = repo.findAll(Sort.by(Sort.Direction.ASC, "id"));
return tasks;
}
@GetMapping("/employee/{id}")
public Task getEbook(@PathVariable int id){
	Task ebook=repo.findById(id).get();
	return ebook;

}
//@PostMapping("/ebook/add")
//@ResponseStatus(code=HttpStatus.CREATED)
//public void createEbook(@RequestBody Ebook ebook) {
//	repo.save(ebook);
//
//}



@PostMapping("/employee/add")
@ResponseStatus(code=HttpStatus.CREATED)
public void createEbook(@RequestBody Task Task) {
	repo.save(Task);
	
}
//
//@PostMapping("/employee/add")
//@ResponseStatus(code = HttpStatus.CREATED)
//public ResponseEntity<String> createEbook(@RequestBody String fullName) {
//    String[] parts = fullName.split("\\s+", 2); // Split the input into maximum 2 parts based on whitespace
//    if (parts.length == 2) {
//        Task task = new Task();
//        task.setFnamed(parts[0]);
//        task.setLnamed(parts[1]);
//        repo.save(task);
//        return ResponseEntity.status(HttpStatus.CREATED).body("Ebook created successfully");
//    } else {
//        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid input format. Please provide both first name and last name separated by a space.");
//    }
//}



@PutMapping("/employee/update/{id}")
public ResponseEntity<Task> updateEbook(@PathVariable int id, @RequestBody Task updatedEbook) {
    Optional<Task> optionalEbook = repo.findById(id);
    if (optionalEbook.isPresent()) {
        Task ebook = optionalEbook.get();
        if (updatedEbook.getNamed() != null) {
            String[] parts = updatedEbook.getNamed().split("\\s+", 2);
            // Split the updated Named field into first name and last name
            if (parts.length == 2) {
                ebook.setFnamed(parts[0]);
                ebook.setLnamed(parts[1]);
            } else {
                return ResponseEntity.badRequest().body(null); // Invalid input format for Named
            }
        }
        ebook.setAddress(updatedEbook.getAddress());
        ebook.setAge(updatedEbook.getAge());
        ebook.setSalary(updatedEbook.getSalary());
        ebook.setNamed(updatedEbook.getNamed());
        ebook.setSex(updatedEbook.getSex());
        ebook.setDatedjoined(updatedEbook.getDatedjoined());
        ebook.setContact(updatedEbook.getContact());
        repo.save(ebook);
        return ResponseEntity.ok(ebook);
    } else {
        return ResponseEntity.notFound().build();
    }
}



@DeleteMapping("employee/delete/{id}")
public void removeEbook(@PathVariable int id){
	Task task =repo.findById(id).get();
	repo.delete(task);
	
}

}
