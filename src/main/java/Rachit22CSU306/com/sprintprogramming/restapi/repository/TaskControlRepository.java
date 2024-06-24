package Rachit22CSU306.com.sprintprogramming.restapi.repository;

import Rachit22CSU306.com.sprintprogramming.restapi.entity.Task;
import Rachit22CSU306.com.sprintprogramming.restapi.entity.TaskControl;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskControlRepository extends JpaRepository<TaskControl, Integer> {
	 List<TaskControl> findAll(Sort sortById);
}
