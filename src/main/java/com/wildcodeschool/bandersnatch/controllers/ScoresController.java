package com.wildcodeschool.bandersnatch.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

import com.wildcodeschool.bandersnatch.entities.Scores;
import com.wildcodeschool.bandersnatch.repositories.ScoresRepository;
import org.springframework.ui.Model;
import java.util.List;

@Controller
@ResponseBody
public class ScoresController {

  

@PostMapping("/scores/{id}")
@ResponseStatus(HttpStatus.CREATED)
public Scores store(
    @RequestParam String nickname,
    @RequestParam (defaultValue = "0") int user_score) {
    int idGeneratedByInsertion = ScoresRepository.insert(
        nickname,
        user_score
    );
    return ScoresRepository.selectById(idGeneratedByInsertion);
    }
}