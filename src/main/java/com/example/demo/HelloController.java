package com.example.demo;

import java.util.List;
import javax.xml.ws.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class HelloController {
   @Autowired UserSevice userSevice;

  @RequestMapping("/")
  public String index() {
    return "Greetings from Spring Boot!";
  }

  @RequestMapping("/user")
  public ResponseEntity<List<User>> getUsers(){
    return ResponseEntity.ok(userSevice.getAllUsers());
  }

}