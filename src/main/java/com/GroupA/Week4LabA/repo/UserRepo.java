package com.GroupA.Week4LabA.repo;

import com.GroupA.Week4LabA.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends CrudRepository<User, Long> {}
