package com.bank.auth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bank.auth.domain.ChangePassword;
import com.bank.auth.domain.User;
import com.bank.auth.exception.InvalidOldPasswordException;
import com.bank.auth.service.UserService;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/api/v1")
public class ResourceController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/changepassword", method = RequestMethod.POST)
	public ResponseEntity<String> changePassword(@RequestBody ChangePassword changePassword) {
		User userDetails = userService.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
		if (!userService.checkIfValidOldPassword(userDetails, changePassword.getOldPassword())) {
			throw new InvalidOldPasswordException();
		}
		userService.changeUserPassword(userDetails, changePassword.getNewPassword());
		return new ResponseEntity<String>("Your password has been changed successfully !..", HttpStatus.OK);
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public ResponseEntity<String> logoutUser(HttpServletRequest request, HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		return new ResponseEntity<String>("Your have been logged out successfully !..", HttpStatus.OK);
	}
}
