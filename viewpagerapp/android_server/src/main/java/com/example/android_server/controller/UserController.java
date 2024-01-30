package com.example.android_server.controller;

import com.example.android_server.model.User;
import com.example.android_server.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Log4j2
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserController {
    private final UserRepository userRepository;

    @GetMapping("/home")
    public String home(){
        return "home";
    }
    @GetMapping("getUser/{id}")
    public User getUser(@PathVariable Long id){
        log.info("id="+id);
        return userRepository.findById(id).get();
    }

    @GetMapping("getUser/{username}")
    public User getUser(@PathVariable String username){
        log.info("username="+username);
        return userRepository.findByUsername(username);
    }
    @PostMapping("/insert")
    public String insert(@RequestBody User user){
        log.info(user);
        userRepository.save(user);
        return "user data save";
    }
    @GetMapping("/list")
    public List<User> getList(){
        List<User> list=userRepository.findAll();
        return list;
    }
    @GetMapping("/map")
    public Map<String, List<User>> getMap(){
        Map<String, List<User>> map=new HashMap<>();
        map.put("users", userRepository.findAll());
        return map;
    }
}
