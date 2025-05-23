package com.deep.tripease.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/home")
    public ResponseEntity<String> home(){
        return new ResponseEntity<>("Home of tripe", HttpStatus.OK);
    }
}
