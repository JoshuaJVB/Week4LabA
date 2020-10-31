package com.groupa.week4laba.service;

import com.groupa.week4laba.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;
import com.groupa.week4laba.model.User;

/***********************************************************
 * @author  Tye Porter (github.com/tyeporter)
 * @version 0.1
 * @since   10-28-2020
 ***********************************************************/

@Service
public class UserServiceImpl implements UserService {

	// =========================================================
    // Properties
    // =========================================================

	private final UserRepo repository;

	// =========================================================
    // Constructor
    // =========================================================

	@Autowired
	public UserServiceImpl(UserRepo userRepo) {
		this.repository = userRepo;
	}

	// =========================================================
    // GET
    // =========================================================

	@Override
	public Optional<User> getUserById(Long id) {
		return repository.findById(id);
	}

	@Override
	public User getUserByUsername(String username) {
		User user = repository.findByUsername(username).orElse(null);

		if (user == null) {
			user = repository.save(new User(username));
		}

		return user;
	}

	@Override
	public Iterable<User> getAllUsers() {
		return repository.findAll();
	}

	// =========================================================
    // POST
    // =========================================================

	@Override
	public User saveUser(User user) {
		return repository.save(user);
	}

	// =========================================================
    // PUT
    // =========================================================

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

    // =========================================================
    // DELETE
    // =========================================================

	@Override
	public void removeUserById(Long id) {
		repository.deleteById(id);
	}
}

