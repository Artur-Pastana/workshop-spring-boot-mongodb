package com.estudojava.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import com.estudojava.workshopmongo.domain.User;
import com.estudojava.workshopmongo.dto.UserDTO;
import com.estudojava.workshopmongo.repository.UserRepository;
import com.estudojava.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repo;
	
	@RequestMapping
	public List<User> findAll() {//retornando todos os objetos
		return repo.findAll();
	}
	
	public User findById(String id) {//retornando um objeto por id
		Optional<User> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("objeto não encontrado"));
	}
	
	public User insert(User obj) {
		return repo.insert(obj);
	}
	
	public void delete(String id) {
		findById(id);
		repo.deleteById(id);
	}
	
	public User fromDTO(UserDTO objDTO) {
		return new User(objDTO.getId(), objDTO.getNome(), objDTO.getEmail());
	}
	
	
}
