package com.codexiodevcamp.jwtwebtokenapp.controller;

import com.codexiodevcamp.jwtwebtokenapp.domain.entities.User;
import com.codexiodevcamp.jwtwebtokenapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
public class UserController {

    private final UserService userService;

    @Autowired
    UserController(UserService userService) {

        this.userService = userService;
    }

    @RequestMapping(value = "/register",method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public Map<String,Object> registerUser(@RequestBody User user) {
        Map<String,Object> result = new HashMap<>();
      if(this.userService.registerUser(user)){
          result.put("message","success");
      }else {
          result.put("message","error");
      }

       return result;
    }

    @RequestMapping(value = "/login",method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public String loginUser(HttpServletRequest request) {
      return null;
    }
}

