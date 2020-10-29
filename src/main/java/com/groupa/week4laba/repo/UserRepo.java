package com.groupa.week4laba.repo;

import com.groupa.week4laba.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends CrudRepository<User, Long> {

	Iterable<User> findByUsername(String username);

}
