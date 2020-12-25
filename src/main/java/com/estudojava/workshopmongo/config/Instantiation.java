package com.estudojava.workshopmongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.estudojava.workshopmongo.domain.Post;
import com.estudojava.workshopmongo.domain.User;
import com.estudojava.workshopmongo.repository.PostRepository;
import com.estudojava.workshopmongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;

	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		userRepository.deleteAll();
		postRepository.deleteAll();
		
		User iris = new User(null, "Iris Juliany", "iris@gmail.com");
		User maria = new User(null, "Ana Maria", "maria@gmail.com");
		User anne = new User(null, "Anne Caroline", "anne@gmail.com");
		
		Post post1 = new Post(null, sdf.parse("21/03/2018"), "Partiu viagem", "vou viajar para o matapi, Abracos",maria);
		Post post2 = new Post(null, sdf.parse("23/03/2018"), "Bom dia", "Acordei Feli hoje!", maria);
		
		userRepository.saveAll(Arrays.asList(iris, maria, anne));
		//userRepository.save(Arrays.asList(iris, maria, anne)); da erro
		postRepository.saveAll(Arrays.asList(post1, post2));
		//postRepository.save(Arrays.asList(post1, post2));da erro usando save
	}

}
