package com.example.registration.user;

import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
@RequiredArgsConstructor
public class UserService {

  private final UserRepository userRepository;

  public UserResponseDTO createUser(@Valid final UserRequestDTO newUser) {
    User userEntity = newUser.toEntity();
    User save = createUserEntity(userEntity);
    return save.toResponseDto();
  }

  public User createUserEntity(User userEntity) {
    User save = userRepository.save(userEntity);
    return save;
  }
}
