package strategy;

import cn.edu.whut.sept.zuul.Command;
import cn.edu.whut.sept.zuul.Game;
import room.Absroom;

public class StrategyLook extends Strategy{

    /**
     * @param command1 接收到的命令
     * @param game1    产生反应的Game实体
     */
    public StrategyLook(Command command1, Game game1) {
        super(command1, game1);
    }

    /**
     * @return
     */
    @Override
    public Object copeWithCommand() {
        //抽取当前房间
        Absroom currentRoom=this.getGame().getPlayer().getCurrentRoom();
        System.out.println(currentRoom.getShortDescription());
        currentRoom.showObjects();
        return null;
    }
}
