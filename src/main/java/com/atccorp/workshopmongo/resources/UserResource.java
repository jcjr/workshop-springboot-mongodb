package com.atccorp.workshopmongo.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.atccorp.workshopmongo.domain.User;
import com.atccorp.workshopmongo.dto.UserDTO;
import com.atccorp.workshopmongo.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

	@Autowired
	public UserService service;
	
	//Mesma coisa -> @RequestMapping(method = RequestMethod.GET);
	@GetMapping 
	public ResponseEntity<List<UserDTO>> findAll() {
		return ResponseEntity.ok()
				.body(service.findAll().stream()
						.map(x -> new UserDTO(x)).collect(Collectors.toList()));
	}
	
}
