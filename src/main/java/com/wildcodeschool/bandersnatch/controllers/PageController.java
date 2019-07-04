package com.wildcodeschool.bandersnatch.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
class PageController {

    @GetMapping("/")
    public String index(Model model) {
        return "index";
    }
    @GetMapping("/scores")
    public String scores(Model model) {
        return "scores";
    }

    @GetMapping("/result")
    public String result(Model model) {
        return "result";
    }

}