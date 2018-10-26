package com.shulha.spbootrms.model.dto;

import java.util.ArrayList;
import java.util.List;

import com.shulha.spbootrms.model.User;

public class UserCreationDto {
	
	private List<User> users = new ArrayList<User>();

	// default and parameterized constructor

	public void addUser(User user) {
		this.users.add(user);
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

}
