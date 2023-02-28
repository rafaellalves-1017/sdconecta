package br.com.sdconecta.api.service;

import br.com.sdconecta.api.dto.UserDTO;

public interface UserService {

	UserDTO processUser(String login);

	UserDTO findUser(String login);
	
}
