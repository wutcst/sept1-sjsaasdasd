package room;

import java.util.HashMap;

public class CommonRoom extends Absroom{
    private int number;
    public CommonRoom(HashMap<String, Integer> object, int num,String description){
        super();
        this.exits = new HashMap<>();
        this.objects=object;
        this.number=num;
        this.setDescription(description);
    }
}
