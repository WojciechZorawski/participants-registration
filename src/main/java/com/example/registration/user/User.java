package com.example.registration.user;

import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "user_account")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {


  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String name;
  private String lastName;
  private String email;
  private UUID userNumber;

  public UserResponseDTO toResponseDto() {
    return UserResponseDTO.builder()
                          .name(name)
                          .lastName(lastName)
                          .email(email)
                          .userNumber(userNumber)
                          .build();
  }
}
