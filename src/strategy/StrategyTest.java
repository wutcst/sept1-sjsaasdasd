package strategy;

import cn.edu.whut.sept.zuul.Command;
import cn.edu.whut.sept.zuul.Game;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StrategyTest {
    private Game game=new Game();
    @Test
    void copeWithCommand() {
        Command help=new Command("help",null);
        game.processCommand(help);
        Command go=new Command("go","east");
        game.processCommand(go);
        Command look=new Command("look",null);
        game.processCommand(look);
        Command back=new Command("back",null);
        game.processCommand(back);
        go=new Command("go","south");
        game.processCommand(go);
        Command item=new Command("item",null);
        game.processCommand(item);
        Command take=new Command("take","cookie");
        game.processCommand(take);
        Command drop=new Command("drop","cookie");
        game.processCommand(drop);
        Command eat=new Command("eat","cookie");
        game.processCommand(eat);
        Command quit=new Command("quit",null);
        game.processCommand(quit);

    }
}