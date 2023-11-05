package br.edu.atitus.atitusound.controllers;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.atitus.atitusound.dtos.UserDTO;
import br.edu.atitus.atitusound.entities.UserEntity;
import br.edu.atitus.atitusound.services.UserService;
import ch.qos.logback.core.joran.util.beans.BeanUtil;

@RestController
@RequestMapping("/auth")
public class AuthController {
	
	private final UserService service;

	private UserEntity convertDTO2Entity(UserDTO dto) {
		var user = new UserEntity();
		BeanUtils.copyProperties(dto, user);
		return user;
	}
	
	public AuthController(UserService service) {
		super();
		this.service = service;
	}
	
	@PostMapping("/signup")
	public ResponseEntity<UserEntity> PostSignup(@RequestBody UserDTO dto ) {
		
		var user = convertDTO2Entity(dto);
		
		try {
			service.save(user);
		} catch (Exception e) {
			return ResponseEntity.badRequest().header("error", e.getMessage()).build();
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(user);
	}
	
}
