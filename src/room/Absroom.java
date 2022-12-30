package room;

import java.util.HashMap;
import java.util.Set;

/**
 * 抽象房间类
 */
public abstract class Absroom {


    private boolean isTransfer;
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
    public boolean isTransfer() {
        return isTransfer;
    }
    public void setTransfer(boolean transfer) {
        isTransfer = transfer;
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

    public Integer showObjects() {
        Integer totalWeight=0;
        //判断有无物品
        if(this.objects == null || this.objects.isEmpty()){
            System.out.println("Eh……There is nothing……");
        } else {
            String returnString = "Objects:";
            Set<String> keys = objects.keySet();
            for(String object : keys) {
                totalWeight+=objects.get(object);
                returnString += " " + object;
            }
            System.out.println(returnString);
        }
        return totalWeight;
    }
    public Integer getObject(String description){
        return objects.get(description);
    }

    public void dropObject(String description) {
        this.objects.remove(description);
    }

    public void setObject(String description, Integer weight) {
        this.objects.put(description,weight);
    }
}

