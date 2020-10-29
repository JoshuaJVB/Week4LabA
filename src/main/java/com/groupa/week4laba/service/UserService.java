package com.GroupA.week4laba.service;

import java.util.Optional;
import com.GroupA.week4laba.model.User;

public interface UserService {

	Optional<User>getUserById(Long id);
	User getUserByUsername(String username);
	Iterable<User> getAllUsers();
	User saveUser(User user);
	void updateUser(User newUser, Long id);
	void updateTotalScore(Long score, Long forUserWithId);
    void removeUserById(Long id);

}