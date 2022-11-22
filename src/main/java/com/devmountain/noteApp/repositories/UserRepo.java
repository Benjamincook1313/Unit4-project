package com.devmountain.noteApp.repositories;


import com.devmountain.noteApp.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User, Long> {
  Optional<User> findByUsername(String username);

}