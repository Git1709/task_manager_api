package Rachit22CSU306.com.sprintprogramming.restapi.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import Rachit22CSU306.com.sprintprogramming.restapi.entity.Task;
import Rachit22CSU306.com.sprintprogramming.restapi.entity.TaskProject;

public interface TaskProjectRepository extends JpaRepository<TaskProject,Integer>{
	 List<TaskProject> findAll(Sort sortById);
}
