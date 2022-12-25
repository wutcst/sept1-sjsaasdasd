package strategy;

import cn.edu.whut.sept.zuul.Command;
import cn.edu.whut.sept.zuul.Game;

public class StrategyHelp extends Strategy{
    private Game game = null;

    public StrategyHelp(Command command, Game game) {
        super(command,game);
        this.game=game;
    }

    @Override
    public Object copeWithCommand() {
        System.out.println("You are lost. You are alone. You wander");
        System.out.println("around at the university.");
        System.out.println();
        System.out.println("Your command words are:");
        this.game.getParser().showCommands();
        return null;
    }
}

