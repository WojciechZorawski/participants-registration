package com.example.registration.user;

import com.github.javafaker.Faker;
import java.time.ZoneId;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class UserFactoryFaker {

  private static final Faker FAKER = Faker.instance(new Random(81));

  public static User toEntity(UserRequestDTO requestDto) {
    return User.builder()
               .name(requestDto.getName())
               .lastName(requestDto.getLastName())
               .email(requestDto.getEmail())
               .userNumber(UUID.randomUUID())
               .build();
  }

  public static UserResponseDTO toResponseDto(UserRequestDTO requestDto) {
    return UserResponseDTO.builder()
                          .name(requestDto.getName())
                          .lastName(requestDto.getLastName())
                          .email(requestDto.getEmail())
                          .userNumber(UUID.randomUUID())
                          .build();
  }

  public static User getValidUserEntity() {
    String name = FAKER.name().name();
    return User.builder()
               .id(1L)
               .name(name)
               .lastName(FAKER.name().lastName())
               .email("test@test.com")
               .userNumber(UUID.randomUUID())
               .build();
  }

  public static UserResponseDTO getValidUserResponseDto() {
    String name = FAKER.name().name();
    return UserResponseDTO.builder()
                          .name(name)
                          .lastName(FAKER.name().lastName())
                          .email("test@test.com")
                          .userNumber(UUID.randomUUID())
                          .build();
  }

  public static UserRequestDTO getValidUserRequestDto() {
    return UserRequestDTO.builder()
                         .name(FAKER.name().name())
                         .lastName(FAKER.name().lastName())
                         .email("test@test.com")
                         .build();
  }

  public static UserRequestDTO getInvalidUserRequestDto() {
    return UserRequestDTO.builder()
                         .name(FAKER.name().name())
                         .lastName(FAKER.name().lastName())
                         .email(FAKER.name().bloodGroup())
                         .build();
  }
}