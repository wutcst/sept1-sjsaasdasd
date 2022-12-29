package room;

import org.junit.jupiter.api.Test;
import room.*;

class RoomTest {
    private RoomBuilderFactory factory1=new LabBuilder();
    private RoomBuilderFactory factory2=new TransRoomBuilder();
    @Test
    void isTransfer() {
        Absroom commanRoom=factory1.createRoom();
        Absroom transRoom=factory2.createRoom();
        commanRoom.isTransfer();
        transRoom.isTransfer();
    }

    @Test
    void showObjects() {
        Absroom commanRoom=factory1.createRoom();
        Absroom transRoom=factory2.createRoom();
        commanRoom.showObjects();
        transRoom.showObjects();
    }
}