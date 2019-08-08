package com.bank.auth.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.bank.auth.domain.User;
import com.bank.auth.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	public User findByUsername(String username) {
		return userRepository.findByUsername(username);
	}

	public void changeUserPassword(User user, String newPassword) {
		user.setPassword(passwordEncoder().encode(newPassword));
		userRepository.save(user);
	}

	public boolean checkIfValidOldPassword(User user, String oldPassword) {
		return passwordEncoder().matches(oldPassword, user.getPassword());
	}
}
