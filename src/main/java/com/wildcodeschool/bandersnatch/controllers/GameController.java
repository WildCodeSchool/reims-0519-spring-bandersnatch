package com.wildcodeschool.bandersnatch.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
class PageController {

    @GetMapping("/")
    public String index(Model model) {
        return "index";
    }

    @GetMapping("/game")
    public String game(Model model) {
        return "game";
    }

    @GetMapping("/result")
    public String result(Model model) {
        return "result";
    }

    @RequestMapping("/game")
public class gamertag {

    @RequestMapping(method = RequestMethod.GET)
    public String affichername(final ModelMap pModel, 
                @RequestParam(value="nickname") final String pnickname) {

        pModel.addAttribute("nickname", pnickname);
        return "name";
    }
}
} 