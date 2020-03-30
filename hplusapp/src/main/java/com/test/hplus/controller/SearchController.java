package com.test.hplus.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SearchController {

    @GetMapping("/search")
    public String search(@RequestParam("search") String search, Model model) {
        System.out.println("search");
        System.out.println("search: " + search);
        return "search";
    }
}
