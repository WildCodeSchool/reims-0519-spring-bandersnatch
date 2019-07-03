package com.wildcodeschool.bandersnatch.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
class GameController {

    @PostMapping("/game")
    @ResponseBody
    public String game(HttpSession session, Model model, @RequestParam(required=false) String nickname, @RequestParam(required=false) String action) {
        if(session.getAttribute("nickname") == null) {
            // first time we get here : check nickname
            if(nickname == null || nickname.equals("")) {
                // invalid nickname : go back to home page
                return "redirect: /";
            }

            // register nickname in the session
            session.setAttribute("nickname", nickname);
        }

        if(action != null) {
            // we're playing : check the current action
            if(action.equals("win")) {
                session.setAttribute("win", true);
            }
            if(action.equals("lose")) {
                
            }
        }

        if(session.getAttribute("win") != null && session.getAttribute("win").equals(true)) {
            // we won : end of game
            return "win";
        }

        // we're still playing : show the current choice
        model.addAttribute("nickname", nickname);
        
           Object game;
		return  "<form action='/game' method='post'><input name='action' value='win'><button class='btn btn-primary my-1'>Get out of prison!</button></form>" +
                "<form action='/game' method='post'><input name='action' value='lose'><button class='btn btn-primary my-1'>Get out of prison!</button></form>";
        
    }

}