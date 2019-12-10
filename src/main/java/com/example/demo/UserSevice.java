package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserSevice {

  @Autowired
  UserRepository userRepository;

  public List<User> getAllUsers(){
    List<User> userList = new ArrayList<>();

    userRepository.findAll().forEach(userList::add);

    return  userList;
  }
}
