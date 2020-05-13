package com.test.hplus.controller;

import com.test.hplus.beans.Login;
import com.test.hplus.beans.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.Arrays;
import java.util.List;

@Controller
public class HomeController {

    @GetMapping("/home")
    public String goHome() {
        System.out.println("I'm in home");

        return "index";
    }

    @GetMapping("/goToSearch")
    public String goToSearch() {
        System.out.println("going to search");
        return "search";
    }

    @GetMapping("/goToLogin")
    public String goToLogin() {
        System.out.println("going to login");
        return "login";
    }

    @GetMapping("/goToRegistration")
    public String goToRegistration() {
        System.out.println("going to register");
        return "register";
    }

 }
