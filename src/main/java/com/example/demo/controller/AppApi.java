package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class AppApi {

    public AppApi() {
    }

    @GetMapping("/forAll")
    public String forAllStart(Principal principal){
        return "Start page for all";
    }

    @GetMapping("/forAllUser")
    public String forAll(Principal principal){
        if (principal == null)
            return "Hello unknown user";
        return "Hello " + principal.getName();
    }

    @GetMapping("/forAdmin")
    public String forAdmin(Principal principal){
        return "Hello admin " + principal.getName();
    }

    @GetMapping("/forUser")
    public String forUser(Principal principal){
        return "Hello user " + principal.getName();
    }

    @GetMapping("/papa")
    public String forAll(){
        return "papa";
    }

}
