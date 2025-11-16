package com.example.Oauth2Practice;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    public String greet(){
        return "Hello, aranck this is working!";
    }
}
