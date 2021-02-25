package com.bjd.repository;

import org.springframework.data.repository.CrudRepository;

import com.bjd.model.User;

public interface UserRepository extends CrudRepository<User, Integer> {
    public User findUserByUsername(String name);
}
