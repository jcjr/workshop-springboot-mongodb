package com.atccorp.workshopmongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.atccorp.workshopmongo.domain.Post;
import com.atccorp.workshopmongo.domain.User;
import com.atccorp.workshopmongo.dto.AuthorDTO;
import com.atccorp.workshopmongo.repository.PostRepository;
import com.atccorp.workshopmongo.repository.UserRepository;

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

		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");

		userRepository.saveAll(Arrays.asList(maria, alex, bob));

		// @formatter:off
		Post post1 = new Post(null, sdf.parse("10/08/2024"), "Partiu Viagem"
								, "Vou Viajar para São Paulo. Abraços"
								, new AuthorDTO(maria));
		Post post2 = new Post(null, sdf.parse("11/08/2024"), "Bom dia"
								, "Acordei feliz hoje"
								, new AuthorDTO(maria));
		// @formatter:on

		postRepository.saveAll(Arrays.asList(post1, post2));

	}

}
