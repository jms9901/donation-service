package com.example.donationservice.Controller;

import com.example.donationservice.Dto.UserRequest;
import com.example.donationservice.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

// 내 콩 어디나 놓지....?

@RestController
public class UserController {
    private final UserService userService;

    @Autowired // DI 콩콩콩콩
    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("ping")
    public String ping(){
        return "pong!!!";
    }

    @PostMapping("/api/join_user")
    public Long register(@RequestBody UserRequest req){

        Long createdUserId = userService.register(req);

        return createdUserId;

    }


}
