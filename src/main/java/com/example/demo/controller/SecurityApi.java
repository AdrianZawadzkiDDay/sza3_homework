package com.example.demo.controller;

import com.example.demo.model.AppUser;
import com.example.demo.repository.AppUserRepo;
import com.example.demo.service.UserServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class SecurityApi {

    private UserServiceImpl userServiceImpl;
    private AppUserRepo appUserRepo;

    public SecurityApi(UserServiceImpl userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }

    @RequestMapping("/login")
    public String login() {
        return "login";
    }


    @RequestMapping("/singup")
    public ModelAndView singup(){
        return new ModelAndView("registration", "user", new AppUser());
    }

    @RequestMapping("/register")
    public ModelAndView registration(AppUser appUser, HttpServletRequest httpServletRequest){
        if (userServiceImpl.addUser(appUser, httpServletRequest)){
            return new ModelAndView("redirect:/login");
        }
        else {
            return new ModelAndView("registrationerror");
        }
    }

    @RequestMapping("/verifytoken")
    public ModelAndView registerUser(String token)
    {
        if(userServiceImpl.verifytoken(token)) {
            return new ModelAndView("redirect:/login");
        }
        else {
            return new ModelAndView("redirect:/login");
        }
    }

    @RequestMapping("/verifyadmin")
    public ModelAndView registerAdmin(String token)
    {
        if(userServiceImpl.verifytokenAdmin(token)) {
            return new ModelAndView("redirect:/login");
        }
        return new ModelAndView("redirect:/login");
    }

}
