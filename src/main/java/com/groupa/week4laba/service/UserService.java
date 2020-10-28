package com.groupa.week4laba.service;

import java.util.Optional;
import com.groupa.week4laba.model.User;

public interface UserService {

	Optional<User>getUserById(Long id);
	Iterable<User> getAllUsers();
	void saveUser(User user);
	void updateUser(User newUser, Long id);
    void removeUserById(Long id);

}