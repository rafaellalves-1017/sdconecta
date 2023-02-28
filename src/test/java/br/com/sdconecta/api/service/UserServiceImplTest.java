package br.com.sdconecta.api.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.web.client.RestTemplate;

import br.com.sdconecta.api.dto.UserDTO;
import br.com.sdconecta.api.fixture.UserFixture;
import br.com.sdconecta.api.model.User;
import br.com.sdconecta.api.repository.UserRepostory;

@ActiveProfiles("test")
public class UserServiceImplTest {
	
	private static final String ACCEPT = "Accept";
	
//	private static String url = "https://api.github.com/users/";
	
	@Value(value = "${api.url}")
	private String url;
	
	@Spy
	@InjectMocks
	private UserServiceImpl userService;
	
	@Mock
	private ModelMapper modelMapper;

	@Mock
	private RestTemplate restTemplate;
	
	@Mock
	private UserRepostory userRepostory;
	
	@Mock
	ResponseEntity<UserDTO> responseEntity;
	
	private UserDTO userDTO;
	
	private User user;
	
	@BeforeEach
	public void init() {
		MockitoAnnotations.openMocks(this);
		userDTO = UserFixture.criarUserDTO();
		user = UserFixture.criarUser(userDTO);
	}
	
	@Test
	void givenUser_whenFindUserByLogin_thenReturnUser() {
		when(userRepostory.findByLogin(userDTO.getLogin())).thenReturn(Optional.of(user));
		when(modelMapper.map(user, UserDTO.class)).thenReturn(userDTO);
		
		UserDTO response = userService.findUser(userDTO.getLogin());
		assertEquals(response.getId(), userDTO.getId());
	}
	
	@Test
	void givenUser_whenSaveUser_thenReturnUserSaved() {
		StringBuilder endpoint = new StringBuilder();
		endpoint.append(url);
		endpoint.append(userDTO.getLogin());
		
		ResponseEntity<UserDTO> responseEntity = new ResponseEntity<>(userDTO, HttpStatus.OK);

		when(userService.getUrl()).thenReturn("https://api.github.com/users/");
		when(responseEntity.getBody()).thenReturn(userDTO);
		when(restTemplate.getForEntity("https://api.github.com/users/rafaellalves1017", UserDTO.class)).thenReturn(responseEntity);
		when(userService.findUserApiGitHub(userDTO.getLogin())).thenReturn(userDTO);
		when(modelMapper.map(userDTO, User.class)).thenReturn(user);
		when(userRepostory.save(user)).thenReturn(user);
		when(modelMapper.map(userDTO, UserDTO.class)).thenReturn(userDTO);
		when(userService.saveUser(userDTO)).thenReturn(userDTO);
		
		UserDTO response = userService.processUser(userDTO.getLogin());
		assertEquals(response.getId(), userDTO.getId());
	}
	
}
