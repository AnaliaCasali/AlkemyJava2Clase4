package com.alkemy.java2.clase03.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Data
@Entity
@Slf4j
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

 @NotBlank (message = "Name is mandatory")
  private String name;

  @Email(message = "Email should be valid")
  private String email;

  @Size(min = 8, max = 20, message = "Password must be between 8 and 20 characters")
  private String password;

}