package room;

import java.util.HashMap;
/**
 * 生成lab
 */
public class LabBuilder implements RoomBuilderFactory{
    public Absroom createRoom() {
        int number = 4;
        HashMap<String, Integer> objects = new HashMap<>();
        objects.put("computer",1);
        String description="in a computing lab";
        return new CommonRoom(objects, number, description);
    }
}
