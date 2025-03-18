package com.food.map.user.controller;

import com.food.map.user.dto.User;
import com.food.map.user.dto.UserReq;
import com.food.map.user.mapper.UserMapper;
import com.food.map.user.service.UserService;
import jakarta.validation.Valid;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:*")
public class UserController {
    private final UserService service;
    private final UserMapper mapper;

    @GetMapping("/v1/user/{id}")
    public User getUser(@PathVariable Long id){
        return service.get(id);
    }

    @GetMapping("/v1/all/user")
    public List<User> getAllUser(){
        return service.getAll();
    }

    @PostMapping("/v1/user")
    public User save(@Valid @RequestBody UserReq req){
        var user = mapper.to(req);

       return service.save(user);
    }
}
