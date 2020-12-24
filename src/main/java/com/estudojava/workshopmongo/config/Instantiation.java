package com.estudojava.workshopmongo.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.estudojava.workshopmongo.domain.User;
import com.estudojava.workshopmongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		
		userRepository.deleteAll();
		
		User iris = new User(null, "Iris Juliany", "iris@gmail.com");
		User maria = new User(null, "Ana Maria", "maria@gmail.com");
		User anne = new User(null, "Anne Caroline", "anne@gmail.com");
		
		userRepository.saveAll(Arrays.asList(iris, maria, anne));
		//userRepository.save(Arrays.asList(iris, maria, anne));
	}

}
