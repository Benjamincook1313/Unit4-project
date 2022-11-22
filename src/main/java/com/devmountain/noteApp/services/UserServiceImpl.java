package com.devmountain.noteApp.services;

import com.devmountain.noteApp.dtos.UserDto;
import com.devmountain.noteApp.entities.User;
import com.devmountain.noteApp.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

  @Autowired
  private UserRepo userRepo;

  // Grabs Bean for config file
  @Autowired
  private PasswordEncoder passwordEncoder;

  @Override
  @Transactional
  public List<String> addUser(UserDto userDto){
    List<String> resp = new ArrayList<>();
    User user = new User(userDto);
    userRepo.saveAndFlush(user);
    resp.add("User added Successfully");
    return resp;
  }

  @Override
  public List<String> userLogin(UserDto userDto){
    List<String> resp = new ArrayList<>();
    Optional<User> userOptional = userRepo.findByUsername(userDto.getUsername());
    if(userOptional.isPresent() && passwordEncoder.matches(userDto.getPassword(), userOptional.get().getPassword())){
      resp.add("User Login Successful");
    }else {
      resp.add("Username or Password incorrect");
    }
    return resp;
  }

}
