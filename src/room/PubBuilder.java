package room;

import java.util.HashMap;

public class PubBuilder implements RoomBuilderFactory{
    public Absroom createRoom() {
        int number = 3;
        HashMap<String, Integer> objects = new HashMap<>();
        objects.put("wine",1);
        String description="in the campus pub";
        return new CommonRoom(objects, number, description);
    }
}
