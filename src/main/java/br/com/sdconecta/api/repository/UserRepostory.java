package br.com.sdconecta.api.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.sdconecta.api.model.User;

@Repository
public interface UserRepostory extends MongoRepository<User, Long> {

	Optional<User> findByLogin(String login);
	
}
