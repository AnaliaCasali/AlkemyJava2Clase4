package com.alkemy.java2.clase03.repository;

import com.alkemy.java2.clase03.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {}