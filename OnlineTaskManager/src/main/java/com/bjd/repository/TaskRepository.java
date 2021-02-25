package com.bjd.repository;

import org.springframework.data.repository.CrudRepository;

import com.bjd.model.Task;

public interface TaskRepository extends CrudRepository<Task, Integer> {

}
