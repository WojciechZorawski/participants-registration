package com.example.registration.user;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EntityToDtoComparatorHelper {

  public static void compareUserEntityToUserResponseDto(User user, UserResponseDTO userResponseDto) {
    assertEquals(user.getName(), userResponseDto.getName());
    assertEquals(user.getLastName(), userResponseDto.getLastName());
    assertEquals(user.getEmail(), userResponseDto.getEmail());
  }
}
