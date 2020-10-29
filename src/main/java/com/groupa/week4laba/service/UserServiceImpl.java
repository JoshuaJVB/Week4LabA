package com.GroupA.week4laba.service;

import com.GroupA.week4laba.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.Optional;
import com.GroupA.week4laba.model.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepo repository;

	@Override
	public Optional<User> getUserById(Long id) {
		return repository.findById(id);
	}

	@Override
	public User getUserByUsername(String username) {
		Iterable<User> results = repository.findByUsername(username);
		Iterator<User> iterator = results.iterator();

		User user = null;
		while (iterator.hasNext()) {
			user = iterator.next();
			break;
		}

		return user;
	}

	@Override
	public Iterable<User> getAllUsers() {
		return repository.findAll();
	}

	@Override
	public User saveUser(User user) {
		return repository.save(user);
	}

	@Override
    public void updateUser(User newUser, Long id) {
        repository.findById(id).map(user -> {
            user.setUsername(newUser.getUsername());
            user.setTotalScore(newUser.getTotalScore());
            user.setLevel(newUser.getLevel());
            return repository.save(user);
        });
    }

    @Override
    public void updateTotalScore(Long score, Long forUserWithId) {
        repository.findById(forUserWithId).map(user -> {
            user.setTotalScore(score);
            user.addLevel();
            return repository.save(user);
        });
    }

	@Override
	public void removeUserById(Long id) {
		repository.deleteById(id);
	}
}

