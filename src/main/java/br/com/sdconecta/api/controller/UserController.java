package br.com.sdconecta.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.sdconecta.api.dto.UserDTO;
import br.com.sdconecta.api.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping("/{login}")
	public UserDTO processUser(@PathVariable String login) {
		return userService.processUser(login);
	}
	
	@GetMapping("/find")
	public UserDTO findUser(@RequestParam String login) {
		return userService.findUser(login);
	}
	
}
