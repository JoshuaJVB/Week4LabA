package com.GroupA.Week4LabA.Service;

import java.util.Optional;
import com.GroupA.Week4LabA.Model.User;

public interface UserService {

	Optional<User>getUserById(Long id);
	Iterable<User> getAllUsers();
	void saveUser(User user);
	void updateUser(User newUser, Long id);
    void removeUserById(Long id);

}