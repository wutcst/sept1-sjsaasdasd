package strategy;

import cn.edu.whut.sept.zuul.Command;
import cn.edu.whut.sept.zuul.Game;

public class StrategyHelp extends Strategy {

    public StrategyHelp(Command command1, Game game1) {
        super(command1, game1);
    }

    @Override
    public Object copeWithCommand() {
        System.out.println("You are lost. You are alone. You wander");
        System.out.println("around at the university.");
        System.out.println();
        System.out.println("Your command words are:");
        this.getGame().getParser().showCommands();
        return null;
    }
}

