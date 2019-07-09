package com.wildcodeschool.bandersnatch.repositories;

import com.wildcodeschool.bandersnatch.entities.Room;
import java.util.ArrayList;
import java.util.List;

public class RoomRepository {

    private List<Room> rooms;

    public RoomRepository() {

        this.rooms = new ArrayList<Room>();

        rooms.add(new Room(1, "The Torture Room", new String[]{
            "You just arrived in the Room of Torture, lucky you :)",
            "Your new friend was waiting for you, his name is « Romano el CodMaster », he wants to keep your eyes open with giant forks, in front of a kind of « shiny window », with weird text written on it, for hours and for his own enjoyment.",
            "You need to escape as soon as possible!!!",
            "The door you came by is now locked, 2 choices in front of you. Hurry up, pick a door!!!"
        }));
        rooms.add(new Room(2, "The Remus Room", new String[]{
            "Someone his running all around this room with a weird big ball looking like a bean…",
            "His name is Nikolaï Huranoff, he wants you to play with him. Big and strong, you don’t want to offend him and you say yes, otherwise the risk is your head looks like the ball.",
            "After few hours, you’re exhausted and want to rest but Nikolaï does not…never...",
            "Quick!!! Run from this crazy guy, you have 2 possibilities, because your previous door you came by his now locked. Hurry up, take a pick!!!"
        }));
        rooms.add(new Room(3, "The Tattoo Room", new String[]{
            "After the door closes behind you, a strange man called Bryun caVANSny wants absolutely to tattoo you.",
            "You're nice so you say yes for a black darkhorse tatoo on your harm, but after 1 hour tattoo, you see you're getting a weird pink unicorn...",
            "Time to stop this mindness and leave, you need to pick one: left or right!!!"
        }));
        rooms.add(new Room(4, "The Veggie Room", new String[]{
            "Inside, you meet a strange woman, dressed like poisonIvy in Batman (I hope you saw the movie…), she his cooking a weird smelly soup in her chaudron;",
            "she looks nice and wants to share her diner with you. It is really nice of her but the smell and color are making you cry, and you would have tasted it but dead rats nearby the chaudron make you think otherwise…",
            "Time to leave!!! Quick, take one of the 2 doors, she is coming at you with a spoon!!!"
        }));
        rooms.add(new Room(5, "The Inception Room", new String[]{
            "In this room, all your senses are put to the test: the room is turning at 360°, chairs, tables, tools, everything is turning like in a washing machine...",
            "If you want to survive, avoid everything in your path and try to catch one of the 2 doors at the other side of the room: right or left!!!!"
        }));
        rooms.add(new Room(6, "The Nintendo Room", new String[]{
            "A Room full of Nintendo games, coolll!!!",
            "You meet the switch Master, Stephano Mario, he loves games, especially Pokemon and wants you to play with him and you accept, only 5 minutes and you leave.",
            "After checking your watch you see you played for 3 hours...",
            "Time to leave your new friend. Pick a door: right or left."
        }));
        rooms.add(new Room(7, "The Camilla Room", new String[]{
            "You just arrived in a bedroom, nice room and you hear someone is getting out of the shower.",
            "Oh my god, it's the Camilla Room!!!",
            "It's Camilla Parker Bowles, and she is loosing a towel on the floorrrr....",
            "Your eyes are burning and you're crying, you don't want to see this...",
            "Close your eyes and try to find a door: right or left!!!!"
        }));
        rooms.add(new Room(8, "The Ball Trap Room", new String[]{
            "In this room, you see a lot of plates fixed on the walls and crushed on the floor.",
            "Then you hear a detonation!!!!!",
            "This is the Ball Trap Hunter shooting, Cecilio Millerio.",
            "He is tired of shooting plates and your presence is making a little more fun for his hunting game.",
            "If you don't want to be his trophy, run fast and open one of the 2 doors at the end of the room."
        }));
        rooms.add(new Room(9, "The GoT Room", new String[]{
            "You're arriving in a simple room with a TV, a coach and 3 people sitten on it, the 2 other doors are behind the TV so you need to cross the people.",
            "But they are speaking of the last episode of the last season of Game Of Thrones...",
            "Unfortunately, you didn't see it and you DON'T want to hear what's happening...",
            "Hurry up, close your ears and get out of here!!!!"
        }));
        rooms.add(new Room(10, "Exit", new String[]{
            "Yes, you went out!!!! Great :)",
            "Your friends Sherlock & Watson are here.",
            "Now get your ass out of that city and thanks for playing :)"
        }));
    }

    public List<Room> getRooms() {

        return rooms;
    }

    
    public Room getRoomById(int id) {

        for(Room room : rooms) {

            if(room.getId() == id) {

                return room;
            }
        }
        return null;
    }
}