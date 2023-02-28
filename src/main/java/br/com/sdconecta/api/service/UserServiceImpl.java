package br.com.sdconecta.api.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.sdconecta.api.dto.UserDTO;
import br.com.sdconecta.api.exceptions.Error;
import br.com.sdconecta.api.exceptions.ServiceException;
import br.com.sdconecta.api.model.User;
import br.com.sdconecta.api.repository.UserRepostory;
import lombok.Data;

@Data
@Service
public class UserServiceImpl implements UserService {
	
//	private static final String ACCEPT = "Accept";
	
	@Value(value = "${api.url}")
	private String url;
	
	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private UserRepostory userRepostory;

	public UserDTO findUserApiGitHub(String login) {
//		HttpHeaders headers = new HttpHeaders();
//		headers.set(ACCEPT, MediaType.APPLICATION_JSON_VALUE);
		
		StringBuilder endpoint = new StringBuilder();
		endpoint.append(url);
		endpoint.append(login);

//		HttpEntity<String> requestEntity = new HttpEntity<>(null, headers);

		ResponseEntity<UserDTO> response = restTemplate.getForEntity(endpoint.toString(), UserDTO.class);

		return response.getBody();
	}
	
	public UserDTO saveUser(UserDTO userDTO) {
		User user = modelMapper.map(userDTO, User.class);
		User response = userRepostory.save(user);
		return modelMapper.map(response, UserDTO.class);
	}
	
	@Override
	public UserDTO processUser(String login) {
		UserDTO userDTO = findUserApiGitHub(login);
		return saveUser(userDTO);
	}
	
	@Override
	public UserDTO findUser(String login) {
		User user = userRepostory.findByLogin(login).orElseThrow(() -> new ServiceException(Error.LOGIN_NOT_FOUND_ERROR));
		return modelMapper.map(user, UserDTO.class);
	}

}
