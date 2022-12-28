package room;

import java.util.HashMap;
/**
 * 生成office
 */
public class OfficeBuilder implements RoomBuilderFactory {
    public Absroom createRoom() {
        int number = 5;
        HashMap<String, Integer> objects = new HashMap<>();
        objects.put("book",1);
        String description="in the computing admin office";
        return new CommonRoom(objects, number, description);
    }
}
