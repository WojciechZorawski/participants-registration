package com.example.registration.user;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

  private final UserService userService;

  @PostMapping
  public UserResponseDTO createUser(@RequestBody final UserRequestDTO newUser) {
    UserResponseDTO createdUser = userService.createUser(newUser);
    return createdUser;
  }

}