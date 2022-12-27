package room;

import java.util.HashMap;

public class TheaterBuilder implements RoomBuilderFactory{
    public Absroom createRoom() {
        int number = 2;
        HashMap<String, Integer> objects = new HashMap<>();
        objects.put("stage",100);
        objects.put("doll",1);
        String description="in a lecture theater";
        return new CommonRoom(objects, number, description);
    }
}
