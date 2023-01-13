package com.example.registration.user;

import java.util.UUID;
import javax.validation.constraints.Email;
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
public class UserRequestDTO {

  private String name;
  private String lastName;
  @Email
  private String email;

  public User toEntity() {
    return User.builder()
               .name(name)
               .lastName(lastName)
               .email(email)
               .userNumber(UUID.randomUUID())
               .build();
  }
}

