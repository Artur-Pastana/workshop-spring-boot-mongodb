package com.estudojava.workshopmongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import com.estudojava.workshopmongo.domain.User;
import com.estudojava.workshopmongo.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repo;
	
	@RequestMapping
	public List<User> findAll() {
		return repo.findAll();
	}
}
