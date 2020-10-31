package com.groupa.week4laba.service;

import com.groupa.week4laba.model.User;
import java.util.Optional;

/***********************************************************
 * @author  Tye Porter (github.com/tyeporter)
 * @version 0.1
 * @since   10-28-2020
 ***********************************************************/

public interface UserService {

	Optional<User> getUserById(Long id);
	User getUserByUsername(String username);
	Iterable<User> getAllUsers();
	User saveUser(User user);
	void updateUser(User newUser, Long id);
	void updateTotalScore(Long score, Long forUserWithId);
    void removeUserById(Long id);

}