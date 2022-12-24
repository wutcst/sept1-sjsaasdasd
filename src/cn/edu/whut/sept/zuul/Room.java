package cn.edu.whut.sept.zuul;

import java.util.HashMap;
import java.util.Set;

public class Room {

    private String description;

    private HashMap<String, Room> exits;

    //关于描述的构造函数
    public Room(String description) {
        this.description = description;
        //初始化hash表
        exits = new HashMap<>();
    }

    public void setExit(String direction, Room neighbor) {
        exits.put(direction, neighbor);
    }

    public String getShortDescription() {
        return description;
    }

    public String getLongDescription() {
        return "You are " + description + ".\n" + getExitString();
    }

    private String getExitString() {
        String returnString = "Exits:";
        Set<String> keys = exits.keySet();
        for (String exit : keys) {
            returnString += " " + exit;
        }
        return returnString;
    }

    public Room getExit(String direction) {
        return exits.get(direction);
    }
}


