package dev.joaobertholino.apiresttest.service;

import dev.joaobertholino.apiresttest.dtos.UserDto;
import dev.joaobertholino.apiresttest.models.User;
import dev.joaobertholino.apiresttest.repositories.UserRepository;
import dev.joaobertholino.apiresttest.services.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

	@InjectMocks
	private UserService userService;

	@Mock
	private UserRepository userRepository;

	@Test
	void findAllTest() {
		User userOne = new User("Joao", "Bertholino", "joao@email.com");
		User userTwo = new User("Ellen", "Sthefane", "ellen@email.com");
		User userThree = new User("Nicolas", "Emanuel", "nicolas@email.com");
		List<User> userList = List.of(userOne, userTwo, userThree);
		Mockito.when(this.userRepository.findAll()).thenReturn(userList);

		List<UserDto> userDtoList = this.userService.findAll();

		Assertions.assertEquals(3, userDtoList.size());
		userDtoList.forEach(actual -> {
			Assertions.assertNotNull(actual);
			Assertions.assertInstanceOf(UserDto.class, actual);
		});
	}

	@Test
	void findById() {
		UUID id = UUID.randomUUID();
		User user = new User("Joao", "Bertholino", "joao@email.com");
		Mockito.when(this.userRepository.findById(id)).thenReturn(Optional.of(user));

		UserDto userDto = this.userService.findById(id);

		Assertions.assertNotNull(userDto);
		Assertions.assertEquals(userDto.getFirstName(), user.getFirstName());
		Assertions.assertEquals(userDto.getLastName(), user.getLastName());
		Assertions.assertEquals(userDto.getEmail(), user.getEmail());
	}

}
