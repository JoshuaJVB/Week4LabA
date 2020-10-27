package com.GroupA.Week4LabA.service;

import com.GroupA.Week4LabA.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;
import com.GroupA.Week4LabA.model.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepo repository;

	@Override
	public Optional<User> getUserById(Long id) {
		return repository.findById(id);
	}

	@Override
	public Iterable<User> getAllUsers() {
		return repository.findAll();
	}

	@Override
	public void saveUser(User user) {
		repository.save(user);
	}

	@Override
    public void updateUser(User newUser, Long id) {
        repository.findById(id).map(user -> {
            user.setUsername(newUser.getUsername());
            user.setTotalScore(newUser.getTotalScore());
            user.setLevel(newUser.getLevel());
            return repository.save(user);
        });

        repository.findById(id);
    }

	@Override
	public void removeUserById(Long id) {
		repository.deleteById(id);
	}
}

