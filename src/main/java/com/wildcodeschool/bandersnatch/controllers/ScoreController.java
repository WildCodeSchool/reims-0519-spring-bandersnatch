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
        return ScoreRepository.selectAll();
    }

    @PostMapping("/scores")
    public String store(
        @RequestParam String nickname,
        @RequestParam (defaultValue = "0") int user_score
    ) {
        int idGeneratedByInsertion = ScoreRepository.insert(
            nickname,
            user_score
        );
        return "redirect:/scores";
    }
}