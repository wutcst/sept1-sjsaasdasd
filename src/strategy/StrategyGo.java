package strategy;

import cn.edu.whut.sept.zuul.Command;
import cn.edu.whut.sept.zuul.Game;
import cn.edu.whut.sept.zuul.Room;
import room.Absroom;

public class StrategyGo extends Strategy {
    /**
     * 调用父类的方法得到数据
     */
    private final Command command = getCommand();
    private final Game game = getGame();

    /**
     * @param command1 读入的命令
     * @param game1    相关Game类
     */
    public StrategyGo(Command command1, Game game1) {

        super(command1, game1);
    }

    /**
     * 重写的方法.
     *
     * @return 用于类型强转
     */
    @Override
    public Object copeWithCommand() {
        if (!command.hasSecondWord()) {
            // if there is no second word, we don't know where to go...
            System.out.println("Go where?");
            return "Unknow where to Go....";
        }

        String direction = command.getSecondWord();
        if(direction.equals("start")){
            game.setCurrentRoom(game.getStartRoom());
            game.setLastRoom(null);
            System.out.println(game.getCurrentRoom().getLongDescription());
        }else{
            // 尝试离开当前房间,前往新房间
            Absroom nextRoom = game.getCurrentRoom().getExit(direction);

            if (nextRoom==null) {
                System.out.println("There is no door!");
            } else { // 切换房间
                //保存上个房间
                game.setLastRoom(game.getCurrentRoom());
                //进入下一个房间
                game.setCurrentRoom(nextRoom);
                System.out.println(game.getCurrentRoom().getLongDescription());
            }
        }

        return "Success moving !";
    }
}

