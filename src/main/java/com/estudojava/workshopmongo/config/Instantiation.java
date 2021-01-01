package com.estudojava.workshopmongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.estudojava.workshopmongo.domain.Post;
import com.estudojava.workshopmongo.domain.User;
import com.estudojava.workshopmongo.dto.AuthorDTO;
import com.estudojava.workshopmongo.dto.CommentDTO;
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
		
		userRepository.saveAll(Arrays.asList(iris, maria, anne));
		//userRepository.save(Arrays.asList(iris, maria, anne)); da erro
		
		Post post1 = new Post(null, sdf.parse("21/03/2018"), "Partiu viagem", "vou viajar para o matapi, Abracos", new AuthorDTO(maria));
		Post post2 = new Post(null, sdf.parse("23/03/2018"), "Bom dia", "Acordei Feli hoje!", new AuthorDTO(maria));
		
		CommentDTO c1 = new CommentDTO("Boa viagem", sdf.parse("21/03/2018"), new AuthorDTO(iris));
		CommentDTO c2 = new CommentDTO("aproveite", sdf.parse("22/03/2018"), new AuthorDTO(anne));
		CommentDTO c3 = new CommentDTO("tenha um ótimo dia", sdf.parse("23/03/2018"), new AuthorDTO(iris));
		
		post1.getComments().addAll(Arrays.asList(c1, c2));
		post2.getComments().addAll(Arrays.asList(c3));
		
		postRepository.saveAll(Arrays.asList(post1, post2));
		//postRepository.save(Arrays.asList(post1, post2));da erro usando save
		
		maria.getPosts().addAll(Arrays.asList(post1, post2));
		userRepository.save(maria);
	}

}
