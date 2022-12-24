package cn.edu.whut.sept.zuul;

import java.util.Set;
import java.util.HashMap;

public class Room
{
    private String description;

    private HashMap<String, Room> exits;//储存<方位，房间>

    //关于描述的构造函数
    public Room(String description)
    {
        this.description = description;
        //初始化hash表
        exits = new HashMap<>();
    }

    public void setExit(String direction, Room neighbor)
    {
        exits.put(direction, neighbor);
    }

    public String getShortDescription()
    {
        return description;
    }

    public String getLongDescription()
    {
        return "You are " + description + ".\n" + getExitString();
    }

    //返回可以到达的方向
    private String getExitString()
    {
        String returnString = "Exits:";
        Set<String> keys = exits.keySet();
        for(String exit : keys) {
            returnString += " " + exit;
        }
        return returnString;
    }
    //相邻房间查找
    public Room getExit(String direction)
    {
        return exits.get(direction);
    }
}


