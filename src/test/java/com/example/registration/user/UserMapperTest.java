package com.example.registration.user;

import static com.example.registration.user.UserFactoryFaker.getValidUserEntity;
import static com.example.registration.user.UserFactoryFaker.getValidUserRequestDto;
import static com.example.registration.user.UserFactoryFaker.getValidUserResponseDto;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class UserMapperTest {

  @Test
  void shouldMapRequestDtoToEntity() {
    UserRequestDTO userRequestDto = getValidUserRequestDto();
    User userEntity = userRequestDto.toEntity();
    assertEquals(userRequestDto.getName(), userEntity.getName());
    assertEquals(userRequestDto.getLastName(), userEntity.getLastName());
    assertEquals(userRequestDto.getEmail(), userEntity.getEmail());
  }

  @Test
  void shouldMapEntityToResponseDto() {
    User userEntity = getValidUserEntity();
    UserResponseDTO userResponseDto = userEntity.toResponseDto();
    assertEquals(userEntity.getName(), userResponseDto.getName());
    assertEquals(userEntity.getLastName(), userResponseDto.getLastName());
    assertEquals(userEntity.getEmail(), userResponseDto.getEmail());
  }

  @Test
  void shouldMapResponseDtoToRequestDto() {
    UserResponseDTO userResponseDto = getValidUserResponseDto();
    UserRequestDTO userRequestDto = userResponseDto.toRequestDto();
    assertEquals(userResponseDto.getName(), userRequestDto.getName());
    assertEquals(userResponseDto.getLastName(), userRequestDto.getLastName());
    assertEquals(userResponseDto.getEmail(), userRequestDto.getEmail());
  }
}