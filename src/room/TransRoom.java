package room;

import java.util.HashMap;

public class TransRoom extends Absroom{
    private int number;
    public TransRoom(int num, String description){
        super();
        this.setTransfer(true);
        this.exits = new HashMap<>();
        this.objects=new HashMap<>();
        this.number=num;
        this.setDescription(description);
    }
}
