package strategy;

import cn.edu.whut.sept.zuul.Command;
import cn.edu.whut.sept.zuul.Game;

public abstract class Strategy {
    private Command command = null;
    private Game game = null;

    public Command getCommand(){

        return this.command;
    }

    public Game getGame(){

        return this.game;
    }

    public Strategy(Command command,Game game) {
        this.command = command;
        this.game = game;
    }

    public abstract Object copeWithCommand();
}

