package com.wildcodeschool.bandersnatch.repositories;

import com.wildcodeschool.bandersnatch.entities.Room;

import java.util.ArrayList;
import java.util.List;

public class RoomRepository {
    private List<Room> room;

    public RoomRepository() {
        this.room = new ArrayList<Room>();
        room.add(new Room(1, "1"));
        room.add(new Room(2, "2"));
        room.add(new Room(3, "3"));
        room.add(new Room(4, "4"));
        room.add(new Room(5, "5"));
        room.add(new Room(6, "6"));

    }

    public List<Room> getRoom() {
        return room;
    }

    public Room getRoomById(int id) {
        for(Room room : room) {
            if(room.getId() == id) {
                return room;
            }
        }

        return null;
    }
}