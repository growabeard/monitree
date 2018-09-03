package com.witt.monitree.delegate;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.witt.monitree.entities.User;
import com.witt.monitree.repositories.UserRepository;


@Service
public class UsersDelegate {

	@Autowired
	UserRepository userRepo;
	
	public User[] getAll() {
		List<User> users = new ArrayList<User>();
		Iterable<User> allUsers = userRepo.findAll();
		
		for(User user: allUsers) {
			users.add(user);
		}
    	return users.toArray(new User[users.size()]);
	}

	public User getUser(Integer id) {
		return new User();
//		return userRepo.findOne(id);
	}

}
