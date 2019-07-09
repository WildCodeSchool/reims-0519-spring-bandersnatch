package com.wildcodeschool.bandersnatch.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wildcodeschool.bandersnatch.entities.Score;
import com.wildcodeschool.bandersnatch.repositories.ScoreRepository;

import java.util.List;

@Controller
public class ScoreController {

    @GetMapping("/scores")
    public String getScores(Model model) {
        model.addAttribute("scores", ScoreRepository.selectAll());
        return "result";
    }
}