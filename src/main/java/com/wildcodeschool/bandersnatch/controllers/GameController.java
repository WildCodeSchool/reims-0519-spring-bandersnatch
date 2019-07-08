package com.wildcodeschool.bandersnatch.controllers;

import javax.servlet.http.HttpSession;

import com.wildcodeschool.bandersnatch.entities.Room;
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
            session.setAttribute("currentRoom", roomRepository.getRooms().get(0));
        }

        if(action != null) {
            // we're playing : check the current action
            Room nextRoom = null;
            int currentRoomId = ((Room)session.getAttribute("currentRoom")).getId();
           
            if(currentRoomId == 1) {
                if(action.equals("Left")) {
                    nextRoom = roomRepository.getRoomById(5);
                    // one day: nextRoom = currentRoom.getLeftRoom();
                }
                if(action.equals("Right")) {
                    nextRoom = roomRepository.getRoomById(2);
                    // one day: nextRoom = currentRoom.getRightRoom();
                }
            }

            if(currentRoomId == 2) {
                if(action.equals("Left")) {
                    nextRoom = roomRepository.getRoomById(5);
                }
                if(action.equals("Right")) {
                    nextRoom = roomRepository.getRoomById(3);
                }
            }

            if(currentRoomId == 3) {
                if(action.equals("Left")) {
                    nextRoom = roomRepository.getRoomById(4);
                }
                if(action.equals("Right")) {
                    nextRoom = roomRepository.getRoomById(4);
                }
            }

            if(currentRoomId == 4) {
                if(action.equals("Left")) {
                    nextRoom = roomRepository.getRoomById(2);
                }
                if(action.equals("Right")) {
                    nextRoom = roomRepository.getRoomById(3);
                }
            }

            if(currentRoomId == 5) {
                if(action.equals("Left")) {
                    nextRoom = roomRepository.getRoomById(7);
                }
                if(action.equals("Right")) {
                    nextRoom = roomRepository.getRoomById(6);
                }
            }

            if(currentRoomId == 6) {
                if(action.equals("Left")) {
                    return "gamewin";
                }
                if(action.equals("Right")) {
                    nextRoom = roomRepository.getRoomById(3);
                }
            }
            
            if(currentRoomId == 7) {
                if(action.equals("Left")) {
                    return "gamewin";
                }
                if(action.equals("Right")) {
                    nextRoom = roomRepository.getRoomById(6);
                }
            }

            if(currentRoomId == 8) {
                if(action.equals("Left")) {
                    nextRoom = roomRepository.getRoomById(9);
                }
                if(action.equals("Right")) {
                    nextRoom = roomRepository.getRoomById(10);
                }
            }

            if(currentRoomId == 9) {
                if(action.equals("Left")) {
                    nextRoom = roomRepository.getRoomById(7);
                }
                if(action.equals("Right")) {
                    nextRoom = roomRepository.getRoomById(10);
                }
            }


            if(currentRoomId == 10) {
            // victory
                
                return "result";
            }



            
            session.setAttribute("currentRoom", nextRoom);// salle courante = salle suivante
        }


        // we're still playing : show the current choice
        model.addAttribute("nickname", session.getAttribute("nickname"));
        model.addAttribute("currentRoom", session.getAttribute("currentRoom"));
        
            // "<form action='/game' method='post'><input name='action' value='win'><button class='btn btn-primary my-1'>Get out of prison!</button></form>" +
            // "<form action='/game' method='post'><input name='action' value='lose'><button class='btn btn-primary my-1'>Get out of prison!</button></form>";
        return "game";
    }
}