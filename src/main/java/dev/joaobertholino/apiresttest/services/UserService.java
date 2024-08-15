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

	public List<UserDto> findAll() {
		List<User> userList = this.userRepository.findAll();
		if (userList.isEmpty()) throw new UserNotFoundException("No user found in the database");
		return userList.stream().map(user -> new UserDto(user)).toList();
	}

	public UserDto findById(UUID id) {
		Optional<User> userResult = this.userRepository.findById(id);
		User user = userResult.orElseThrow(() -> new UserNotFoundException("User referring to the previous ID was not found"));
		return new UserDto(user);
	}

	@Transactional
	public void insert(UserDto user) {
		User userToSave = new User();
		BeanUtils.copyProperties(user, userToSave);
		this.userRepository.save(userToSave);
	}

	@Transactional
	public void update(UUID id, UserDto userUpdated) {
		UserDto user = findById(id);
		BeanUtils.copyProperties(userUpdated, user);

		User userToSave = this.userRepository.getReferenceById(id);
		BeanUtils.copyProperties(user, userToSave);
		this.userRepository.save(userToSave);
	}

	@Transactional
	public void deleteById(UUID id) {
		this.userRepository.deleteById(this.userRepository.getReferenceById(id).getId());
	}
}
