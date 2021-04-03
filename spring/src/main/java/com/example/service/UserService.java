package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import com.example.model.UserModel;
import com.example.repo.UserRepository;

@Service
@Transactional
public class UserService {
	private  UserRepository userRepo;
	@Autowired
	public UserService(UserRepository userRepo) {
		this.userRepo = userRepo;
	}
	public void deleteUser(String id) {
		userRepo.deleteByemail(id);
	}
	public void addUserModel(UserModel user) {
		userRepo.save(user);
		System.out.println("Adding user");
	}
	
}
