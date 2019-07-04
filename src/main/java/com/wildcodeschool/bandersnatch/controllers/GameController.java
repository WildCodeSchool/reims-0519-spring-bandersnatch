package com.wildcodeschool.bandersnatch.controllers;

import javax.servlet.http.HttpSession;

import com.wildcodeschool.bandersnatch.repositories.RoomRepository;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
class GameController {

    private static RoomRepository roomRepository = new RoomRepository();

    @PostMapping("/game")
    public String game(HttpSession session, Model model, @RequestParam(required=false) String nickname, @RequestParam(required=false) String action) {
        if(session.getAttribute("nickname") == null) {
            // first time we get here : check nickname
            if(nickname == null || nickname.equals("")) {
                // invalid nickname : go back to home page
                return "redirect:/";
            }

            // register nickname in the session
            session.setAttribute("nickname", nickname);
            session.setAttribute("currentRoom", roomRepository.getRoom().get(0));
        }

        if(action != null) {
            // we're playing : check the current action
            if(action.equals("Left")) {
                session.setAttribute("win", true); //salle courante = salle left
            }
            if(action.equals("Right")) { // salle courante = salle right
                
            }
        }

        if(session.getAttribute("win") != null && session.getAttribute("win").equals(true)) {
            // we won : end of game
            session.setAttribute("currentRoom", roomRepository.getRoom().get(0));
            return "result";
        }

        // we're still playing : show the current choice
        model.addAttribute("nickname", session.getAttribute("nickname"));
        model.addAttribute("currentRoom", session.getAttribute("currentRoom"));
        
            // "<form action='/game' method='post'><input name='action' value='win'><button class='btn btn-primary my-1'>Get out of prison!</button></form>" +
            // "<form action='/game' method='post'><input name='action' value='lose'><button class='btn btn-primary my-1'>Get out of prison!</button></form>";
        return "game";
    }
}