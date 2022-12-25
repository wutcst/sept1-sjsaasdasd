package strategy;

import cn.edu.whut.sept.zuul.Command;
import cn.edu.whut.sept.zuul.Game;
import cn.edu.whut.sept.zuul.Room;

public class StrategyGo extends Strategy {

    private Command command = getCommand();
    private Game game = getGame();

    public StrategyGo(Command command, Game game) {
        super(command, game);
    }

    @Override
    public Object copeWithCommand() {
        if (!command.hasSecondWord()) {
            // if there is no second word, we don't know where to go...
            System.out.println("Go where?");
            return "Unknow where to Go....";
        }

        String direction = command.getSecondWord();

        // 尝试离开当前房间,前往新房间
        Room nextRoom = game.getCurrentRoom().getExit(direction);

        if (nextRoom==null) {
            System.out.println("There is no door!");
        }
        // 切换房间
        else {
            game.setCurrentRoom(nextRoom);
            System.out.println(game.getCurrentRoom().getLongDescription());
        }
        return "Success moving !";
    }
}

