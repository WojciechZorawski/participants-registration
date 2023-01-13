package com.example.registration.user;

import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Builder
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class UserResponseDTO {

  private String name;
  private String lastName;
  private String email;
  private UUID userNumber;

  public UserRequestDTO toRequestDto() {
    return UserRequestDTO.builder()
                         .name(name)
                         .lastName(lastName)
                         .email(email)
                         .build();
  }
}
