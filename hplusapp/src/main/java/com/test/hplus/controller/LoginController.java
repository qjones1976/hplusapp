package com.test.hplus.controller;

import com.test.hplus.ApplicationException;
import com.test.hplus.beans.Login;
import com.test.hplus.beans.User;
import com.test.hplus.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    @Autowired
    UserRepository userRepository;

    @PostMapping("/login")
    public String login(@ModelAttribute("login")Login login) {

        User user = userRepository.searchByName(login.getUsername());
        if (user == null) {
            throw new ApplicationException("User not found");
        }
        return "search";
    }

    @ExceptionHandler
    public String handleException() {
        System.out.println("in exception handler of login controller");
        return "error";
    }
}