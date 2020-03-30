package com.test.hplus.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

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
}
