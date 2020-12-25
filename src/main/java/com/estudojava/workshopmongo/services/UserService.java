package com.estudojava.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import com.estudojava.workshopmongo.domain.User;
import com.estudojava.workshopmongo.repository.UserRepository;
import com.estudojava.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repo;
	
	@RequestMapping
	public List<User> findAll() {
		return repo.findAll();
	}
	
	public User findById(String id) {
		Optional<User> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("objeto não encontrado"));
	}
}
