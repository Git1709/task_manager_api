package Rachit22CSU306.com.sprintprogramming.restapi.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import Rachit22CSU306.com.sprintprogramming.restapi.entity.Task;
import Rachit22CSU306.com.sprintprogramming.restapi.entity.TaskEntity;

public interface TaskEntityRepository extends JpaRepository<TaskEntity,Integer> {
	 List<TaskEntity> findAll(Sort sortById);
}
