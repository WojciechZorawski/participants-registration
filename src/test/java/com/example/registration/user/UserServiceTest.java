package com.example.registration.user;

import static com.example.registration.user.EntityToDtoComparatorHelper.compareUserEntityToUserResponseDto;
import static com.example.registration.user.UserFactoryFaker.getValidUserEntity;
import static com.example.registration.user.UserFactoryFaker.getValidUserRequestDto;
import static com.example.registration.user.UserFactoryFaker.toEntity;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

  @InjectMocks
  private UserService userService;
  @Mock
  private UserRepository userRepository;

  @Test
  void createUserReturnsProperUser() {
    UserRequestDTO requestDto = getValidUserRequestDto();

    when(userRepository.save(any(User.class))).thenReturn(toEntity(requestDto));

    UserResponseDTO createdUser = userService.createUser(requestDto);
    compareUserEntityToUserResponseDto(toEntity(requestDto), createdUser);
  }

  @Test
  void createUserEntityReturnsProperUser() {
    User userEntity = getValidUserEntity();

    when(userRepository.save(any(User.class))).thenReturn(userEntity);

    User createdUser = userService.createUserEntity(userEntity);
    assertEquals(userEntity.getName(), createdUser.getName());
    assertEquals(userEntity.getLastName(), createdUser.getLastName());
    assertEquals(userEntity.getEmail(), createdUser.getEmail());
  }
}
