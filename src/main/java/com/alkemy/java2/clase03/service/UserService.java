package com.alkemy.java2.clase03.service;


import com.alkemy.java2.clase03.model.User;

import java.util.List;

public interface UserService {
  User createUser(User user);
  List<User> getAllUsers();
  User getUserById(Long id);
  User updateUser(Long id, User user);
  void deleteUser(Long id);
}