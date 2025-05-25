package com.example.Vaccino.Controller;

import com.example.Vaccino.Model.User;
import com.example.Vaccino.Service.UserService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    UserService US;

   @PostMapping("/register")
   public ResponseEntity register(@RequestBody User u){
       try{
           US.register(u);
           return new ResponseEntity("Registered Successfully!", HttpStatus.OK);
       }catch (Exception e){
           return new ResponseEntity(e.getMessage(), HttpStatus.OK);
       }

   }

    @PostMapping("/login")
    public String login(@RequestBody User u) {
        return US.verify(u);
    }
}