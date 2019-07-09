package com.wildcodeschool.bandersnatch.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wildcodeschool.bandersnatch.entities.Score;
import com.wildcodeschool.bandersnatch.repositories.ScoreRepository;

import java.util.List;

@Controller
public class ScoreController {

    @GetMapping("/scores")
    @ResponseBody
    public List<Score> getScores() {
        return ScoreRepository.selectAll();
    }
}