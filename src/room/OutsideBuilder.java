package room;

import java.util.HashMap;

public class OutsideBuilder implements RoomBuilderFactory{
    /**
     * @return 返回一个抽象类
     */
    @Override
    public Absroom createRoom() {
        int number = 1;
        HashMap<String, Integer> objects = new HashMap<>();
        String description="outside the main entrance of the university";
        return new CommonRoom(objects, number, description);
    }
}
