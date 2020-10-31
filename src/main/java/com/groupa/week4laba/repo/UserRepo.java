package com.groupa.week4laba.repo;

import com.groupa.week4laba.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface UserRepo extends CrudRepository<User, Long> {

	Optional<User> findByUsername(String username);

}
