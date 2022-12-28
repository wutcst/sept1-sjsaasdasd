package room;

public interface RoomBuilderFactory {
    /**
     * 利用Absroom的多态性
     * @return 返回一个新建的房间
     */
    public abstract Absroom createRoom();
}
