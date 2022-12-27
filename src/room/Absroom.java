package room;

import java.util.HashMap;
import java.util.Set;

/**
 * 抽象房间类
 */
public abstract class Absroom {
    private String description;
    protected HashMap<String, Absroom> exits;
    protected HashMap<String,Integer> objects=null;
    public void setDescription(String name){
        this.description = name;
    }

    public void setExit(String direction, Absroom neighbor)
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

    private String getExitString()
    {
        String returnString = "Exits:";
        Set<String> keys = exits.keySet();
        for(String exit : keys) {
            returnString += " " + exit;
        }
        return returnString;
    }

    public Absroom getExit(String direction)
    {
        return exits.get(direction);
    }

    public void showObjects() {
        //判断有无物品
        if(this.objects == null || this.objects.isEmpty()){
            System.out.println("Eh……There is nothing……");
        } else {
            String returnString = "Objects:";
            Set<String> keys = objects.keySet();
            for(String exit : keys) {
                returnString += " " + exit;
            }
            System.out.println(returnString);
        }
    }
}

