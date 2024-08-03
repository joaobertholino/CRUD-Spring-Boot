package dev.joaobertholino.apiresttest.controllers;

import dev.joaobertholino.apiresttest.dtos.UserDto;
import dev.joaobertholino.apiresttest.models.User;
import dev.joaobertholino.apiresttest.services.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "/users")
public class UserController {
	private final UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping(value = "/all")
	public ResponseEntity<List<UserDto>> findAll() {
		List<UserDto> resultList = this.userService.findAll().stream().map(user -> new UserDto(user)).toList();
		return ResponseEntity.status(HttpStatus.OK).body(resultList);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<UserDto> findById(@PathVariable UUID id) {
		UserDto userDto = new UserDto();
		BeanUtils.copyProperties(this.userService.findById(id), userDto);
		return ResponseEntity.status(HttpStatus.OK).body(userDto);
	}

	@PostMapping(value = "/insert")
	public ResponseEntity<UserDto> insert(@RequestBody UserDto userDto) {
		User user = new User();
		BeanUtils.copyProperties(userDto, user);
		this.userService.insert(user);
		return ResponseEntity.status(HttpStatus.CREATED).body(userDto);
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<UserDto> update(@PathVariable UUID id, @RequestBody UserDto userUpdated) {
		this.userService.update(id, userUpdated);
		return ResponseEntity.status(HttpStatus.OK).body(userUpdated);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable UUID id) {
		this.userService.deleteById(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
}
