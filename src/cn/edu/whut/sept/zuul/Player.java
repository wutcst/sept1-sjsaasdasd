package cn.edu.whut.sept.zuul;

import room.Absroom;

import java.util.HashMap;
import java.util.Set;

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

    public boolean isOverWeight(Integer weight) {
        Set<String> keys=baggage.keySet();
        Integer totalWeight=0;
        for(String object:keys){
            totalWeight+=baggage.get(object);
        }
        totalWeight+=weight;
        if(this.Maximum_load>=totalWeight){
            return false;
        }else{
            return true;
        }
    }

    public void setObject(String description, Integer weight) {
        this.baggage.put(description,weight);
    }

    public Integer getObject(String description) {
        return baggage.get(description);
    }

    public void dropObject(String description) {
        this.baggage.remove(description);
    }
    public Integer showBaggage() {
        Integer totalWeight=0;
        //判断有无物品
        if(this.baggage == null || this.baggage .isEmpty()){
            System.out.println("Eh……You have nothing……");
        } else {
            String returnString = "Baggage:";
            Set<String> keys = baggage .keySet();
            for(String object : keys) {
                totalWeight+=baggage .get(object);
                returnString += " " + object;
            }
            System.out.println(returnString);
        }
        return totalWeight;
    }
}
