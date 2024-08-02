package dev.joaobertholino.apiresttest.services;

import dev.joaobertholino.apiresttest.dtos.UserDto;
import dev.joaobertholino.apiresttest.models.User;
import dev.joaobertholino.apiresttest.repositories.UserRepository;
import dev.joaobertholino.apiresttest.services.exceptions.UserNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {
	private final UserRepository userRepository;

	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public List<User> findAll() {
		return this.userRepository.findAll();
	}

	public User findById(UUID id) {
		Optional<User> userResult = this.userRepository.findById(id);
		return userResult.orElseThrow(() -> new UserNotFoundException("User referring to the previous ID was not found"));
	}

	@Transactional
	public void insert(User user) {
		this.userRepository.save(user);
	}

	@Transactional
	public void update(UUID id, UserDto userUpdated) {
		User user = findById(id);
		BeanUtils.copyProperties(userUpdated, user);
		this.userRepository.save(user);
	}

	@Transactional
	public void deleteById(UUID id) {
		this.userRepository.deleteById(findById(id).getId());
	}
}
