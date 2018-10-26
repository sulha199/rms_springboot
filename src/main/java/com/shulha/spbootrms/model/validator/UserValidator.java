package com.shulha.spbootrms.model.validator;

import org.springframework.validation.Validator;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

import com.shulha.spbootrms.model.User;
import com.shulha.spbootrms.model.UserRepository;

@Component
public class UserValidator implements Validator {
	@Autowired
	UserRepository userRepository;

	@Override
	public boolean supports(Class<?> clazz) {
		return User.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		User user = (User) target;
		String username = user.getUsername();
		if (userRepository.findByUsername(username).isPresent())
			errors.rejectValue("username", "username.exists", new Object[] { username },
					"Username " + username + " already in use");

	}
}
