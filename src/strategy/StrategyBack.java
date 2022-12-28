package strategy;

import cn.edu.whut.sept.zuul.Command;
import cn.edu.whut.sept.zuul.Game;
import room.Absroom;

public class StrategyBack extends Strategy{
    private final Command command = getCommand();
    private final Game game = getGame();
    /**
     * @param command1 接收到的命令
     * @param game1    产生反应的Game实体
     */
    public StrategyBack(Command command1, Game game1) {
        super(command1, game1);
    }

    /**
     * @return
     */
    @Override
    public Object copeWithCommand() {
        //判断是否有上个房间
        if(game.getLastRoom() == null){
            System.out.println("You haven't move!");
            return "default moving !";
        }
        // 尝试离开当前房间,前往新房间
        Absroom nextRoom = game.getLastRoom();

        if (nextRoom==null) {
            System.out.println("There is no door!");
        } else { // 切换房间
            //保存上个房间
            game.setLastRoom(game.getCurrentRoom());
            //进入下一个房间
            game.setCurrentRoom(nextRoom);
            System.out.println(game.getCurrentRoom().getLongDescription());
        }
        return "Success moving !";
    }
}
