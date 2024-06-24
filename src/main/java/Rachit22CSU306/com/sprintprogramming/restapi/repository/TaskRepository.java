package Rachit22CSU306.com.sprintprogramming.restapi.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;




import Rachit22CSU306.com.sprintprogramming.restapi.entity.Task;

public interface TaskRepository extends JpaRepository<Task,Integer>{
	 List<Task> findAll(Sort sortById);
}
