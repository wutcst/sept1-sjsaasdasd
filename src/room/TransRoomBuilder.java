package room;

import java.util.HashMap;

public class TransRoomBuilder implements RoomBuilderFactory {
    /**
     * @return
     */
    @Override
    public Absroom createRoom() {
        int number = 6;
        String description="Oh!You will be transported to a random room.";
        return new TransRoom(number, description);

    }
}
