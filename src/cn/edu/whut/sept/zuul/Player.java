package cn.edu.whut.sept.zuul;

import room.Absroom;

import java.util.HashMap;

public class Player {
    private Absroom currentRoom;
    private Absroom lastRoom;
    private  Integer Maximum_load=3;
    private HashMap<String,Integer> baggage=null;
    public Player() {
        this.baggage=new HashMap<>();
    }

    public Integer getMaximum_load() {
        return Maximum_load;
    }

    public void setMaximum_load(Integer maximum_load) {
        Maximum_load = maximum_load;
    }

    public HashMap<String, Integer> getBaggage() {
        return baggage;
    }

    public void setBaggage(HashMap<String, Integer> baggage) {
        this.baggage = baggage;
    }
    public Absroom getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(Absroom currentRoom) {
        this.currentRoom = currentRoom;
    }

    public Absroom getLastRoom() {
        return lastRoom;
    }

    public void setLastRoom(Absroom lastRoom) {
        this.lastRoom = lastRoom;
    }

}
