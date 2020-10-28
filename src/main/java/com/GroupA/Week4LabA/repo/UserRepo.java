package com.GroupA.Week4LabA.Repo;

import com.GroupA.Week4LabA.Model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends CrudRepository<User, Long> {}
