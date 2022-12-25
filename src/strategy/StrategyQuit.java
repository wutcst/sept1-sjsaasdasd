package strategy;

import cn.edu.whut.sept.zuul.Command;
import cn.edu.whut.sept.zuul.Game;

public class StrategyQuit extends Strategy{
    public StrategyQuit(Command command, Game game) {
        super(command,game);
    }

    @Override
    public Object copeWithCommand() {
        Command command = getCommand();
        if(command.hasSecondWord()) {
            System.out.println("Quit what?");
            return false;
        }
        else {
            return true;  // signal that we want to quit
        }
    }
}

