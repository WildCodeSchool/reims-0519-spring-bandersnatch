package com.wildcodeschool.bandersnatch.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

import com.wildcodeschool.bandersnatch.entities.Score;
import com.wildcodeschool.bandersnatch.repositories.ScoreRepository;

import java.util.List;

@Controller
public class ScoreController {

    @GetMapping("/scores")
    @ResponseBody
    public List<Score> getScores() {
        return ScoreRepository.selectScores();
    }

    @PostMapping("/scores")
    public String store(
        @RequestParam String nickname,
        @RequestParam (defaultValue = "0") int userScore
    ) {
        int idGeneratedByInsertion = ScoreRepository.insert(
            nickname,
            userScore
        );
        return "redirect:/scores";
    }
}