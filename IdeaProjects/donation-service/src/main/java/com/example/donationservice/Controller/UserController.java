package com.example.donationservice.Controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @PostMapping("ping")
    public String ping(){
        return "pong!!!";
    }
}
